package AFD;

import java.text.CharacterIterator;
import Token.Token;

public class Number extends AFD {
	@Override
	public Token evaluate(CharacterIterator code, int linha, int column) {
		String number;

		if (Character.isDigit(code.current())) {
			number = readNumber(code);

			if (endNumber(code)) {
				return new Token("NUM", number, linha, column);
			}

			if (code.current() == '.') {
				number += '.';
				code.next();
				number += readNumber(code);

				if (endNumber(code)) {
					return new Token("FLUTUANTE", number, linha, column);
				}
			}
		}

		return null;
	}

	private String readNumber(CharacterIterator code) {
		String number = "";

		while (Character.isDigit(code.current())) {
			number += code.current();
			code.next();
		}

		return number;
	}

	private boolean endNumber(CharacterIterator code) {
		return code.current() == ' '
				|| code.current() == '+'
				|| code.current() == '-'
				|| code.current() == '*'
				|| code.current() == '('
				|| code.current() == ')'
				|| code.current() == '{'
				|| code.current() == '}'
				|| code.current() == '['
				|| code.current() == ']'
				|| code.current() == ';'
				|| code.current() == '\n'
				|| code.current() == CharacterIterator.DONE;
	}
}
