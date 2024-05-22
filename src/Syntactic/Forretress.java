package Syntactic;

// FOR: { for, (, varContador,  }
public class Forretress {
    private Parser parser;

    public Forretress(Parser parser) {
        this.parser = parser;
    }

    public boolean contadorFor() {
        if (
            parser.evolvingParser.evolving() &&
            parser.identificadorParser.id() && 
            parser.matchLexema("=", "=") && 
            parser.matchTipo("num", parser.token.getLexema())
            ) {
          return true;
        }
    
        parser.erro("ContadorFor");
        return false;
      }
    
    public boolean incrementoFor() {
        if (parser.identificadorParser.id() && parser.operadorParser.operador()) {
          if (parser.matchTipo("num", parser.token.getLexema())) {
            return true;
          } else {
            return true;
          }
        }
    
        parser.erro("IncrementoFor");
        return false;
      }

    public boolean forretress() {
        if (
            parser.matchLexema("forretress", "for") && parser.matchLexema("(", "(") && contadorFor() && parser.matchLexema(";", ";") &&
            parser.condicaoParser.condicao() && parser.matchLexema(";", ";") &&
            incrementoFor() && parser.matchLexema(")", ")") && parser.matchLexema("{", "{") && 
            parser.parseToken() &&
            parser.matchLexema("}", "}")
            ) {
            return true;
        }

        parser.erro("forretress");
        return false;
    }
}
