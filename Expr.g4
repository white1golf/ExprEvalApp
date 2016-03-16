/* Expr.g4 */
grammar Expr;

// parser rules
prog :	(assn ';' NEWLINE? | expr ';' NEWLINE?)* ;
expr :	expr ('*'|'/') expr
     |  expr ('+'|'-') expr
     | INT
     | ID
     | '(' expr ')'
     ;
assn : ID '=' INT
     ;

// lexer rules
NEWLINE : [\r\n]+ ;
INT : [0-9]+ ;
ID : [a-zA-Z]+ ;
WS : [ \t\r\n]+ -> skip ;

