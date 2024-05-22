package Syntactic;

// COMENTARIOS: { // }
public class Comentario {
    private Parser parser;

    public Comentario(Parser parser) {
        this.parser = parser;
    }

    public boolean comentario() {
        if (parser.matchTipo("comentario", "")) {
            return true;
        }

        parser.erro("comentario");
        return false;
    }
}
