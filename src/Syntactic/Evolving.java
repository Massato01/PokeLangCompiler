package Syntactic;

// TIPOS DE VARIÁVEL: { int, double, string }
public class Evolving {
    private Parser parser;

    public Evolving(Parser parser) {
        this.parser = parser;
    }

    public boolean evolving() {
        if (parser.matchLexema("porygon", "int ")) {
            parser.evolving = "porygon";
            return true;
        } else if (parser.matchLexema("squirtle", "double ")) {
            parser.evolving = "squirtle";
            return true;
        } else if (parser.matchLexema("unown", "String ")) {
            parser.evolving = "unown";
            return true;
        }

        parser.erro("evolving");
        return false;
    }
}
