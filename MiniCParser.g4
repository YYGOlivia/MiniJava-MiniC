parser grammar MiniCParser;
options { tokenVocab=MiniCLexer; }

@header {
package fr.n7.stl.minic.parser;
import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.PartialType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minic.ast.type.declaration.FieldDeclaration;
import fr.n7.stl.minic.ast.type.declaration.LabelDeclaration;
}

programme : name=Identificateur main=bloc; // name bloc

bloc returns [Block b]: AccoladeOuvrante instructions += instruction* AccoladeFermante; // {instructions}

// Liste de declarations de paramètres séparées par une virgule, peut être vide.
parametres returns [List<ParameterDeclaration> l]:
    /* vide */ 
    | 
    type1=type ident1=identifiant (Virgule suiteType+=type suiteIdent+=identifiant)* // int par1, int par2...
;

instruction returns [Instruction i]: 
    (DefinitionConstante | /* vide */) type identifiant Egal expression PointVirgule #instructionDeclaration /* const int a = expr; | int a = expr; */ 
    | DefinitionType type identifiant PointVirgule #instructionTypeDeclaration /* typedef int a; */ 
    | type identifiant ParentheseOuvrante parametres ParentheseFermante bloc #instructionFunctionDeclaration /* void func(param){instructions}; */ 
    | affectable Egal valeur=expression PointVirgule #instructionAffectation /* a = expr; */
    | Afficher expression PointVirgule #instructionAffichage /* print(expr); */
    | Si ParentheseOuvrante expression ParentheseFermante alors=bloc Sinon sinon=bloc #instructionSiSinon /* if(cond){instructions} else{instructions} */
    | Si ParentheseOuvrante expression ParentheseFermante alors=bloc #instructionSi /* if(cond){instructions} */
    | Retour expression PointVirgule #instructionReturn /* return expr; */
    | TantQue ParentheseOuvrante expression ParentheseFermante body=bloc #instructionIteration /* while(cond){instructions} */
;

atomique returns [AtomicType t]:
    TypeEntier
    | TypeFlottant
    | TypeBooleen
    | TypeCaractere
    | TypeChaine
    | TypeVide
;

champ returns [FieldDeclaration f]:
    type identifiant PointVirgule; /* int a; */

// Liste d'etiquettes séparées par une virgule, ne peut pas être vide
etiquettes returns [List<LabelDeclaration> l]:
    premiere=Identificateur (Virgule suite+=Identificateur)* /* a, b, ... */
;

type returns [Type t]:
    atomique #typeAtomic
    | Identificateur #typeNamed // nomDeType
    | Inferieur gauche=type Virgule droite=type Superieur #typeCouple /* <int,string> */
    | Enregistrement Identificateur AccoladeOuvrante champs+=champ+ AccoladeFermante #typeRecord /* struct id{fields} */
    | Enumeration Identificateur AccoladeOuvrante etiquettes AccoladeFermante #typeEnum /* enum id{etiquettes} */
;

affectable returns [AssignableExpression a]:
    ident=Identificateur  #affectableIdentifiant // id
    | Asterisque expression #affectablePointer // *id
    | affectable CrochetOuvrant expression CrochetFermant #affectableArray // id[expr]
    | ParentheseOuvrante (Identificateur | atomique) ParentheseFermante affectable #affectableConversion // (int) id
    | affectable Point Identificateur #affectableField // id.attribut
;

// Liste d'expressions séparées par une virgule, ne peut pas être vide
expressions returns [List<AccessibleExpression> l]:
    premiere=expression (Virgule suite+=expression)*; /* expr1, expr2, ... */

// Liste d'expressions séparées par une virgule, peut être vide
arguments returns [List<AccessibleExpression> l]:
    /* Vide */ 
    | expressions
;

// Les expressions vont du plus prioritaire (en haut) au moins prioritaire (en bas).
expression returns [AccessibleExpression e]:
    ParentheseOuvrante expression ParentheseFermante #expressionParenthese /* (expr) */
    | expression Point Identificateur #expressionField /* expr.id */
    | tableau=expression CrochetOuvrant indice=expression CrochetFermant #expressionArrayAcess /* array[indice] */
    | PointExclamation expr=expression #expressionNot
    | Premier expression #expressionFirst /* fst expr */
    | Second expression #expressionSecond /* snd expr */
    | Moins expression #expressionOpposite /* -expr */
    | Nouveau type CrochetOuvrant expression CrochetFermant #expressionArrayAllocation /* new int[expr] */
    | Nouveau type ParentheseOuvrante ParentheseFermante #expressionPointerAllocation /* new int() */
    | gauche=expression op=(Asterisque | Oblique | PourCent) droite=expression #expressionMultiplicative /* expr*expre | expr/expr | expr%expr */
    | gauche=expression op=(Plus | Moins) droite=expression #expressionAdditive /* expr+expr | expr-expr */
    | gauche=expression op=(Inferieur | InferieurEgal | Superieur | SuperieurEgal) droite=expression #expressionInequality /* expr<expr | expr>expr ... */
    | gauche=expression op=(DoubleEgal | ExclamationEgal) droite=expression #expressionEquality /* expr==expr | expr!=expr */
    | gauche=expression DoubleEsperluette droite=expression #expressionAnd /* expr&&expr */
    | gauche=expression DoubleBarre droite=expression #expressionOr /* expr||expr */
    | condition=expression PointInterrogation alors=expression DeuxPoint sinon=expression #expressionConditional /* expr ? expr : expr */
    | AccoladeOuvrante expressions AccoladeFermante #expressionSequence /* {expr} */
    | Inferieur gauche=expression Virgule droite=expression Superieur #expressionCouple /* <expr,expr> */
    | Identificateur ParentheseOuvrante arguments ParentheseFermante #expressionFunctionCall /* id(args) */
    | Asterisque expression #expressionPointerAccess /* *expr */
    | Esperluette affectable #expressionAddress /* &affect */
    | ParentheseOuvrante (Identificateur | atomique) ParentheseFermante expression #expressionConversion /* (int) expr */
    | Vrai #expressionTrue
    | Faux #expressionFalse
    | Entier #expressionInt
    | Flottant #expresionFloat
    | Caractere #expressionCharacter
    | Chaine #expressionString
    | Nul #expressionNull
    | Identificateur #expressionAccess

;


identifiant returns [fr.n7.stl.util.Pair<String, PartialType> id] :
    identifiant CrochetOuvrant CrochetFermant
    | Asterisque identifiant
    | ParentheseOuvrante identifiant ParentheseFermante
    | Identificateur
;