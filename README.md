| INTEGRANTES                  | RA           |
| ---------------------------- | ------------ |
| Carlos Massato Horibe Chinen | 22.221.010-6 |
| Vinicius Alves Pedro         | 22.221.036-1 |
| Gabriel Nunes Missima        | 22.221.040-3 |
| Matheus T. da Silva Arcanjo  | 22.221.020-5 |

# Projeto de Compiladores

## PokeLang

#### O PokeLangCompiler é um projeto de compiladores de linguagem de programação inspirado no mundo dos Pokémon. Ele permite que os desenvolvedores escrevam código em uma linguagem de programação fictícia baseada em nomes e conceitos relacionados a Pokémon. O Compilador foi desenvolvido em Java, assim como a tradução do código é feita na linguagem Java. Vamos dar uma olhada nos principais aspectos do projeto:

# Tipos:

#### O compilador suporta três tipos de dados principais, cada um associado a um Pokémon específico:

## int (inteiro) -> Porygon:

### Representa valores inteiros, como contadores, índices e quantidades.

![image](https://github.com/Massato01/PokeLangCompiler/assets/106417053/974b2b4f-210d-4748-ad78-cb4caa22ed31)

## double (ponto flutuante) -> Squirtle:

### Lida com números de ponto flutuante, como valores decimais.

![image](https://github.com/Massato01/PokeLangCompiler/assets/106417053/6ae63308-a719-425c-a729-0ac98bd177d0)

## string (cadeia de caracteres) -> Unown:

### Armazena sequências de caracteres, como mensagens de texto.

![image](https://github.com/Massato01/PokeLangCompiler/assets/106417053/4bd9a4c0-0f3b-431f-99a0-9661827a8d39)

---

# Condição:

#### O PokeLangCompiler oferece estruturas de controle familiares, mas com nomes temáticos:

## if (se) -> Eevee:

### Permite tomar decisões com base em condições. Se a condição for verdadeira, o bloco de código dentro do if é executado.

![image](https://github.com/Massato01/PokeLangCompiler/assets/106417053/5d25cc53-2621-4a1a-b4b2-293d1c99f4c1)

## else (senão) -> Espeon:

### Opcionalmente, pode ser usado após um if. Se a condição do if não for atendida, o bloco de código dentro do else é executado.

![image](https://github.com/Massato01/PokeLangCompiler/assets/106417053/1507bd1b-5070-4a9a-b9ab-dae89fc7427c)

---

# Loop:

#### Os loops permitem que o código seja executado repetidamente. No PokeLangCompiler, temos:

## for (para) -> Forretress:

### Um loop que executa um bloco de código um número específico de vezes.

![image](https://github.com/Massato01/PokeLangCompiler/assets/106417053/d51421a2-c479-4c9d-9c32-168430fc0c28)

## while (enquanto) -> Poliwhirl:

### Executa um bloco de código enquanto uma condição específica for verdadeira.

![image](https://github.com/Massato01/PokeLangCompiler/assets/106417053/7dfa5e06-6f2e-4281-84c4-00a6e54f17f3)

---

# Entrada e Saída:

## input (entrada) -> Pokeball:

### Solicita ao usuário um valor e o armazena em uma variável.

![image](https://github.com/Massato01/PokeLangCompiler/assets/106417053/b61b2e12-dbd1-48e1-a861-b9c629defd26)

## print (imprimir) -> Pokedex:

### Exibe valores na tela.

![image](https://github.com/Massato01/PokeLangCompiler/assets/106417053/3dfd2c46-50d6-474c-ab4c-46a45e07831f)

---

# Gramática Livre de Contexto

condicao -> id operador id | id operador num

expressao -> id "=" id | id "=" num

operador -> "=" | "!=" | ">" | "<" | "+" | "-" | "\*" | "/"

numero -> [0-9]

argumento -> id | numero

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

- INPUT

```

pokeball ( argumento ) ";"

```

- PRINT

```

pokedex ( argumento ) ";"

```

---

# Execução

#### 1. Inserir ou reutilizar o código em code.txt

#### 2. Executar a classe Main.java

#### 3. Os tokens analisados serão exibidos no terminal

#### 4. Se não existir, a pasta "Validacao" será criada e dentro dela estará o código da PokeLang traduzido para Java pronto para ser executado

---

# Exemplo de código:

- Codigo forretress(for)

```
pokedex("FORRETRESS(for)");
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
```

- Codigo eevee(if)

```
pokedex("EEVEE(if)");
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

- Codigo operadores

```
pokedex("OPERADORES");
pokedex("Valor 1:");
porygon numum = pokeball();

pokedex("Valor 2:");
porygon numdois = pokeball();

porygon somatotal = numum + numdois;
pokedex("SOMA");
pokedex(somatotal);

porygon subtotal = numum - numdois;
pokedex("SUBTRACAO");
pokedex(subtotal);

squirtle divtotal = numum / numdois;
pokedex("DIVISAO");
pokedex(divtotal);

squirtle multotal = numum * numdois;
pokedex("MULTIPLICACAO");
pokedex(multotal);
```
