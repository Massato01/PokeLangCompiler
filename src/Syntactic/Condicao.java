package Syntactic;

// CONDICAO { id, operador, id }
public class Condicao {
    private Parser parser;

    public Condicao(Parser parser) {
        this.parser = parser;
    }

    public boolean condicao() {
        if (parser.identificadorParser.id() && parser.operadorParser.operador() && parser.identificadorParser.id()) {
            if (parser.matchLexema("&", "&&") || parser.matchLexema("||", "||")) {
                if (condicao()) {
                    return true;
                }
            } else {
                return true;
            }
        }

        parser.erro("Condicao");
        return false;
    }
}
