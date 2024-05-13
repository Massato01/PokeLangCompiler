package AFD;

import java.text.CharacterIterator;
import Token.Token;

public abstract class AFD {
    public abstract Token evaluate(CharacterIterator code, int line, int column);
}
