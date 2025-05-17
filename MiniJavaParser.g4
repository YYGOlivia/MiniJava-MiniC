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
	DefinitionClasse nom = Identificateur AccoladeOuvrante membres += membre* AccoladeFermante;

membre:
	attribut // private int a;
	| constructeur // public A() { this.a = 0; }
	| methode; // public int getA() { return this.a; }

attribut:
	// private int a;
	modificateur type identifiant PointVirgule;

constructeur:
	// public A() {...}
	modificateur nom = Identificateur ParentheseOuvrante parametres ParentheseFermante block = bloc;

methode:
	// public int getA() {...}
	modificateur type nom = Identificateur ParentheseOuvrante parametres ParentheseFermante block =
		bloc;

parametres:
	/* vide */
	| type identifiant (
		Virgule suiteType += type suiteIdent += identifiant
	)*;

instruction:
	// if(cond){instructions}
	Si ParentheseOuvrante expression ParentheseFermante alors = bloc
	// if(cond){instructions} else{instructions}
	| Si ParentheseOuvrante expression ParentheseFermante alors = bloc Sinon sinon = bloc
	// while(cond){instructions}
	| TantQue ParentheseOuvrante expression ParentheseFermante body = bloc
	// for (instr, cond, instr) {...}
	| Pour ParentheseOuvrante instruction PointVirgule expression PointVirgule instruction
		ParentheseFermante body = bloc
	| Pour ParentheseOuvrante type identifiant DeuxPoint expression ParentheseFermante body = bloc;

expression:
	ParentheseOuvrante expression ParentheseFermante // (expr)
	| expression Point Identificateur // expr.id
	| expression CrochetOuvrant expression CrochetFermant // expr[expr]
	| Moins expression // -expr
	| gauche = expression op = (Asterisque | Oblique | PourCent) droite = expression // expr * expr
	| gauche = expression op = (Plus | Moins) droite = expression // expr + expr
	| gauche = expression op = (Inf | Sup | InfEg | SupEg) droite = expression // expr < expr
	| gauche = expression op = (DoubleEgal | ExclamationEgal) droite = expression // expr == expr
	| AccoladeOuvrante expression AccoladeFermante // {expr}
	| expression PointInterrogation expression DeuxPoint expression // expr ? expr : expr
	| expressionConstante; // true | false | null ...

type:
	atomique
	| identifiant
	| type CrochetOuvrant CrochetFermant;

identifiant:
	Identificateur // ident
	| ParentheseOuvrante identifiant ParentheseFermante; // (ident)

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