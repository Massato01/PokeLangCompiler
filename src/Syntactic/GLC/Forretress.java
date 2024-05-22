package Syntactic.GLC;

public class Forretress {
    private Parser parser;

    public Forretress(Parser parser) {
        this.parser = parser;
    }

    public boolean forretress() {
        if (
            parser.matchLexema("forretress", "for") && parser.matchLexema("(", "(") && parser.varContador() && parser.matchLexema(";", ";") &&
            parser.condicao() && parser.matchLexema(";", ";") &&
            parser.incremento() && parser.matchLexema(")", ")") && parser.matchLexema("{", "{") && 
            parser.firstToken() &&
            parser.matchLexema("}", "}")
            ) {
            return true;
        }

        parser.erro("forretress");
        return false;
    }
}
