lexer grammar MiniJavaLexer;

@header {
package fr.n7.stl.minijava.parser;
}

Egal: '=';
AccOuv: '{';
AccFer: '}';
ParOuv: '(';
ParFer: ')';
CrochOuv: '[';
CrochFer:']';
Pt: '.';
PtInterro: '?';
DeuxPt: ':';
Virgule: ',';
PtVirg: ';';
Afficher: 'print';
Si: 'if';
Sinon: 'else';
Retour: 'return';
TantQue: 'while';
Nouveau: 'new';

// Ajout miniJava
Classe: 'class';
Herite: 'extends';
Public: 'public';
Prive: 'private';
Statique: 'static';
Final: 'final';
Moi: 'this';
Super: 'super';
// ClassePrincipale: 'Main';
MethodeMain: 'main';
Abstrait: 'abstract';
Protege: 'protected';
// Fin de l'ajout miniJava

// Operateurs
// Par défaut, les opérateurs sont associatifs à gauche
Asterisque: '*';
Oblique: '/';
PourCent: '%';
Plus: '+';
Moins: '-';
// Operateurs logiques
Ou: '||';
Et: '&&';
PtExclamation: '!';
// Operateurs de comparaison
Inf: '<';
Sup: '>';
InfEg: '<=';
SupEg: '>=';
DoubleEgal: '==';
Different: '!=';
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

Underscore: '_';
Ident: ([a-zA-Z]|Underscore)([a-zA-Z_0-9]|Underscore)*;
Entier: '0' | ([1-9][0-9]*);
Flottant: Entier '.' Entier;

// Commentaires de ligne
CommentaireLigne: '//' ~[\r\n]* -> skip;

// Commentaires de bloc
CommentaireBloc: '/*' .*? '*/' -> skip;

// Blancs
WS: [ \t\r\n]+ -> skip;
