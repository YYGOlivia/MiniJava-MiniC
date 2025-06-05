parser grammar MiniJavaParser;
options {
	tokenVocab = MiniJavaLexer;
}

@header {
package fr.n7.stl.minijava.parser;
import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.FunctionType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.declaration.AccessRight;
import fr.n7.stl.minijava.ast.type.declaration.AttributeDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ClassElement;
import fr.n7.stl.minijava.ast.type.declaration.ConstructorDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.MainDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.MethodDeclaration;
}

programme: lesClasses = classes laPrincipale = principale;

classes
	returns[List<ClassDeclaration> desClasses]:
	lesClasses += classe*;

classe
	returns[ClassDeclaration uneClasse]:
	estAbstraite = Abstrait? Classe leNom = Ident (
		Herite heriteDe = Ident
	)? AccOuv lesElements = elements AccFer;

principale
	returns[MainDeclaration unPrincipal]:
	// public class foo { ... public static void main (String[] args) {...} }
	Public Classe leNom = Ident AccOuv lesDeclarations += declaration* Public Statique TypeVide
		MethodeMain ParOuv TypeChaine CrochOuv CrochFer Ident ParFer leCorps = bloc AccFer;

declaration
	returns[Declaration uneDeclaration]:
	// static type ident(...) {...}
	Statique laSignature = signature leCorps = bloc # methodeMain
	// static final? expr ident = expr;
	| Statique estFinal = Final? leType = type leNom = Ident Egal laValeur = expression PtVirg #
		attributMain;

elements
	returns[List<ClassElement> desElements]:
	lesElements += element*;

accessRight
	returns[AccessRight unDroit]: Public | Protege | Prive;

element
	returns[ClassElement unElement]:
	leDroit = accessRight (attribut | methode | constructeur); 

attribut
	returns[AttributeDeclaration unAttribut]:
	leType = type leNom = Ident PtVirg															# attributObjet
		/* int id; */
	| Statique estFinal = Final? leType = type leNom = Ident Egal laValeur = expression PtVirg	#
		attributClasse;
		/* static (final) int id = expr; */

methode
	returns[MethodDeclaration uneMethode]:
	estFinal = Final? laSignature = signature leCorps = bloc	# methodeObjet
		/* final? sig{...} */
	| Statique Final? laSignature = signature leCorps = bloc	# methodeClasse
		/* static final? sig{...} */
	| Abstrait laSignature = signature PtVirg					# methodeAbstraite;
		/* abstract sig; */

signature
	returns[FunctionType uneSignature]:
	leRetour = type leNom = Ident ParOuv lesParametres = parametres ParFer;
		/* type id(params) */

constructeur
	returns[ConstructorDeclaration unConstructeur]:
	leNom = Ident ParOuv lesParametres = parametres ParFer leCorps = bloc;
		/* Id(params){...} */

bloc
	returns[Block unBloc]:
	AccOuv lesInstructions += instruction* AccFer;

// Liste de declarations de paramètres séparées par une virgule, peut être vide.
parametres
	returns[List<ParameterDeclaration> desParametres]:
	/* vide */
	| lesParametres += parametre (
		Virgule lesParametres += parametre
	)*;

parametre
	returns[ParameterDeclaration unParametre]:
	leType = type leNom = Ident;

instruction
	returns[Instruction uneInstruction]:
	leType = type leNom = Ident Egal laValeur = expression PtVirg					# instructionDeclaration
		/* type id = expr; */
	| leRecepteur = affectable Egal laValeur = expression PtVirg					# instructionAffectation
		/* id = expr; */
	| Afficher laValeur = expression PtVirg											# instructionAffichage
		/* print(expr); */
	| Si ParOuv cond = expression ParFer alors = bloc Sinon sinon = bloc			# instructionSiSinon
		/* if(expr){...} else{...} */
	| Si ParOuv cond = expression ParFer alors = bloc								# instructionSi
		/* if(expr){...} */
	| Retour laValeur = expression PtVirg											# instructionReturn
		/* return expr; */
	| TantQue ParOuv cond = expression ParFer leCorps = bloc						# instructionIteration
		/* while(expr){...} */
	| lObjet = expression Pt leNom = Ident ParOuv args = arguments ParFer PtVirg	#
		instructionAppelMethodeExplicite
		/* expr.id(args); */
	| leNom = Ident ParOuv args = arguments ParFer PtVirg	# instructionAppelMethodeImplicite
		/* id(args); */
	| Moi ParOuv args = arguments ParFer PtVirg				# instructionAppelConstructeurAlternatif
		/* this(args); */
	| Super ParOuv args = arguments ParFer PtVirg			# instructionAppelConstructeurParent;
		/* super(args); */

