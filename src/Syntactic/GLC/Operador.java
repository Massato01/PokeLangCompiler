package Syntactic.GLC;

public class Operador {
    private Parser parser;

    public Operador(Parser parser) {
        this.parser = parser;
    }

    public boolean operador() {
        if (
            parser.matchLexema("<", "<") ||
            parser.matchLexema(">", ">") ||
            parser.matchLexema("<=", "<=") ||
            parser.matchLexema(">=", ">=") ||
            parser.matchLexema("==", "==") || 
            parser.matchLexema("!=", "!=") ||
            parser.matchLexema("||", "||") ||
            parser.matchLexema("&", "&&") ||
            parser.matchLexema("--", "--") ||
            parser.matchLexema("++", "++") ||
            parser.matchLexema("+", "+") ||
            parser.matchLexema("-", "-") ||
            parser.matchLexema("*", "*") ||
            parser.matchLexema("/", "/") ||
            parser.matchLexema("=", "=")
            ) {
            return true;
        }

        parser.erro("Operador");
        return false;
    }
}
