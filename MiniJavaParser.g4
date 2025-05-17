parser grammar MiniJavaParser;
options {
	tokenVocab = MiniJavaLexer;
}

@header {
    package fr.n7.stl.minijava.parser;
}

programme:
	(classes += classe)* // class A {...} class B {...}
	mainBlock = bloc; // { A a = new A(); ... }

bloc:
	AccoladeOuvrante instructions += instruction* AccoladeFermante;

classe:
	// class ident {bloc}
	DefClasse nom = Identificateur AccoladeOuvrante membres += membre* AccoladeFermante;

membre:
	attribut // private int a;
	| constructeur // public A() {...}
	| methode; // public int getA() {...}

attribut:
	// private int a; | public int a = 0;
	modificateur Final? type Identificateur (Egal expression)? PointVirgule;

constructeur:
	// public A() {...}
	modificateur nom = Identificateur ParOuv parametres ParFer block = bloc;

methode:
	// public int getA() {...}
	modificateur type nom = Identificateur ParOuv parametres ParFer block = bloc;

parametres:
	/* vide */
	| type Identificateur (
		Virgule suiteType += type suiteIdent += Identificateur
	)*;

instruction:
	// if(cond){instructions}
	Si ParOuv expression ParFer alors = bloc
	// if(cond){instructions} else{instructions}
	| Si ParOuv expression ParFer alors = bloc Sinon sinon = bloc
	// while(cond){instructions}
	| TantQue ParOuv expression ParFer body = bloc
	// for (instr; cond; instr) {...}
	| Pour ParOuv instruction PointVirgule expression PointVirgule instruction ParFer body = bloc
	// for (int i : array) {...}
	| Pour ParOuv type Identificateur DeuxPoint expression ParFer body = bloc
	| declarationLocale
	| assignation;

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
	| expressionConstante; // true | false | null ...

declarationLocale:
	// final int a = 0;
	Final? type Identificateur (Egal expression)? PointVirgule;

assignation:
	// id = expr; | id.attribut = expr; | id[expr] = expr;
	assignable Egal expression PointVirgule;

assignable:
	Identificateur
	| assignable Point Identificateur // id.attribut
	| assignable CrochOuv expression CrochFer; // id[expr]

expressions:
	premiere = expression (Virgule suite += expression)*; // expr1, expr2, ...

type:
	atomique // int
	| Identificateur // A
	| type CrochOuv CrochFer; // int[]

atomique:
	TypeEntier
	| TypeFlottant
	| TypeBooleen
	| TypeCaractere
	| TypeChaine
	| TypeVide;

modificateur: Publique | Prive | Statique;

expressionConstante:
	Vrai
	| Faux
	| Nul
	| Entier
	| Flottant
	| Caractere
	| Chaine
	| Nul
	| Identificateur;