package Syntactic;

public class Identificador {
    private Parser parser;

    public Identificador(Parser parser) {
        this.parser = parser;
    }

    public boolean id() {
        if (
            parser.matchTipo("id", parser.token.getLexema()) ||
            parser.matchTipo("num", parser.token.getLexema()) ||
            parser.matchTipo("flutuante", parser.token.getLexema()) ||
            parser.matchTipo("string", parser.token.getLexema()) ||
            (parser.matchTipo("id", parser.token.getLexema()) && parser.operadorParser.operador())
        ) {
            return true;
        }

        parser.erro("id");
        return false;
    }
}
