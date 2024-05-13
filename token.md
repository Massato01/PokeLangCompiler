# PokeLang

### Keywords

| Comando          | PokeLang   |
| ---------------- | ---------- |
| if               | eevee      |
| elif             | leafeon    |
| else             | espeon     |
| for              | forretress |
| while            | poliwhirl  |
| functions        | pokegym    |
| return           | pokecenter |
| print            | pokedex    |
| int              | porygon    |
| float            | porygon2   |
| bool             | disguise   |
| string           | unown      |
| entrada de dados | ???        |
| saida de dados   | ???        |
| break            | ???        |

---

### Integer

`^(-|\+)?\d+$`

### Floating Point

`^(-|\+)?[0-9]\d.\d+)?$`

### Boolean

`^(True|False|0|1)`

### String

`^"[\s\S]$`

### Identifiers

`^([a-zA-Z])+(\w)*`

---

### Operators

```
- +     | plusle    | ^\+$
- -     | minun     | ^\-$
- *     | dialga    | ^\*$
- /     | palkia    | ^\/$
- =     | mew       | ^=$
- ==    | mewtwo    | ^(==)$
- &&    | girafarig | ^(&&)$
- ||    | farigiraf | ^(||)$
- \n    | spoink    | ^\\n$
```

### Exemplos de código

#### Criação de variáveis

- int

```
# Original
int num = 10;

# PokelLang
porygon num = 10;
```

- float

```
# Original
float num = 9.5;

# PokeLang
porygon2 num = 9.5;
```

- string

```
# Original
string txt = "pokemon";

# PokeLang
unown txt = "pokemon";
```

#### Operadores

```
- +     | plusle    | ^\+$
- -     | minun     | ^\-$
- *     | dialga    | ^\*$
- /     | palkia    | ^\/$
- =     | mew       | ^=$
- ==    | mewtwo    | ^(==)$
- &&    | girafarig | ^(&&)$
- ||    | farigiraf | ^(||)$
- \n    | spoink    | ^\\n$
```

#### Loops

- for

```
# Original
for (int i = 0; i < x; i++) {
  system.out.print(i);
}

# PokeLang
forretress (porygon i = 0; i < x; i++) {
    pokedex(i);
}
```

- while

```
# Original
while (x <= 5) {
    System.out.print(x);
    contador++;
}

# PokeLang
poliwhirl (x <= 5) {
    pokedex(x);
    x++;
}
```
