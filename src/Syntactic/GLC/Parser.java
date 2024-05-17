
package Syntactic.GLC;

import java.util.Scanner;
import java.util.List;
import Token.Token;

public class Parser {

    List<Token> tokens;
    Token token;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Tree main() {
        Node node = new Node("eevee");
        Tree tree = new Tree(node);

        token = getNextToken();
        if (eevee(node)) {
            if (token.tipo == "EOF") {
                System.out.println("\nSintaticamente correta");
                return tree;
            } else {
                erro("main");
            }
        }
        erro("main");
        return null;
    }

    public Token getNextToken() {
        if (tokens.size() > 0) {
            return tokens.remove(0);
        } else
            return null;
    }

    private void erro(String node) {
        System.out.println("regra: " + node);
        System.out.println("token inválido: " + token.lexema);
        System.exit(0);
    }

    private boolean eevee(Node node) {
        if (matchL("eevee", "if", node) &&
                matchL("(", "(", node) &&
                condicao(node.addChild("condicao")) &&
                matchL(")", ")", node) &&
                matchL("{", "{", node) &&
                expressao(node.addChild("expressao")) &&
                matchL("}", "}", node) &&
                matchL("espeon", "else", node) &&
                matchL("{", "{", node) &&
                expressao(node.addChild("expressao")) &&
                matchL("}", "}", node)) {
            return true;
        }
        erro("eevee");
        return false;
    }

    private boolean forretress(Node node) {
        if (matchL("forretress", "for", node) &&
                matchL("(", "(", node) &&
                
                condicao(node.addChild("condicao")) &&
                expressao(node.addChild("expressao")) &&
                matchL("espeon", "else", node) &&
                expressao(node.addChild("expressao"))) {
            return true;
        }
    }

    private boolean poliwhirl(Node node) {
        if (matchL("poliwhirl", "while", node) &&
                matchL("(", "(", node) &&
                id(node.addChild("id")) &&
                matchL(";", ";", node) &&
                condicao(node.addChild("condicao")) &&
                matchL(";", ";", node) &&
                expressao(node.addChild("expressao")) &&
                matchL(")", ")", node) &&
                matchL("{", "{", node) &&
                expressao(node.addChild("expressao")) &&
                matchL("}", "}", node)) {
            return true;
        }
        erro("poliwhirl");
        return false;
    }

    private boolean pokedex(Node node) {
        if (matchL("pokedex", "System.out.println", node) &&
                matchL("(", "(", node) &&
                id(node.addChild("id")) &&
                matchL(")", ")", node) &&
                matchL(";", ";", node)) {
            return true;
        }
        erro("pokedex");
        return false;
    }

    private boolean idType(Node node){
        if (matchL("porygon", "int", node) ||
                matchL("squirtle", "float", node) ||
                matchL("unown", "String", node)) {
            return true;
        }
        erro("idType");
        return false;
    }

    private boolean expressao(Node node) {
        node.enter = "{";
        if (id(node.addChild("id")) &&
                operadorAtribuicao(node.addChild("operadorAtribuicao")) &&
                num(node.addChild("num"))) {
            node.exit = "}";
            return true;
        }
        erro("expressao");
        return false;
    }

    private boolean operador(Node node) {
        if (matchL(">", ">", node) ||
                matchL("<", "<", node) ||
                matchL("==", "==", node)) {
            return true;
        }

        erro("operador");
        return false;
    }

    private boolean condicao(Node node) {
        node.enter = "(";
        if (id(node.addChild("id")) &&
                operador(node.addChild("operador")) &&
                num(node.addChild("num"))) {
            node.exit = ")";
            return true;
        }
        erro("condicao");
        return false;
    }

    private boolean operadorAtribuicao(Node node) {
        if (matchL("=", token.lexema, node)) {
            return true;
        }
        erro("operadorAtribuicao");
        return false;
    }

    private boolean id(Node node) {
        if (matchT("id", token.lexema, node)) {
            return true;
        }
        erro("id");
        return false;
    }

    private boolean num(Node node) {
        if (matchT("num", token.lexema, node)) {
            return true;
        }
        erro("num");
        return false;
    }

    private boolean matchL(String palavra, String newcode, Node node) {
        if (token.lexema.equals(palavra)) {
            node.addChild(newcode);
            token = getNextToken();
            return true;
        }
        erro(palavra);
        return false;
    }

    private boolean matchT(String palavra, String newcode, Node node) {
        if (token.tipo.equals(palavra)) {
            node.addChild(newcode);
            token = getNextToken();
            return true;
        }
        erro(palavra);
        return false;
    }
}
