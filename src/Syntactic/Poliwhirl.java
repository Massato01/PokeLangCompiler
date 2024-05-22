package Syntactic;

public class Poliwhirl {
    private Parser parser;

    public Poliwhirl(Parser parser) {
        this.parser = parser;
    }

    public boolean poliwhirl() {
        if (
            parser.matchLexema("poliwhirl", "while") && parser.matchLexema("(", "(") && parser.condicaoParser.condicao() && parser.matchLexema(")", ")") &&
            parser.matchLexema("{", "{") &&
            parser.parseToken() &&
            parser.matchLexema("}", "}")
            ) {
            return true;
        }

        parser.erro("poliwhirl");
        return false;
    }
}
