// package Syntactic.GLC;

// import java.util.List;
// import Token.Token;

// public class Parser {

//     List<Token> tokens;
//     Token token;

//     public Parser(List<Token> tokens) {
//         this.tokens = tokens;
//     }

//     public void main() {
//         System.out.println("public class Main { public static void main(String[] args) {");

//         token = getNextToken();
//         // if (getNextToken()) {
//         if (token) {
//             if (token.getTipo().equals("EOF")) {
//                 System.out.println("}}");
//                 System.out.println("\nSintaticamente correta");
//             } else {
//                 erro("main");
//             }
//         } else {
//             erro("main");
//         }
//     }

//     public Token getNextToken() {
//         if (tokens.size() > 0) {
//             return tokens.remove(0);
//         } else
//             return null;
//     }

//     private boolean getNextToken() {
//         if (eevee()) {
//             return true;
//         } else if (forretress()) {
//             return true;
//         } else if (poliwhirl()) {
//             return true;
//         } else if (pokedex()) {
//             return true;
//         } else if (idType()) {
//             return true;
//         } else if (expressao()) {
//             return true;
//         } else if (condicao()) {
//             return true;
//         } else if (operador()) {
//             return true;
//         } else if (operadorAtribuicao()) {
//             return true;
//         } else if (id()) {
//             return true;
//         } else if (num()) {
//             return true;
//         } else if (token.getTipo().equals("EOF")) {
//             return true;
//         }
//         return false;
//     }

//     private void erro(String regra) {
//         System.out.println("Erro na regra: " + regra);
//         System.out.println("Token inválido: " + token.getLexema());
//         System.exit(0);
//     }

//     private boolean eevee() {
//         if (matchL("eevee", "if") &&
//                 matchL("(", "(") &&
//                 condicao() &&
//                 matchL(")", ")") &&
//                 matchL("{", "{") &&
//                 expressao() &&
//                 matchL("}", "}") &&
//                 matchL("espeon", "else") &&
//                 matchL("{", "{") &&
//                 expressao() &&
//                 matchL("}", "}")) {
//             return true;
//         }
//         erro("eevee");
//         return false;
//     }

//     private boolean forretress() {
//         if (matchL("forretress", "for") &&
//                 matchL("(", "(") &&
//                 expressao() &&
//                 matchL(";", ";") &&
//                 condicao() &&
//                 matchL(";", ";") &&
//                 expressao() &&
//                 matchL(")", ")") &&
//                 matchL("{", "{") &&
//                 expressao() &&
//                 matchL("}", "}")) {
//             return true;
//         }
//         erro("forretress");
//         return false;
//     }

//     private boolean poliwhirl() {
//         if (matchL("poliwhirl", "while") &&
//                 matchL("(", "(") &&
//                 id() &&
//                 matchL(";", ";") &&
//                 condicao() &&
//                 matchL(";", ";") &&
//                 expressao() &&
//                 matchL(")", ")") &&
//                 matchL("{", "{") &&
//                 expressao() &&
//                 matchL("}", "}")) {
//             return true;
//         }
//         erro("poliwhirl");
//         return false;
//     }

//     private boolean pokedex() {
//         if (matchL("pokedex", "System.out.println") &&
//                 matchL("(", "(") &&
//                 id() &&
//                 matchL(")", ")") &&
//                 matchL(";", ";")) {
//             return true;
//         }
//         erro("pokedex");
//         return false;
//     }

//     private boolean idType() {
//         if (matchL("porygon", "int") ||
//                 matchL("squirtle", "float") ||
//                 matchL("unown", "String")) {
//             return true;
//         }
//         erro("idType");
//         return false;
//     }

//     private boolean expressao() {
//         if (id() &&
//                 operadorAtribuicao() &&
//                 num()) {
//             return true;
//         }
//         erro("expressao");
//         return false;
//     }

//     private boolean operador() {
//         if (matchL(">", ">") ||
//                 matchL("<", "<") ||
//                 matchL("==", "==")) {
//             return true;
//         }

//         erro("operador");
//         return false;
//     }

//     private boolean condicao() {
//         if (id() &&
//                 operador() &&
//                 num()) {
//             return true;
//         }
//         erro("condicao");
//         return false;
//     }

//     private boolean operadorAtribuicao() {
//         if (matchL("=", "=")) {
//             return true;
//         }
//         erro("operadorAtribuicao");
//         return false;
//     }

//     private boolean id() {
//         if (matchT("id", token.getLexema())) {
//             return true;
//         }
//         erro("id");
//         return false;
//     }

//     private boolean num() {
//         if (matchT("num", token.getLexema())) {
//             return true;
//         }
//         erro("num");
//         return false;
//     }

//     private boolean matchL(String palavra, String newcode) {
//         if (token.getLexema().equals(palavra)) {
//             traduz(newcode);
//             token = getNextToken();
//             return true;
//         }
//         erro(palavra);
//         return false;
//     }

