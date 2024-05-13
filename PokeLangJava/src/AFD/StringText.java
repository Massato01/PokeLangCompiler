package AFD;

import java.text.CharacterIterator;
import Token.Token;

public class StringText extends AFD {
  @Override
  public Token evaluate(CharacterIterator code) {
    String stringText = "";

    if (code.current() == '"') {
      stringText += '"';
      code.next();
      stringText += readString(code);

      if (endString(code)) {
        stringText += '"';
        code.next();
        return new Token("STRING", stringText);
      }
    }

    return null;
  }

  private String readString(CharacterIterator code) {
    String stringText = "";

    while (code.current() != '"' && code.current() != CharacterIterator.DONE) {
      stringText += code.current();
      code.next();
    }

    return stringText;
  }

  private boolean endString(CharacterIterator code) {
    return code.current() == '\r' || code.current() == '\n' || code.current() == '"'
        || code.current() == CharacterIterator.DONE;
  }
}
