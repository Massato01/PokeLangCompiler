package AFD;

import java.text.CharacterIterator;
import java.util.Arrays;
import java.util.List;
import Token.Token;

public class StringAFD extends AFD {
  @Override
  public Token evaluate(CharacterIterator code) {
    String string_value = "";

    if (code.current() == '"') {
      string_value += '"';
      code.next();
      string_value += readString(code);

      if (endString(code)) {
        string_value += '"';
        code.next();
        return new Token("string", string_value);
      }
    }

    return null;
  }

  private String readString(CharacterIterator code) {
    String string_value = "";

    while (code.current() != '"' && code.current() != CharacterIterator.DONE) {
      string_value += code.current();
      code.next();
    }

    return string_value;
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