//     private boolean matchT(String tipo, String newcode) {
//         if (token.getTipo().equals(tipo)) {
//             traduz(newcode);
//             token = getNextToken();
//             return true;
//         }
//         erro(tipo);
//         return false;
//     }

//     private void traduz(String code) {
//         System.out.print(code + " ");
//     }
// }

// --------------------------------------------------------------

package Syntactic.GLC;

import java.util.List;
import Token.Token;

public class Parser {

    List<Token> tokens;
    Token token;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void main() {
        System.out.println("public class Main {\npublic static void main(String[] args) {");

        token = getNextToken(); // Get the first token
        if (token != null) { // Check if the token is not null
            if (token.getTipo().equals("EOF")) {
                System.out.println("}}");
                System.out.println("\nSintaticamente correta");
            } else {
                erro("main");
            }
        } else {
            erro("main");
        }
    }

    public Token getNextToken() {
        if (tokens.size() > 0) {
            return tokens.remove(0);
        } else {
            return null;
        }
    }

    private boolean parseToken() { // Renamed from getNextToken to parseToken
        if (eevee()) {
            return true;
        } else if (forretress()) {
            return true;
        } else if (poliwhirl()) {
            return true;
        } else if (pokedex()) {
            return true;
        } else if (idType()) {
            return true;
        } else if (expressao()) {
            return true;
        } else if (condicao()) {
            return true;
        } else if (operador()) {
            return true;
        } else if (operadorAtribuicao()) {
            return true;
        } else if (id()) {
            return true;
        } else if (num()) {
            return true;
        } else if (token != null && token.getTipo().equals("EOF")) {
            return true;
        }
        return false;
    }

    private void erro(String regra) {
        System.out.println("Erro na regra: " + regra);
        System.out.println("Token inválido: " + (token != null ? token.getLexema() : "null"));
        System.exit(0);
    }

    private boolean eevee() {
        if (matchL("eevee", "if") &&
                matchL("(", "(") &&
                condicao() &&
                matchL(")", ")") &&
                matchL("{", "{") &&
                expressao() &&
                matchL("}", "}") &&
                matchL("espeon", "else") &&
                matchL("{", "{") &&
                expressao() &&
                matchL("}", "}")) {
            return true;
        }
        erro("eevee");
        return false;
    }

    private boolean forretress() {
        if (matchL("forretress", "for") &&
                matchL("(", "(") &&
                expressao() &&
                matchL(";", ";") &&
                condicao() &&
                matchL(";", ";") &&
                expressao() &&
                matchL(")", ")") &&
                matchL("{", "{") &&
                expressao() &&
                matchL("}", "}")) {
            return true;
        }
        erro("forretress");
        return false;
    }

    private boolean poliwhirl() {
        if (matchL("poliwhirl", "while") &&
                matchL("(", "(") &&
                id() &&
                matchL(";", ";") &&
                condicao() &&
                matchL(";", ";") &&
                expressao() &&
                matchL(")", ")") &&
                matchL("{", "{") &&
                expressao() &&
                matchL("}", "}")) {
            return true;
        }
        erro("poliwhirl");
        return false;
    }

    private boolean pokedex() {
        if (matchL("pokedex", "System.out.println") &&
                matchL("(", "(") &&
                id() &&
                matchL(")", ")") &&
                matchL(";", ";")) {
            return true;
        }
        erro("pokedex");
        return false;
    }

    private boolean idType() {
        if (matchL("porygon", "int") ||
                matchL("squirtle", "float") ||
                matchL("unown", "String")) {
            return true;
        }
        erro("idType");
        return false;
    }

    private boolean expressao() {
        if (id() &&
                operadorAtribuicao() &&
                num()) {
            return true;
        }
        erro("expressao");
        return false;
    }

    private boolean operador() {
        if (matchL(">", ">") ||
                matchL("<", "<") ||
                matchL("==", "==")) {
            return true;
        }

        erro("operador");
        return false;
    }

    private boolean condicao() {
        if (id() &&
                operador() &&
                num()) {
            return true;
        }
        erro("condicao");
        return false;
    }

    private boolean operadorAtribuicao() {
        if (matchL("=", "=")) {
            return true;
        }
        erro("operadorAtribuicao");
        return false;
    }

    private boolean id() {
        if (token != null && matchT("id", token.getLexema())) {
            return true;
        }
        erro("id");
        return false;
    }

    private boolean num() {
        if (token != null && matchT("num", token.getLexema())) {
            return true;
        }
        erro("num");
        return false;
    }

    private boolean matchL(String palavra, String newcode) {
        if (token != null && token.getLexema().equals(palavra)) {
            traduz(newcode);
            token = getNextToken();
            return true;
        }
        erro(palavra);
        return false;
    }

    private boolean matchT(String tipo, String newcode) {
        if (token != null && token.getTipo().equals(tipo)) {
            traduz(newcode);
            token = getNextToken();
            return true;
        }
        erro(tipo);
        return false;
    }

    private void traduz(String code) {
        System.out.print(code + " ");
    }
}