# Analisador Sintático

## Gramaticas livres de contexto

### First -> Ok

```txt
first -> depende first | fazDeNovo first | eOSeuNegocio first | olhaSo first | variavel first | comentario first | olhaSo first | ε
```

### Depende - IF -> Ok

```txt
depende -> depende ( condicao ) { first } planoB
planoB -> planoB { first } | ε
condicao -> [variavel operador variavel]⁺ | ε
variavel -> id | num | flutuante | string | ( mathExpressao )
operador -> ">" | "<" | "==" | "!=" | "&&" | "||" | "+" | "-" | "\" | "*" | "/" | "="
expressao -> first ";"

mathExpressao -> math mathExpressao’
mathExpressao’ -> +math mathExpressao’ | -math mathExpressao’ | ε
math -> variavel math´
math´ -> *variavel math´ | /variavel math´ | ε

id -> [a-zA-Z]⁺
num -> [0-9]⁺
flutuante -> num⁺.num⁺
string -> "(id+num+flutuante)"
```

### EOSeuNegocio - For -> Ok

```txt
eOSeuNegocio -> eOSeuNegocio ( varContador ";" condicao ";" incremento ) { first }
varContador -> tipoVariavel variavel operador num
condicao -> variavel operador variavel
incremento -> id operador incremento'
incremento' -> num | ε

tipoVariavel -> taOk | gaviao | caixaPreta
variavel -> id | num | flutuante | string
operador -> ">" | "<" | "<=" | ">=" | "+=" | "-=" | "++" | "--"

id -> [a-zA-Z]⁺
num -> [0-9]⁺ | ε
flutuante -> num⁺.num⁺ | ε
string -> "(id+num+flutuante)"
```

### FazDeNovo - While -> Ok

```txt
while -> fazDeNovo ( condicao ) { first }
condicao -> variavel operador variavel

varivel -> id | num | flutuante | string | ( mathExpressao )
operador -> ">" | "<" | "<=" | ">=" | "+=" | "-=" | "++" | "--"

id -> [a-zA-Z]⁺
num -> [0-9]⁺
flutuante -> num.num
string -> "\"" (id | num | flutuante) "\""
```

### Atribuição Variável -> Ok

```txt
atribVariavel -> tipoVariavel variavel "=" mathExpressao ";"
tipoVariavel -> taOk | gaviao | caixaPreta
variavel -> id | num | flutuante | string

mathExpressao -> TmathExpressao’
mathExpressao’ -> +TmathExpressao’ | -TmathExpressao’ | ε
math -> Fmath´
math´ -> *Fmath´ | /Fmath´ | ε

F -> id | num | flutuante | input | ( mathExpressao )

id -> [a-zA-Z]⁺
num -> [0-9]⁺
flutuante -> num.num
string -> " (id + num + flutuante) "
```

### Comentário -> Ok

```txt
comentario -> # texto

texto -> [a-zA-Z0-9]⁺
```

### OlhaSo -> Print -> Ok

```txt
print -> olhaSo ( texto ) ;
texto -> id | num | flutuante | string

id -> [a-zA-Z]⁺
num -> [0-9]⁺
flutuante -> num.num
string -> " (id + num + flutuante) "
```

### Receba -> Input ->

```txt
input -> receba ( )
```
