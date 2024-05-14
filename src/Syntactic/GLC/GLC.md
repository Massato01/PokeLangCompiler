Gramática Livre de Contexto


condicao -> id operador id | id operador num

expressao -> id "=" id | id "=" num

operador -> "=" | "!=" | ">" | "<" 

numero -> [0-9]

argumento -> id | numero


IF -> eevee ( condicao ) { expressao }

ELIF -> leafeon ( condicao ) { expressao }

ELSE -> espeon { expressao }

FOR -> forretress ( expressao ";" condicao ) { expressao }

WHILE -> poliwhirl ( condicao ) { expressao }

PRINT -> pokedex ( argumento ) ";"
