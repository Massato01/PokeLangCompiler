package Syntactic.GLC;

import java.util.List;
import Token.Token;

public class Eevee {
    private Parser parser;

    public Eevee(Parser parser) {
        this.parser = parser;
    }

    public boolean eevee() {
        if (
            parser.matchLexema("eevee", "if") && parser.matchLexema("(", "(") && parser.condicao() && parser.matchLexema(")", ")") &&
            parser.matchLexema("{", "{") &&
            parser.firstToken() &&
            parser.matchLexema("}", "}") &&
            espeon()
            ) {
            return true;
        }

        parser.erro("eevee");
        return false;
    }

    private boolean espeon() {
        if (parser.matchLexema("espeon", "else")) {
            if (parser.matchLexema("{", "{") && parser.firstToken() && parser.matchLexema("}", "}")) {
                return true;
            }
            parser.erro("espeon");
            return false;
        }

        return true; // ε
    }
}