atomique
	returns[AtomicType unTypeAtomique]:
	TypeEntier
	| TypeFlottant
	| TypeBooleen
	| TypeCaractere
	| TypeChaine
	| TypeVide;

type
	returns[Type unType]:
	leTypeAtomique = atomique				# typeAtomique
	| leNom = Ident							# typeClasse
	| leTypeValeur = type CrochOuv CrochFer	# typeTableau;
		/* type[] */

affectable
	returns[AssignableExpression uneExpressionAffectable]:
	lIdent = Ident															# ecritureIdent
	| leTableau = affectable CrochOuv lIndice = expression CrochFer			# ecritureTableau
		/* tab[i] */
	| ParOuv leType = type ParFer lAffectable = affectable					# ecritureConversion
		/* (type) aff */
	| lObjet = affectable Pt leNom = Ident									# ecritureAttribut
		/* aff.id */
	| lObjet = affectable Pt leNom = Ident ParOuv args = arguments ParFer	#
		ecritureAppelMethodeExplicite
		/* aff.id(args) */
	| leNom = Ident ParOuv args = arguments ParFer	# ecritureAppelMethodeImplicite
		/* id(args) */
	| leMoi = Moi									# ecritureThis
		/* this */
	| leSuper = Super								# ecritureSuper;
		/* super */

// Liste d'expressions séparées par une virgule, ne peut pas être vide
expressions
	returns[List<AccessibleExpression> desExpressions]:
	lesExpressions += expression (
		Virgule lesExpressions += expression
	)*;

// Liste d'expressions séparées par une virgule, peut être vide
arguments
	returns[List<AccessibleExpression> desArguments]:
	/* Vide */
	| lesExpressions = expressions;

// Les expressions vont du plus prioritaire (en haut) au moins prioritaire (en bas).
expression
	returns[AccessibleExpression uneExpression]:
	ParOuv lExpression = expression ParFer									# expressionParenthese
		/* (expr) */
	| lObjet = expression Pt leNom = Ident									# lectureAttribut
		/* expr.id */
	| lobjet = expression Pt leNom = Ident ParOuv args = arguments ParFer	# lectureAppelMethodeExplicite
		/* axpr.id(args) */
	| leNom = Ident ParOuv args = arguments ParFer										# lectureAppelMethodeImplicite
		/* id(args) */
	| leTableau = expression CrochOuv lIndice = expression CrochFer						# lectureTableau
		/* tab[i] */
	| Nouveau leType = type CrochOuv laTaille = expression CrochFer						# creationTableau
		/* new type[size] */
	| Nouveau leNom = Ident ParOuv args = arguments ParFer								# creationObjet
		/* new Id(args) */
	| PtExclamation leParametre = expression											# expressionNegation
	| Moins leParametre = expression													# expressionOpposee
	| gauche = expression op = (Asterisque | Oblique | PourCent) droite = expression	# exprMult
	| gauche = expression op = (Plus | Moins) droite = expression						# exprAdd
	| gauche = expression op = (Inf | InfEg | Sup | SupEg) droite = expression			# exprCompar
	| gauche = expression op = (DoubleEgal | Different) droite = expression				# expressionEgalite
	| gauche = expression op = Et droite = expression									# expressionConjonction
	| gauche = expression op = Ou droite = expression									# expressionDisjonction
	| cond = expression PtInterro exprAlors = expression DeuxPt exprSinon = expression	# exprCond
	| ParOuv leType = type ParFer expression											# expressionConversion
	| Vrai																				# expressionTrue
	| Faux																				# expressionFalse
	| Entier																			# expressionInt
	| Flottant																			# expresionFloat
	| Caractere																			# expressionCharacter
	| Chaine																			# expressionString
	| Nul																				# expressionNull
	| leNom = Ident																		# lectureIdent
	| Moi																				# lectureThis
	| Super																				# lectureSuper;