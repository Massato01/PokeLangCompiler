package AFD;

import java.text.CharacterIterator;
import java.util.Arrays;
import java.util.List;
import Token.Token;

public class StringAFD extends AFD {
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

  private boolean endString(CharacterIterator code) { // Verifica se finalizou a declaração do ID
		List<Character> finalizadores = Arrays.asList('"', '\n', ';', CharacterIterator.DONE);

		for (char finalizador : finalizadores) {
			if (code.current() == finalizador) {
				return true;
			}
		}
		return false;
	}
}