package Syntactic;

import java.util.List;

import Token.Token;

public class Parser {
  List<Token> tokens;
  Token token;

  public Parser(List<Token> tokens) {
    this.tokens = tokens;
  }

  public Token nextToken() {
    if (tokens.size() > 0)
      return tokens.remove(0);

    return null;
  }

  private void erro(String regra) {
    System.out.println("Erro na regra: " + regra);
    System.out.println("Token inválido: " + token);
    System.out.println("token invalido: " + token.getLexema());
    System.exit(0); // encerra parser
  }

  public void main() {
    System.out.println("public class Main {\n\tpublic static void main(String[] args) {");
    token = nextToken();

    if (firstToken()) {
      if (matchT("EOF", "")) {
        System.out.println("\t}\n}");
      } else {
        erro("ERRO!");
      }
    }
  }

  private boolean firstToken() {
    if (tipoVariavelFirst()) {
      if (atribVariavel()) {
        firstToken();
        return true;
      }
    } else if (matchTFirst("COMENTARIO")) {
      if (comentario()) {
        firstToken();
        return true;
      }
    } else if (matchLFirst("eevee")) {
      if (eevee()) {
        firstToken();
        return true;
      }
    } else if (matchLFirst("forretress")) {
      if (forretress()) {
        firstToken();
        return true;
      }
    } else if (matchLFirst("poliwhirl")) {
      if (poliwhirl()) {
        firstToken();
        return true;
      }
    } else if (matchLFirst("pokedex")) {
      if (pokedex()) {
        firstToken();
        return true;
      }
    } else {
      return true;
    }

    erro("FirstToken: " + token);
    return false;
  }

  // ATRIBUIÇÃO
  private boolean atribVariavel() {
    if (tipoVariavel() && variavel() && matchL("=", "=") && (variavel() || expressao()) && matchL(";", ";")) {
      return true;
    }

    erro("Atribuição de variável inválida: " + token);
    return false;
  }

  // COMENTÁRIO
  private boolean comentario() {
    if (matchT("COMENTARIO", token.getLexema().replace("#", "//") + "\n")) {
      return true;
    }

    erro("Comentario: " + token);
    return false;
  }

  // IF
  private boolean eevee() {
    if (matchL("eevee", "if") && matchL("(", "(") && condicao() && matchL(")", ")") && matchL("{", "{") && expressao()
        && matchL("}", "}")
        && espeon()) {
      return true;
    }

    erro("eevee invalido: " + token);
    return false;
  }

  private boolean espeon() {
    if (matchL("espeon", "else")) {
      if (matchL("{", "{") && expressao() && matchL("}", "}")) {
        return true;
      }
      erro("espeon invalido: " + token);
      return false;
    }

    return true; // ε
  }

  // FOR
  private boolean forretress() {
    if (matchL("forretress", "for") && matchL("(", "(") && varContador()
        && matchL(";", ";") && condicao() && matchL(";", ";") && incremento() && matchL(")", ")") && matchL("{", "{")
        && expressao()
        && matchL("}", "}")) {
      return true;
    }

    erro("forretress invalido: " + token);
    return false;
  }

  // WHILE
  private boolean poliwhirl() {
    if (matchL("poliwhirl", "while") && matchL("(", "(") && condicao() && matchL(")", ")") && matchL("{", "{")
        && expressao() && matchL("}", "}")) {
      return true;
    }

    erro("poliwhirl invalido: " + token);
    return false;
  }

  // PRINT
  private boolean pokedex() {
    if (matchL("pokedex", "System.out.println") && matchL("(", "(") && variavel() && matchL(")", ")")
        && matchL(";", ";")) {
      return true;
    }

    erro("pokedex invalido: " + token);
    return false;
  }

  // TESTANDO
  private boolean tipoVariavel() {
    if (matchL("porygon", "int ") || matchL("squirtle", "double ") || matchL("unown", "String ")) {
      return true;
    }

    erro("TipoVariavel: " + token);
    return false;
  }

