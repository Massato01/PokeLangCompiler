package AFD;

import java.text.CharacterIterator;
import java.util.Arrays;
import java.util.List;
import Token.Token;

public class Number extends AFD {
	@Override
	public Token evaluate(CharacterIterator code) {
		String number;

		if (Character.isDigit(code.current())) { // Se for um digito, chamará a função readNumber
			number = readNumber(code);

			if (endNumber(code) == true) { // Se a entrada for finalizada retorna o Token de NUM
				return new Token("num", number);
			}
			code.next();
			number += '.'; // Se for um FLOAT, chamará a função readNumber adicionando o "."
			number += readNumber(code);
			if (endNumber(code) == true) {
				return new Token("flutuante", number);
			}
		}

		return null;
	}

	private String readNumber(CharacterIterator code) { // Lê a entrada e verifica se é um número, se for, incrementa em "number"
		String number = "";

		while (Character.isDigit(code.current())) {
			number += code.current();
			code.next();
		}

		return number;
	}

	private boolean endNumber(CharacterIterator code) { // Verifica se finalizou a declaração do ID
		List<Character> finalizadores = Arrays.asList(' ', '+', '-', '*', '/', '(', ')', '{', '}', '[', ']', ';', '\n' , CharacterIterator.DONE);

		for (char finalizador : finalizadores) {
			if (code.current() == finalizador) {
				return true;
			}
		}
		return false;
	}
}
