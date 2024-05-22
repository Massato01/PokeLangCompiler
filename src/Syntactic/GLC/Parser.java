package Syntactic.GLC;

import java.util.List;
import Token.Token;

public class Parser {
  List<Token> tokens;
  Token token;

  private String tipoVariavel = ""; // Para o INPUT
  private Eevee eeveeParser; // GLC Eevee
  private Forretress forretressParser; // GLC Forretress
  private Poliwhirl poliwhirlParser; // GLC Poliwhirl
  private Pokedex pokedexParser; //GLC Pokedex
  private Operador operadorParser; //GLC Operador

  public Parser(List<Token> tokens) {
    this.tokens = tokens;
    this.eeveeParser = new Eevee(this);
    this.forretressParser = new Forretress(this);
    this.poliwhirlParser = new Poliwhirl(this);
    this.pokedexParser = new Pokedex(this);
    this.operadorParser = new Operador(this);
  }

  public void main() {
    System.out.println("// POKELANG\nimport java.util.Scanner;\n\npublic class Main {\npublic static void main(String[] args) {\nScanner input = new Scanner(System.in);\n");
    token = nextToken();

    if (firstToken()) {
      if (matchTipo("EOF", "")) {
        System.out.print("\n}}");
      } else {
        erro("MAIN");
      }
    }
  }

  public Token nextToken() {
    if (tokens.size() > 0)
      return tokens.remove(0);

    return null;
  }

  public boolean firstToken() {
    if (tipoVariavelFirst()) {
      if (atribVariavel()) {
        firstToken();
        return true;
      }
    } else if (matchTFirst("comentario")) {
      if (comentario()) {
        firstToken();
        return true;
      }
    } else if (matchLFirst("eevee")) {
      if (eeveeParser.eevee()) {
        firstToken();
        return true;
      }
    } else if (matchLFirst("forretress")) {
      if (forretressParser.forretress()) {
        firstToken();
        return true;
      }
    } else if (matchLFirst("poliwhirl")) {
      if (poliwhirlParser.poliwhirl()) {
        firstToken();
        return true;
      }
    } else if (matchLFirst("pokedex")) {
      if (pokedexParser.pokedex()) {
        firstToken();
        return true;
      }
    // } else if (matchLFirst("++")) {
    //   if (operadorParser.operador()) {
    //     firstToken();
    //     return true;
    //   }
  } else if (matchTFirst("id")) {
    if (id()) {
      firstToken();
      return true;
    }
    } else {
      return true;
    }

    erro("FirstToken: " + token);
    return false;
  }

  public void erro(String regra) {
    System.out.println("\n\nErro na regra: " + regra);
    System.out.println("Token inválido: " + token);
    System.out.println("token invalido: " + token.getLexema());
    System.exit(0);
  }

  // --------------------TipoVariavel--------------------
  public boolean tipoVariavel() {
    if (matchLexema("porygon", "int ")) {
      tipoVariavel = "porygon";
      return true;
    } else if (matchLexema("squirtle", "double ")) {
      tipoVariavel = "squirtle";
      return true;
    } else if (matchLexema("unown", "String ")) {
      tipoVariavel = "unown";
      return true;
    }

    erro("TipoVariavel");
    return false;
  }

  // --------------------Atribuição Variavel--------------------
  public boolean atribVariavel() {
    if (tipoVariavel() && id() && matchLexema("=", "=") && mathExpressao() && matchLexema(";", ";")) {
      return true;
    }

    erro("atribVariavel");
    return false;
  }

  // --------------------ID--------------------
  public boolean id() {
    if (
      matchTipo("id", token.getLexema()) ||
      matchTipo("num", token.getLexema()) ||
      matchTipo("flutuante", token.getLexema()) ||
      matchTipo("string", token.getLexema())
      ) {
      return true;
    }

    erro("id");
    return false;
  }

  // --------------------Comentário--------------------
  public boolean comentario() {
    if (matchTipo("comentario>", "")) {
      return true;
    }

    erro("comentario");
    return false;
  }

  // --------------------Receba--------------------
  public boolean receba() {
    if (tipoVariavel.equals("porygon")) { // int: input.nextInt()
      if (matchLexema("receba", "input.nextInt") && matchLexema("(", "(") && matchLexema(")", ")")) {
        return true;
      }
    } else if (tipoVariavel.equals("squirtle")) { // double: input.nextDouble()
      if (matchLexema("receba", "input.nextDouble") && matchLexema("(", "(") && matchLexema(")",
          ")")) {
        return true;
      }
    } else if (tipoVariavel.equals("unown")) { // string: input.nextLine()
      if (matchLexema("receba", "input.nextLine") && matchLexema("(", "(") && matchLexema(")", ")")) {
        return true;
      }
    }

    erro("Receba");
    return false;
  }

  // --------------------Funcoes intermediarias--------------------

  public boolean tipoVariavelFirst() {
    if (matchLFirst("porygon") || matchLFirst("squirtle") ||
        matchLFirst("unown")) {
      return true;
    }

    return false;
  }

  // --------------------Condição--------------------
  public boolean condicao() {
    if (id() && operadorParser.operador() && id()) {
      if (matchLexema("&&", "&&") || matchLexema("||", "||")) {
        if (condicao()) {
          return true;
        }
      } else {
        return true; // ε
      }
    }

    erro("Condicao");
    return false;
  }
  
  public boolean mathExpressao() {
    if (math() && mathExpressaoLinha() || receba()) {
    // if (math() && mathExpressaoLinha()) {
      return true;
    }

    erro("mathExpressao");
    return false;
  }

  public boolean mathExpressaoLinha() {
    if (matchLexema("+", "+") || matchLexema("-", "-") || matchLexema("++", "++")) {
      if (math() && mathExpressaoLinha()) {
        return true;
      }
      erro("mathExpressaoLinha");
      return false;
    }

    return true; // ε
  }

  public boolean math() {
    if (F() && mathLinha()) {
      return true;
    }

    erro("Math");
    return false;
  }

  public boolean mathLinha() {
    if (matchLexema("*", "*") || matchLexema("/", "/")) {
      if (F() && mathLinha()) {
        return true;
      }
      erro("mathLinha");
      return false;
    }

    return true; // ε
  }

  public boolean F() {
    if (matchTipo("id", token.getLexema()) || matchTipo("num", token.getLexema()) || matchTipo("flutuante", token.getLexema())
        || matchTipo("string", token.getLexema())
        || (matchLexema("(", "(") && mathExpressao() && matchLexema(")", ")"))
        || receba()) {
      return true;
    }

    erro("F");
    return false;
  }

  public boolean varContador() {
    if (tipoVariavel() && id() && matchLexema("=", "=") && matchTipo("num", token.getLexema())) {
      return true;
    }

    erro("VarContador");
    return false;
  }

  public boolean incremento() {
    if (matchTipo("id", token.getLexema()) && operadorParser.operador()) {
      if (matchTipo("num", token.getLexema())) {
        return true;
      } else {
        return true; // ε
      }
    }

    erro("Incremento");
    return false;
  }

  // --------------------Verificacao Dados--------------------
  private boolean matchLFirst(String lexema) {
    if (token.getLexema().equals(lexema)) {
      return true;
    }

    return false;
  }

  private boolean matchTFirst(String tipo) {
    if (token.getTipo().equals(tipo)) {
      return true;
    }

    return false;
  }

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

  private void traduz(String code) {
    System.out.print(code + " ");
  }
}