  private boolean variavel() {
    if (matchT("ID", token.getLexema()) || matchT("NUM", token.getLexema()) || matchT("FLUTUANTE", token.getLexema())
        || matchT("STRING", token.getLexema())
        || (matchL("(", "(") && mathExpressao() && matchL(")", ")"))) {
      return true;
    }

    erro("Variavel: " + token);
    return false;
  }

  private boolean tipoVariavelFirst() {
    if (matchLFirst("porygon") || matchLFirst("squirtle") ||
        matchLFirst("unown")) {
      return true;
    }

    return false;
  }

  private boolean condicao() {
    if (variavel() && operador() && variavel()) {
      return true;
    }

    erro("Condicao invalida: " + token);
    return false;
  }

  private boolean operador() {
    if (matchL("<", "<")
        || matchL(">", ">")
        || matchL("<=", "<=")
        || matchL(">=", ">=")
        || matchL("==", "==")
        || matchL("!=", "!=")
        || matchL("||", "||")
        || matchL("&&", "&&")
        || matchL("--", "--")
        || matchL("++", "++")
        || matchL("+", "+")
        || matchL("-", "-")
        || matchL("*", "*")
        || matchL("/", "/")
        || matchL("=", "=")) {
      return true;
    }

    erro("Operador invalido: " + token);
    return false;
  }

  private boolean expressao() {
    if ((tipoVariavel() && matchT("ID", token.getLexema()) && operador() && variavel() && matchL(";", ";"))
        || (mathExpressao() && matchL(";", ";"))
        || (variavel() && matchL("=", "=") && variavel() && matchL(";", ";"))) {
      return true;
    }

    /*
     * Assim da erro
     * if ((mathExpressao() && matchL(";")) || (matchT("ID") && operador() &&
     * matchL(";")) || (variavel() && matchL("=") && variavel() && matchL(";"))) {
     * return true;
     * }
     */

    /*
     * Assim tbm da erro
     * if ((variavel() && matchL("=") && variavel() && matchL(";")) || (matchT("ID")
     * && operador() && matchL(";")) || (mathExpressao() && matchL(";"))) {
     * return true;
     * }
     */

    erro("Expressao invalida" + token);
    return false;
  }

  private boolean mathExpressao() {
    if (math() && mathExpressaoLinha()) {
      return true;
    }

    erro("Math Expressao invalida: " + token);
    return false;
  }

  private boolean mathExpressaoLinha() {
    if (matchL("+", "+") || matchL("-", "-") || matchL("++", "++")) {
      if (math() && mathExpressaoLinha()) {
        return true;
      }
      erro("Math Expressao 1 invalida: " + token);
      return false;
    }

    return true; // ε
  }

  private boolean math() {
    if (variavel() && mathLinha()) {
      return true;
    }

    erro("Math invalida: " + token);
    return false;
  }

  private boolean mathLinha() {
    if (matchL("*", "*") || matchL("/", "/")) {
      if (variavel() && mathLinha()) {
        return true;
      }
      erro("Math 1 invalida: " + token);
      return false;
    }

    return true; // ε
  }

  private boolean varContador() {
    if (tipoVariavel() && variavel() && matchL("=", "=") && matchT("NUM", token.getLexema())) {
      return true;
    }

    erro("VarContador invalido: " + token);
    return false;
  }

  private boolean incremento() {
    if (matchT("ID", token.getLexema()) && operador()) {
      if (matchT("NUM", token.getLexema())) {
        return true;
      } else {
        return true; // ε
      }
    }

    erro("Incremento invalido: " + token);
    return false;
  }

  // TIPO DE VARIÁVEL
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

  private boolean matchL(String lexema, String newCode) {
    if (token.getLexema().equals(lexema)) {
      traduz(newCode);
      token = nextToken();
      return true;
    }

    return false;
  }

  private boolean matchT(String tipo, String newCode) {
    if (token.getTipo().equals(tipo)) {
      traduz(newCode);
      token = nextToken();
      return true;
    }

    return false;
  }

  private void traduz(String code) {
    System.out.print(code);
  }
}