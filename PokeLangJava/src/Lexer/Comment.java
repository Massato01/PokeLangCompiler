package Lexer;

import java.text.CharacterIterator;

public class Comment extends AFD {

    @Override
    public Token evaluate(CharacterIterator code, int line, int column) {
        String comment = "";

        if (code.current() == '#') {
            comment += "#";
            code.next();

            comment += readComment(code);

            if (endComment(code)) {
                return new Token("COMENTARIO", comment, line, column);
            }
        }

        return null;
    }

    private String readComment(CharacterIterator code) {
        String comment = "";

        while (code.current() != '\r' && code.current() != '\n' && code.current() != CharacterIterator.DONE) {
            comment += code.current();
            code.next();
        }

        return comment;
    }

    private boolean endComment(CharacterIterator code) {
        return code.current() == '\r' || code.current() == '\n' || code.current() == CharacterIterator.DONE;
    }
}
