package Syntactic;

public class Pokeball {
    private Parser parser;

    public Pokeball(Parser parser) {
        this.parser = parser;
    }

    public boolean pokeball() {
        if (parser.evolving.equals("porygon")) {
            if (parser.matchLexema("pokeball", "input.nextInt") && parser.matchLexema("(", "(") && parser.matchLexema(")", ")")) {
                return true;
            }
        } else if (parser.evolving.equals("squirtle")) {
            if (parser.matchLexema("pokeball", "input.nextDouble") && parser.matchLexema("(", "(") && parser.matchLexema(")", ")")) {
                return true;
            }
        } else if (parser.evolving.equals("unown")) {
            if (parser.matchLexema("pokeball", "input.nextLine") && parser.matchLexema("(", "(") && parser.matchLexema(")", ")")) {
                return true;
            }
        }

        parser.erro("pokeball");
        return false;
    }
}