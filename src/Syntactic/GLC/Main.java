package Syntactic.GLC;

import java.util.ArrayList;
import java.util.List;
import Token.Token;

public class Main {
    public static void main(String[] args) {
        /*
         * Node root = new Node("A");
         * Tree tree = new Tree(root);
         * 
         * Node nodeB = new Node("B");
         * Node nodeC = new Node("C");
         * Node nodeD = new Node("D");
         * Node nodeE = new Node("E");
         * Node nodeF = new Node("F");
         * 
         * root.addChild(nodeB);
         * root.addChild(nodeC);
         * nodeB.addChild(nodeD);
         * nodeB.addChild(nodeE);
         * nodeC.addChild(nodeF);
         * 
         * tree.simpleWalk(root);
         */

        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("eevee", "reservada_if"));
        tokens.add(new Token("soma", "id"));
        tokens.add(new Token(">", "operador_condicional"));
        tokens.add(new Token("5", "num"));
        tokens.add(new Token("soma", "id"));
        tokens.add(new Token("=", "operador_atribuicao"));
        tokens.add(new Token("3", "num"));
        tokens.add(new Token("espeon", "reservada_else"));
        tokens.add(new Token("soma", "id"));
        tokens.add(new Token("=", "operador_atribuicao"));
        tokens.add(new Token("2", "num"));
        tokens.add(new Token("$", "EOF"));
        Parser parser = new Parser(tokens);

        Tree tree = parser.main();
        tree.walk(tree.root);
    }
}
