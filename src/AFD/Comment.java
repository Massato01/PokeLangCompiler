package AFD;

import java.text.CharacterIterator;
import Token.Token;

public class Comment extends AFD {

    @Override
    public Token evaluate(CharacterIterator code) {
        if (code.current() == '/') {
            code.next();
            if (code.current() == '/') {
                code.next();

                String comment = readComment(code);

                return new Token("comentario", comment);
            }
        }
        return null;
    }

    private String readComment(CharacterIterator code) {
        String comment = "//";

        while (code.current() != '\n' && code.current() != CharacterIterator.DONE) {
            comment += code.current();
            code.next();
        }
        return comment;
    }
}
