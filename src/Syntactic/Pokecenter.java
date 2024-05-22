package Syntactic;

public class Pokecenter {
    private Parser parser;

    public Pokecenter(Parser parser) {
        this.parser = parser;
    }

    public boolean pokecenter() {
        // porygon x = 1;
        if (
            parser.evolvingParser.evolving() && 
            parser.identificadorParser.id() && parser.matchLexema("=", "=") && parser.mathExpressao() && parser.matchLexema(";", ";")
            ) {
            return true;
        }

        parser.erro("pokecenter");
        return false;
    }
}
