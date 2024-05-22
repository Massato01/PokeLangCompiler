package Syntactic;

import java.util.List;
import Token.Token;

// IF: { if, (, condicao, ), {, parseToken, }, else, {, parseToken, } }
public class Eevee {
    private Parser parser;

    public Eevee(Parser parser) {
        this.parser = parser;
    }

    public boolean eevee() {
        if (
            parser.matchLexema("eevee", "if") && parser.matchLexema("(", "(") && parser.condicaoParser.condicao() && parser.matchLexema(")", ")") &&
            parser.matchLexema("{", "{") &&
            parser.parseToken() &&
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
            if (parser.matchLexema("{", "{") && parser.parseToken() && parser.matchLexema("}", "}")) {
                return true;
            }
            parser.erro("espeon");
            return false;
        }

        return true; // ε
    }
}
