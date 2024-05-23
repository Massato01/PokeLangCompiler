package Syntactic;

public class Number {
    private Parser parser;

    public Number(Parser parser) {
        this.parser = parser;
    }

    public boolean number() {
        if (
            parser.matchTipo("num", parser.token.getLexema()) ||
            parser.matchTipo("flutuante", parser.token.getLexema())
            ) {
            return true;
        }

        parser.erro("Number");
        return false;
    }
}