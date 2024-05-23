package Syntactic;

public class MathOperator {
    private Parser parser;

    public MathOperator(Parser parser) {
        this.parser = parser;
    }

    public boolean mathOperator() {
        if ((mathOperatorAux() && mathOperatorArithmetic()) || parser.pokeballParser.pokeball()) {
            return true;
        }

        parser.erro("mathOperator");
        return false;
    }

    public boolean mathOperatorAux() {
        if (parser.matchTipo("id", parser.token.getLexema()) ||
            parser.matchTipo("num", parser.token.getLexema()) ||
            parser.matchTipo("flutuante", parser.token.getLexema()) ||
            parser.matchTipo("string", parser.token.getLexema()) ||
            (parser.matchLexema("(", "(") && mathOperator() && parser.matchLexema(")", ")")) ||
            parser.pokeballParser.pokeball()) {
            return true;
        }

        parser.erro("mathOperatorAux");
        return false;
    }

    public boolean mathOperatorArithmetic() {
        if (parser.matchLexema("*", "*") ||
            parser.matchLexema("/", "/") ||
            parser.matchLexema("+", "+") ||
            parser.matchLexema("-", "-") ||
            parser.matchLexema("++", "++") ||
            parser.matchLexema("--", "--")) {
            if (mathOperatorAux() && mathOperatorArithmetic() || parser.pokeballParser.pokeball()) {
                return true;
            }
            parser.erro("mathOperatorArithmetic");
            return false;
        }

        return true;
    }
}
