package Sintatico;

import java.util.List;

import Lexico.Token;

public class Parser {
  List<Token> tokens;
  Token token;
  private String tipoVariavel = "";

  public Parser(List<Token> tokens) {
    this.tokens = tokens;
  }

  public Token nextToken() {
    if (tokens.size() > 0)
      return tokens.remove(0);

    return null;
  }

  private void erro(String regra) {
    System.out.println("\nErro na regra: " + regra);
    System.out.println("Token inválido: " + token);
    System.out.println("token invalido: " + token.getLexema());
    System.out.println("\nErro na regra: " + regra + " que esta com o token inválido: " + token + " na linha: "
        + token.getLinha() + " e coluna: " + token.getColumn());
    System.exit(0); // encerra parser
  }

  public void main() {
    System.out.print(
        "import java.util.Scanner;\n\npublic class Main {\npublic static void main(String[] args) {\nScanner input = new Scanner(System.in);\n\n");
    token = nextToken();

    if (firstToken()) {
      if (matchT("EOF", "")) {
        System.out.print("}}");
      } else {
        erro("Fudeu de vez!!!!");
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
    } else if (matchLFirst("depende")) {
      if (depende()) {
        firstToken();
        return true;
      }
    } else if (matchLFirst("eOSeuNegocio")) {
      if (eOSeuNegocio()) {
        firstToken();
        return true;
      }
    } else if (matchLFirst("fazDeNovo")) {
      if (fazDeNovo()) {
        firstToken();
        return true;
      }
    } else if (matchLFirst("olhaSo")) {
      if (olhaSo()) {
        firstToken();
        return true;
      }
    } else {
      return true;
    }

    erro("FirstToken: " + token);
    return false;
  }

  // --------------------Atribuição Variavel--------------------
  private boolean atribVariavel() {
    if (tipoVariavel() && variavel() && matchL("=", "=") && mathExpressao() && matchL(";", ";")) {
      return true;
    }

    erro("Atribuição de variável inválida: " + token);
    return false;
  }

  // --------------------Comentário--------------------
  private boolean comentario() {
    if (matchT("COMENTARIO", "")) {
      return true;
    }

    erro("Comentario: " + token);
    return false;
  }

  // --------------------Depende--------------------
  private boolean depende() {
    if (matchL("depende", "if") && matchL("(", "(") && condicao() && matchL(")", ")") && matchL("{", "{")
        && firstToken()
        && matchL("}", "}")
        && planoB()) {
      return true;
    }

    erro("Depende invalido: " + token);
    return false;
  }

  private boolean planoB() {
    if (matchL("planoB", "else")) {
      if (matchL("{", "{") && firstToken() && matchL("}", "}")) {
        return true;
      }
      erro("PlanoB invalido: " + token);
      return false;
    }

    return true; // ε
  }

  // --------------------EOSeuNegocio--------------------
  private boolean eOSeuNegocio() {
    if (matchL("eOSeuNegocio", "for") && matchL("(", "(") && varContador()
        && matchL(";", ";") && condicao() && matchL(";", ";") && incremento() && matchL(")", ")") && matchL("{", "{")
        && firstToken()
        && matchL("}", "}")) {
      return true;
    }

    erro("EOSeuNegocio invalido: " + token);
    return false;
  }

  // --------------------FazDeNovo--------------------
  private boolean fazDeNovo() {
    if (matchL("fazDeNovo", "while") && matchL("(", "(") && condicao() && matchL(")", ")") && matchL("{", "{")
        && firstToken() && matchL("}", "}")) {
      return true;
    }

    erro("FazDeNovo invalido: " + token);
    return false;
  }

  // --------------------OlhaSo--------------------
  private boolean olhaSo() {
    if (matchL("olhaSo", "System.out.println") && matchL("(", "(") && variavel() && matchL(")", ")")
        && matchL(";", ";")) {
      return true;
    }

    erro("OlhaSo invalido: " + token);
    return false;
  }

  // --------------------Receba--------------------
  private boolean receba() {
    if (tipoVariavel.equals("taOk")) { // int: input.nextInt()
      if (matchL("receba", "input.nextInt") && matchL("(", "(") && matchL(")", ")")) {
        return true;
      }
    } else if (tipoVariavel.equals("gaviao")) { // double: input.nextDouble()
      if (matchL("receba", "input.nextDouble") && matchL("(", "(") && matchL(")",
          ")")) {
        return true;
      }
    } else if (tipoVariavel.equals("caixaPreta")) { // string: input.nextLine()
      if (matchL("receba", "input.nextLine") && matchL("(", "(") && matchL(")", ")")) {
        return true;
      }
    }

    erro("Receba invalido: " + token);
    return false;
  }

  // --------------------Funcoes intermediarias--------------------
  private boolean tipoVariavel() {
    // if (matchL("taOk", "int ") || matchL("gaviao", "double ") ||
    // matchL("caixaPreta", "String ")) {
    // return true;
    // }

    if (matchL("taOk", "int ")) {
      tipoVariavel = "taOk";
      return true;
    } else if (matchL("gaviao", "double ")) {
      tipoVariavel = "gaviao";
      return true;
    } else if (matchL("caixaPreta", "String ")) {
      tipoVariavel = "caixaPreta";
      return true;
    }

    erro("TipoVariavel: " + token);
    return false;
  }

  private boolean variavel() {
    if (matchT("ID", token.getLexema()) || matchT("NUM", token.getLexema()) || matchT("FLUTUANTE", token.getLexema())
        || matchT("STRING", token.getLexema())) {
      return true;
    }

    erro("Variavel: " + token);
    return false;
  }

  private boolean tipoVariavelFirst() {
    if (matchLFirst("taOk") || matchLFirst("gaviao") ||
        matchLFirst("caixaPreta")) {
      return true;
    }

    return false;
  }

  private boolean condicao() {
    if (variavel() && operador() && variavel()) {
      if (matchL("&&", "&&") || matchL("||", "||")) {
        if (condicao()) {
          return true;
        }
      } else {
        return true; // ε
      }
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

  private boolean mathExpressao() {
    if (math() && mathExpressaoLinha() || receba()) {
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
    if (F() && mathLinha()) {
      return true;
    }

    erro("Math invalida: " + token);
    return false;
  }

  private boolean mathLinha() {
    if (matchL("*", "*") || matchL("/", "/")) {
      if (F() && mathLinha()) {
        return true;
      }
      erro("Math Linha invalida: " + token);
      return false;
    }

    return true; // ε
  }

  private boolean F() {
    if (matchT("ID", token.getLexema()) || matchT("NUM", token.getLexema()) || matchT("FLUTUANTE", token.getLexema())
        || matchT("STRING", token.getLexema())
        || (matchL("(", "(") && mathExpressao() && matchL(")", ")"))
        || receba()) {
      return true;
    }

    erro("Regra F invalido: " + token);
    return false;
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