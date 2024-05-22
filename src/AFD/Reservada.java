package AFD;

import java.text.CharacterIterator;
import java.util.Arrays;
import java.util.List;
import Token.Token;

public class Reservada extends AFD {
	String reservadas[] = {"porygon", "squirtle", "unown", "pokeball", "pokedex", "eevee", "espeon", "forretress", "poliwhirl", "ditto"};

	@Override
	public Token evaluate(CharacterIterator code) {
		String reservada = "";

		int i = 0;
		while (i < reservadas.length) {
			for (char c : reservadas[i].toCharArray()) {
				if (code.current() == c) {
					reservada += code.current();

					code.next();
				}
			}

			if (endReservada(code)) {
				if (reservada.equals(reservadas[i])) {
					return new Token("reservada_" + reservadas[i], reservada);
				}
			}
			i++;
		}

		return null;
	}

	private boolean endReservada(CharacterIterator code) {
		List<Character> finalizadores = Arrays.asList(' ', '(', ')', ';', CharacterIterator.DONE);

		for (char finalizador : finalizadores) {
			if (code.current() == finalizador) {
				return true;
			}
		}
		return false;
	}
}
