parser grammar MiniJavaParser;
options {
	tokenVocab = MiniJavaLexer;
}

@header {
    package fr.n7.stl.minijava.parser;
}

block
	returns[Block b]:
	AccoladeOuvrante instructions += instruction* AccoladeFermante;

classe
	returns[ClassDeclaration c]:
	// class ident {bloc}
	DefinitionClasse bloc = block;

instruction
	returns[Instruction i]:
	// if(cond){instructions}
	Si ParentheseOuvrante expression ParentheseFermante alors = block
	// if(cond){instructions} else{instructions}
	| Si ParentheseOuvrante expression ParentheseFermante alors = block Sinon sinon = block
	// while(cond){instructions}
	| TantQue ParentheseOuvrante expression ParentheseFermante body = block;

expressionBinaire
	returns[Expression e]:
	gauche = expression op = (Asterisque | Oblique | PourCent) droite = expression
	| gauche = expression op = (Plus | Moins) droite = expression
	| gauche = expression op = (Inferieur | Superieur | InferieurEgal | SuperieurEgal) droite=expression;

expression
	returns[Expression e]:
	// (expression)
	ParentheseOuvrante expression ParentheseFermante;

atomique
	returns[AtomicType t]:
	TypeEntier
	| TypeFlottant
	| TypeBooleen
	| TypeCaractere
	| TypeChaine
	| TypeVide;

identifiant
	returns[fr.n7.stl.util.Pair<String, PartialType> id]:
	Identificateur // ident
	| identifiant CrochetOuvrant CrochetFermant // ident[]
	| Asterisque identifiant // *ident
	| ParentheseOuvrante identifiant ParentheseFermante; // (ident)