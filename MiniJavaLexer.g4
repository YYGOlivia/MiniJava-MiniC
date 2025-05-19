lexer grammar MiniJavaLexer;

@header {
    package fr.n7.stl.minijava.parser;
}

Egal: '=';
AccoladeOuvrante: '{';
AccoladeFermante: '}';
ParOuv: '(';
ParFer: ')';
CrochOuv: '[';
CrochFer: ']';
Point: '.';
PtInterro: '?';
DeuxPoint: ':';
Virg: ',';
PtVirg: ';';
Afficher: 'print';
Si: 'if';
Sinon: 'else';
TantQue: 'while';
Pour: 'for';
Retour: 'return';
Final: 'final';
DefClasse: 'class';
Nouveau: 'new';
Ceci: 'this';

// Operateurs
Asterisque: '*';
Oblique: '/';
PourCent: '%';
Plus: '+';
Moins: '-';
// Operateurs logiques
Ou: '||';
Et: '&&';
PointExclamation: '!';
// Operateurs de comparaison
Inf: '<';
Sup: '>';
InfEg: '<=';
SupEg: '>=';
DoubleEgal: '==';
Different: '!=';
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

// modificateurs
Publique: 'public';
Abstrait: 'abstract';
Prive: 'private';
Statique: 'static';
Protege: 'protected';

// héritage
Etend: 'extends';

Identificateur: [a-zA-Z][a-zA-Z_0-9]*;
Entier: '0' | ([1-9][0-9]*);
Flottant: Entier '.' Entier;
CommentaireLigne: '//' ~[\r\n]* -> skip;
CommentaireBloc: '/*' .*? '*/' -> skip;
WS: [ \t\r\n]+ -> skip;