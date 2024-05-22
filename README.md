## Tipos:

- int -> porygon
- double -> squirtle
- string -> unown

---

## Condição:

- if -> eevee
- elif -> leafeon
- else -> espeon

---

## Loop:

- for -> forretress
- while -> poliwhirl

---

## Atribuição:

- input -> pokeball
- print -> pokedex
- tipo variavel -> evolving
- atribuição -> pokecenter

---

# Gramática Livre de Contexto

condicao -> id operador id | id operador num

expressao -> id "=" id | id "=" num

operador -> "=" | "!=" | ">" | "<"

numero -> [0-9]

argumento -> id | numero

tipo ->

---

- IF

```

eevee ( condicao ) { expressao }

```

- ELIF

```

leafeon ( condicao ) { expressao }

```

- ELSE

```

espeon { expressao }

```

- FOR

```

forretress ( expressao ";" condicao ) { expressao }

```

- WHILE

```

poliwhirl ( condicao ) { expressao }

```

- INPUT (ACHO MELHOR TIRAR)

```

pokeball ( tipo )

```

- PRINT

```

pokedex ( argumento ) ";"

```

---

### Exemplo de código:

```
porygon number = pokeball();

forretress (porygon i = 0; i < 11; i++) {
    pokedex(i);
    eevee (i == 10) {
        pokedex("IF: chegou em 10");
    }
}
```
