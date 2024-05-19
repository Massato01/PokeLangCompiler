package Lexico;

import java.text.CharacterIterator;

public class StringText extends AFD {
  @Override
  public Token evaluate(CharacterIterator code, int line, int column) {
    String stringText = "";

    if (code.current() == '"') {
      stringText += '"';
      code.next();
      stringText += readString(code);

      if (endString(code)) {
        stringText += '"';
        code.next();
        return new Token("STRING", stringText, line, column);
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
