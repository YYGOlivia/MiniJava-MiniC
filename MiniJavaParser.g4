parser grammar MiniJavaParser;
options {
	tokenVocab = MiniJavaLexer;
}

@header {
    package fr.n7.stl.minijava.parser;
}

programme: classes += classe*;

block:
	AccoladeOuvrante instructions += instruction* AccoladeFermante;

classe:
	// class ident {bloc}
	DefinitionClasse nom = Identificateur AccoladeOuvrante membres += membre* AccoladeFermante;

membre: visibilites (methode | attribut);

attribut: type identifiant PointVirgule;

methode:
	nom = Identificateur ParentheseOuvrante parametres ParentheseFermante bloc = block;

parametres:
	type identifiant (
		Virgule suiteType += type suiteIdent += identifiant
	)*;

instruction:
	// if(cond){instructions}
	Si ParentheseOuvrante expression ParentheseFermante alors = block
	// if(cond){instructions} else{instructions}
	| Si ParentheseOuvrante expression ParentheseFermante alors = block Sinon sinon = block
	// while(cond){instructions}
	| TantQue ParentheseOuvrante expression ParentheseFermante body = block;

expressionBinaire:
	gauche = expression op = (Asterisque | Oblique | PourCent) droite = expression
	| gauche = expression op = (Plus | Moins) droite = expression
	| gauche = expression op = (
		Inferieur
		| Superieur
		| InferieurEgal
		| SuperieurEgal
	) droite = expression;

expression:
	// (expression)
	ParentheseOuvrante expression ParentheseFermante;

atomique:
	TypeEntier
	| TypeFlottant
	| TypeBooleen
	| TypeCaractere
	| TypeChaine
	| TypeVide;

type: atomique | identifiant;

identifiant:
	Identificateur // ident
	| identifiant CrochetOuvrant CrochetFermant // ident[]
	| Asterisque identifiant // *ident
	| ParentheseOuvrante identifiant ParentheseFermante; // (ident)

visibilites: Publique | Prive | Statique;