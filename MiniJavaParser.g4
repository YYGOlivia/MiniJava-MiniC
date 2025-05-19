parser grammar MiniJavaParser;
options {
	tokenVocab = MiniJavaLexer;
}

@header {
    package fr.n7.stl.minijava.parser;
	import fr.n7.stl.minijava.ast.Block;
	import fr.n7.stl.minijava.ast.type.AtomicType;
	import fr.n7.stl.minijava.ast.type.Type;
	import fr.n7.stl.minijava.ast.instruction.declaration.clazz.Modifier;
	import fr.n7.stl.minijava.ast.instruction.declaration.clazz.ClassDeclaration;
	import fr.n7.stl.minijava.ast.instruction.declaration.clazz.AttributeDeclaration;
	import fr.n7.stl.minijava.ast.instruction.declaration.clazz.ConstructorDeclaration;
	import fr.n7.stl.minijava.ast.instruction.declaration.clazz.MethodDeclaration;
	import fr.n7.stl.minijava.ast.instruction.declaration.clazz.Definition;
	import fr.n7.stl.minijava.ast.instruction.Instruction;
	import fr.n7.stl.minijava.ast.instruction.declaration.ParameterDeclaration;
	import fr.n7.stl.minijava.ast.expression.Expression;
}

programme
	returns[List<ClassDeclaration> classes]: classe*;

classe
	returns[ClassDeclaration c]:
	mod = (Publique | Abstrait)? DefClasse name = Identificateur (
		Etend parent = Identificateur
	)? AccoladeOuvrante defs += definition* AccoladeFermante;

definition
	returns[Definition def]:
	(Publique | Protege | Prive) (
		constructeur
		| methode
		| attribut
	);

constructeur
	returns[ConstructorDeclaration c]:
	Identificateur ParOuv parametres ParFer corps;

methode
	returns[MethodDeclaration m]:
	Statique? entete corps // int getA(...){...}
	| Abstrait entete PtVirg; // abstract int getA(...);

attribut
	returns[AttributeDeclaration a]:
	Statique isFinal = Final? type Identificateur Egal expr PtVirg // static final int a = 0;
	| type Identificateur PtVirg; // int a;

entete: type Identificateur ParOuv parametres ParFer;

corps:
	// {...}
	AccoladeOuvrante instr* AccoladeFermante;

parametres
	returns[List<ParameterDeclaration> l]:
	//vide
	| type1 = type ident = Identificateur (
		Virg suiteType += type suiteIdent = Identificateur
	)*; // int a, int b

instr
	returns[Instruction i]:
	// if(cond){instructions}
	Si ParOuv expr ParFer alors = corps
	// if(cond){instructions} else{instructions}
	| Si ParOuv expr ParFer alors = corps Sinon sinon = corps
	// while(cond){instructions}
	| TantQue ParOuv expr ParFer body = corps
	// for (ass | decl; expr; ass) {...}
	| Pour ParOuv (assignation | declLocale) PtVirg expr PtVirg assignation ParFer body = corps
	// for (int i : array) {...}
	| Pour ParOuv type Identificateur DeuxPoint expr ParFer body = corps
	| Retour expr PtVirg // return expr;
	| declLocale PtVirg
	| assignation PtVirg;

expr
	returns[Expression e]:
	ParOuv expr ParFer /* (expr) */				# exprParenthesee
	| expr Point Identificateur /* expr.id */	# exprAttribute
	/* expr.id(expr1, expr2, ...) */
	| expr Point Identificateur ParOuv expressions? ParFer # exprMethodCall
	/* new id(expr1, expr2, ...) */
	| Nouveau Identificateur ParOuv expressions? ParFer										# exprConstructorCall
	| expr CrochOuv expr CrochFer /* expr[expr] */											# exprArrayAccess
	| PointExclamation droite = expr /* !expr */											# exprNot
	| Moins droite = expr /*  -expr */														# exprOposite
	| gauche = expr op = (Asterisque | Oblique | PourCent) droite = expr /* expr * expr*/	# exprMult
	| gauche = expr op = (Plus | Moins) droite = expr /* expr + expr*/						# exprAdd
	| gauche = expr op = (Inf | Sup | InfEg | SupEg) droite = expr /* expr < expr*/			# exprIneq
	| gauche = expr op = (DoubleEgal | Different) droite = expr /* expr == expr*/			# exprEq
	| gauche = expr op = Et droite = expr /* expr && expr*/									# exprAnd
	| gauche = expr op = Ou droite = expr /* expr || expr*/									# exprOr
	| cond = expr PtInterro alors = expr DeuxPoint sinon = expr /* expr ? expr : expr*/		# exprCond
	| AccoladeOuvrante expressions AccoladeFermante /* {expr1, expr2, ...}*/				# exprSequence
	| expressionConstante /* true | false | null ...*/										# exprConstante
	| Ceci Point Identificateur /* this.id*/												# exprThis
	/* this.id(expr1, ...)*/
	| Ceci Point Identificateur ParOuv expressions? ParFer # exprThisMethodCall;
declLocale:
	// final int a = 0
	Final? type Identificateur (Egal expr)?;

assignation:
	// id = expr | id.attribut = expr | id[expr] = expr
	assignable Egal expr;

assignable:
	Identificateur // id
	| assignable Point Identificateur // id.attribut
	| assignable CrochOuv expr CrochFer; // id[expr]

expressions
	returns[List<Expression> l]:
	premiere = expr (Virg suite += expr)*; // expr1, expr2, ...

type
	returns[Type t]:
	atomique					# typeAtomic // int
	| Identificateur			# typeNamed // A
	| type CrochOuv CrochFer	# typeArray; // int[]

atomique
	returns[AtomicType t]:
	TypeEntier
	| TypeFlottant
	| TypeBooleen
	| TypeCaractere
	| TypeChaine
	| TypeVide;

expressionConstante
	returns[Expression e]:
	Vrai				# exprTrue
	| Faux				# exprFalse
	| Entier			# exprInt
	| Flottant			# exprFloat
	| Caractere			# exprCharacter
	| Chaine			# exprString
	| Nul				# exprNull
	| Identificateur	# exprAccess;