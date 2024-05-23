## Tipos:

- int -> porygon
- double -> squirtle
- ![image](https://github.com/Massato01/PokeLangCompiler/assets/106417053/6ae63308-a719-425c-a729-0ac98bd177d0)
- string -> unown
- ![image](https://github.com/Massato01/PokeLangCompiler/assets/106417053/4bd9a4c0-0f3b-431f-99a0-9661827a8d39)


---

## Condição:

- if -> eevee
- ![image](https://github.com/Massato01/PokeLangCompiler/assets/106417053/5d25cc53-2621-4a1a-b4b2-293d1c99f4c1)
- else -> espeon
- ![image](https://github.com/Massato01/PokeLangCompiler/assets/106417053/1507bd1b-5070-4a9a-b9ab-dae89fc7427c)

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

operador -> "=" | "!=" | ">" | "<" | "+" | "-" | "*" | "/"

numero -> [0-9]

argumento -> id | numero

tipo -> 

---

- IF

```

eevee ( condicao ) { expressao }

```

- ELSE

```

espeon { expressao }

```

- FOR

```

forretress ( contador ";" condição ";" incremento ) { expressao }

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
