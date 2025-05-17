lexer grammar MiniJavaLexer;

@header {
    package fr.n7.stl.minijava.parser;
}

Egal: '=';
AccoladeOuvrante: '{';
AccoladeFermante: '}';
ParentheseOuvrante: '(';
ParentheseFermante: ')';
CrochetOuvrant: '[';
CrochetFermant: ']';
Point: '.';
PointInterrogation: '?';
DeuxPoint: ':';
Virgule: ',';
PointVirgule: ';';
Afficher: 'print';
Si: 'if';
Sinon: 'else';
TantQue: 'while';
Pour: 'for';
Retour: 'return';
DefinitionConstante: 'final';
DefinitionClasse: 'class';
Nouveau: 'new';
Ceci: 'this';

// Operateurs
Asterisque: '*';
Oblique: '/';
PourCent: '%';
Plus: '+';
Moins: '-';
// Operateurs logiques
DoubleBarre: '||';
DoubleEsperluette: '&&';
PointExclamation: '!';
// Operateurs de comparaison
Inf: '<';
Sup: '>';
InfEg: '<=';
SupEg: '>=';
DoubleEgal: '==';
ExclamationEgal: '!=';
Esperluette: '&';
// Types
TypeEntier: 'int';
TypeFlottant: 'float';
TypeBooleen: 'boolean';
TypeCaractere: 'char';
TypeChaine: 'String';
TypeVide: 'void';

Vrai: 'true';
Faux: 'false';
Nul: 'null';
Caractere: '\'' . '\'';
Chaine: '"' .*? '"';

// modificateurs d'accès
Publique: 'public';
Prive: 'private';
Statique: 'static';

Identificateur: [a-zA-Z][a-zA-Z_0-9]*;
Entier: '0' | ([1-9][0-9]*);
Flottant: Entier '.' Entier;
CommentaireLigne: '//' ~[\r\n]* -> skip;
CommentaireBloc: '/*' .*? '*/' -> skip;
WS: [ \t\r\n]+ -> skip;