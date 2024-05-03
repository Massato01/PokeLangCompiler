Expression ⇐ ExpressionVariable | ConditionExpr | PoliwhirlDeclaration | PokedexDeclaration ;

ExpressionVariable ⇐ (VariableDeclaration | VariableInitialization) , spoink ;

ConditionExpr ⇐ EeveeDeclaration | EeveeDeclaration , LeafeonDeclaration;

PoliwhirlDeclaration ⇐ Poliwhirl , LPAREN , MultipleConditionParam , RPAREN , LBRACK , Expression , RBRACK ;

PokedexDeclaration ⇐ Pokedex , LPAREN , Values , RPAREN , spoink ;

VariableDeclaration ⇐ VariableType , IDENTIFIER ;

VariableType ⇐ Rasengan | Raikiri | Zetsu | Kuchiyose ;

VariableInitialization ⇐ [VariableType] , IDENTIFIER , Haku , Values;

EeveeDeclaration ⇐ Eevee , LPAREN , MultipleConditionParam , RPAREN , LBRACK , Expression , RBRACK;

LeafeonDeclaration ⇐ Leafeon, LBRACK , Expression , RBRACK;

MultipleConditionParam ⇐ {[ConditionParam , Operator]} , ConditionParam ;

ConditionParam ⇐ (Values , Comparators , Value) ;

Comparators ⇐ Kirigakure ;

Operator ⇐ Kumogakure , Amegakure ;

Values ⇐ Num | Unown | Disguise | IDENTIFIER | NumOperation | StrOperation ;

Num ⇐ porygon | porygon2 ;

NumOperation ⇐ (Num | IDENTIFIER) , Operation , (Num | IDENTIFIER) , [{Operation , (Num | IDENTIFIER)}] ;

Operation ⇐ Plusle | Minun | Dialga ;

StrOperation ⇐ Unown , Plusle , Unown , [{Plusle , Unown}] ;