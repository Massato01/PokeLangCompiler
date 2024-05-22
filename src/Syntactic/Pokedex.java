package Syntactic;

public class Pokedex {
    private Parser parser;

    public Pokedex(Parser parser) {
        this.parser = parser;
    }

    public boolean pokedex() {
        if (
            parser.matchLexema("pokedex", "System.out.println") &&
            parser.matchLexema("(", "(") &&
            parser.identificadorParser.id() &&
            parser.matchLexema(")", ")") &&
            parser.matchLexema(";", ";")
            ) {
            return true;
        }

        parser.erro("pokedex");
        return false;
    }
}
