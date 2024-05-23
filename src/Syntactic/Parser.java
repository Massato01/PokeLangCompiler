package Syntactic;

import java.util.List;
import Token.Token;

public class Parser {
  List<Token> tokens;
  Token token;

  public String codeOutput = ""; // Para o codigo traduzido

  public String evolving = ""; // Para o INPUT(pokeball)
  
  public Evolving evolvingParser; // GLC Evolving
  public Eevee eeveeParser; // GLC Eevee
  public Forretress forretressParser; // GLC Forretress
  public Poliwhirl poliwhirlParser; // GLC Poliwhirl
  public Pokedex pokedexParser; //GLC Pokedex
  public Operador operadorParser; //GLC Operador
  public Identificador identificadorParser; //GLC Id
  public Condicao condicaoParser; // GLC Condicao
  public Comentario comentarioParser; // GLC Comentario
  public Pokeball pokeballParser; // GLC Pokeball
  public Pokecenter pokecenterParser; // GLC Pokecenter
  public MathOperator mathOperatorParser; // GLC MathOperator
  public Number numberParser; // GLC Number

  public Parser(List<Token> tokens) {
    this.tokens = tokens;
    this.eeveeParser = new Eevee(this);
    this.forretressParser = new Forretress(this);
    this.poliwhirlParser = new Poliwhirl(this);
    this.pokedexParser = new Pokedex(this);
    this.operadorParser = new Operador(this);
    this.identificadorParser = new Identificador(this);
    this.condicaoParser = new Condicao(this);
    this.comentarioParser = new Comentario(this);
    this.evolvingParser = new Evolving(this);
    this.pokeballParser = new Pokeball(this);
    this.pokecenterParser = new Pokecenter(this);
    this.mathOperatorParser = new MathOperator(this);
    this.numberParser = new Number(this);
  }
  
  public void main() {
    System.out.println("// POKELANG -> JAVA\nimport java.util.Scanner;\n\npublic class PokeMainTraduzido {\npublic static void main(String[] args) {\nScanner input = new Scanner(System.in);\n");
    token = nextToken();

    if (parseToken()) {
      if (matchTipo("EOF", "")) {
        System.out.print("\n}}");        
      } else {
        erro("main");
      }
    }
  }

  public void erro(String regra) {
    System.out.println("\n\nErro na regra: " + regra);
    System.out.println("Token inválido: " + token);
    System.out.println("token invalido: " + token.getLexema());
    System.exit(0);
  }

  public Token nextToken() {
    if (tokens.size() > 0)
      return tokens.remove(0);
    return null;
  }

  public boolean parseToken() {
    if (
      token.getLexema().equals("porygon") ||
      token.getLexema().equals("squirtle") ||
      token.getLexema().equals("unown")
      ) {
        if (pokecenterParser.pokecenter()) {
          parseToken();
          return true;
        }
    } else if (token.getTipo().equals("comentario") && comentarioParser.comentario()) {
        parseToken();
        return true;
    } else if (token.getTipo().equals("id") && identificadorParser.id()) {
        parseToken();
        return true;
    } else if (token.getLexema().equals("eevee") && eeveeParser.eevee()) {
        parseToken();
        return true;
    } else if (token.getLexema().equals("forretress") && forretressParser.forretress()) {
        parseToken();
        return true;
    } else if (token.getLexema().equals("poliwhirl") && poliwhirlParser.poliwhirl()) {
        parseToken();
        return true;
    } else if (token.getLexema().equals("pokedex") && pokedexParser.pokedex()) {
        parseToken();
        return true;
    } else if (
      token.getTipo().equals("soma") ||
      token.getTipo().equals("sub") ||
      token.getTipo().equals("mul") ||
      token.getTipo().equals("div")
      ) {
        if (mathOperatorParser.mathOperator()) {
          parseToken();
          return true;
        }
    } else {
        return true;
    }

    return false;
  }
  
  // MATCH TOKENS
  public boolean matchLexema(String lexema, String newCode) {
    if (token.getLexema().equals(lexema)) {
      traduz(newCode);
      token = nextToken();
      return true;
    }

    return false;
  }

  public boolean matchTipo(String tipo, String newCode) {
    if (token.getTipo().equals(tipo)) {
      traduz(newCode);
      token = nextToken();
      return true;
    }

    return false;
  }

  // TRADUCAO
  public void traduz(String code) {
    System.out.print(code + " ");
  }
}