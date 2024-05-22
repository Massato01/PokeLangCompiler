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

- INPUT

```

pokeball ( tipo );

```

- PRINT

```

pokedex ( argumento ) ";"

```

---

### Exemplo de código:

```
pokedex("Valor:");
porygon number = pokeball();

forretress (porygon i = 0; i < number; i++) {
    pokedex(i);
    eevee (i == 5) {
        pokedex("IF: chegou em 5");
    } espeon {
        eevee (i == 10) {
            pokedex("IF com ELSE: chegou em 10");
        }
    }
}

pokedex("Valor 1:");
porygon inputum = pokeball();

pokedex("Valor 2:");
porygon inputdois = pokeball();

eevee (inputum > inputdois) {
    pokedex("Maior:");
    pokedex(inputum);
} espeon {
    pokedex("Maior:");
    pokedex(inputdois);
}
```
