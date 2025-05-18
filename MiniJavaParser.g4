parser grammar MiniJavaParser;
options {
	tokenVocab = MiniJavaLexer;
}

@header {
    package fr.n7.stl.minijava.parser;
	import fr.n7.stl.minijava.ast.Block;
	import fr.n7.stl.minijava.ast.type.AtomicType;
	import fr.n7.stl.minijava.ast.type.Type;
	import fr.n7.stl.minijava.ast.clazz.Modifier;
	import fr.n7.stl.minijava.ast.clazz.Class;
	import fr.n7.stl.minijava.ast.clazz.Attribute;
	import fr.n7.stl.minijava.ast.clazz.Constructor;
	import fr.n7.stl.minijava.ast.clazz.Method;
}

programme:
	(classes += classe)* // class A {...} class B {...}
	mainBlock = bloc; // { A a = new A(); ... }

bloc
	returns[Block b]:
	AccoladeOuvrante instructions += instruction* AccoladeFermante;

classe
	returns[Class c]:
	// class ident {bloc}
	DefClasse nom = Identificateur AccoladeOuvrante membres += membre* AccoladeFermante;

membre:
	attribut // private int a;
	| constructeur // public A() {...}
	| methode; // public int getA() {...}

attribut
	returns[Attribute a]:
	// private int a; | public int a = 0;
	modificateur Final? type Identificateur (Egal expression)? PtVirg;

constructeur
	returns[Constructor c]:
	// public A() {...}
	modificateur nom = Identificateur ParOuv parametres ParFer block = bloc;

methode
	returns[Method m]:
	// public int getA() {...}
	modificateur type nom = Identificateur ParOuv parametres ParFer block = bloc;

parametres:
	/* vide */
	| type Identificateur (
		Virg suiteType += type suiteIdent += Identificateur
	)*;

instruction:
	// if(cond){instructions}
	Si ParOuv expression ParFer alors = bloc
	// if(cond){instructions} else{instructions}
	| Si ParOuv expression ParFer alors = bloc Sinon sinon = bloc
	// while(cond){instructions}
	| TantQue ParOuv expression ParFer body = bloc
	// for (ass | decl; expr; ass) {...}
	| Pour ParOuv (assignation | declLocale) PtVirg expression PtVirg assignation ParFer body = bloc
	// for (int i : array) {...}
	| Pour ParOuv type Identificateur DeuxPoint expression ParFer body = bloc
	| Retour expression PtVirg // return expr;
	| declLocale PtVirg
	| assignation PtVirg;

expression:
	ParOuv expression ParFer // (expr)
	| expression Point Identificateur // expr.id
	| expression Point Identificateur ParOuv expressions? ParFer // expr.id(expr1, expr2, ...)
	| Nouveau Identificateur ParOuv expressions? ParFer // new id(expr1, expr2, ...)
	| expression CrochOuv expression CrochFer // expr[expr]
	| Moins expression // -expr
	| gauche = expression op = (Asterisque | Oblique | PourCent) droite = expression // expr * expr
	| gauche = expression op = (Plus | Moins) droite = expression // expr + expr
	| gauche = expression op = (Inf | Sup | InfEg | SupEg) droite = expression // expr < expr
	| gauche = expression op = (DoubleEgal | ExclamationEgal) droite = expression // expr == expr
	| AccoladeOuvrante expressions AccoladeFermante // {expr1, expr2, ...}
	| expression PointInterrogation expression DeuxPoint expression // expr ? expr : expr
	| expressionConstante // true | false | null ...
	| Ceci Point Identificateur; // this.id

declLocale:
	// final int a = 0
	Final? type Identificateur (Egal expression)?;

assignation:
	// id = expr | id.attribut = expr | id[expr] = expr
	assignable Egal expression;

assignable:
	Identificateur // id
	| assignable Point Identificateur // id.attribut
	| assignable CrochOuv expression CrochFer; // id[expr]

expressions:
	premiere = expression (Virg suite += expression)*; // expr1, expr2, ...

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

modificateur
	returns[Modifier m]: Publique | Prive | Statique;

expressionConstante:
	Vrai				# expressionTrue
	| Faux				# expressionFalse
	| Entier			# expressionInt
	| Flottant			# expressionFloat
	| Caractere			# expressionCharacter
	| Chaine			# expressionString
	| Nul				# expressionNull
	| Identificateur	# expressionAccess;