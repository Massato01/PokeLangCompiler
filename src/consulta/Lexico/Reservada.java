package Lexico;

import java.text.CharacterIterator;

public class Reservada extends AFD {
	String reservadas[] = { "depende", "planoB", "eOSeuNegocio", "fazDeNovo", "taOk", "gaviao", "caixaPreta", "receba", "olhaSo", "cheeega" };

	@Override
	public Token evaluate(CharacterIterator code, int linha, int column) {
		String reservada = "";

		for (int i = 0; i < reservadas.length; i++) {
			for (char c : reservadas[i].toCharArray()) {
				if (code.current() == c) {
					reservada += code.current();

					code.next();
				}
			}

			if (endReservada(code)) {
				if (reservada.equals(reservadas[i])) {
					return new Token("RESERVADA_" + reservadas[i].toUpperCase(), reservada, linha, column);
				}
			}
		}

		return null;
	}

	private boolean endReservada(CharacterIterator code) {
		return code.current() == ' '
				|| code.current() == '('
				|| code.current() == ')'
				|| code.current() == CharacterIterator.DONE;
	}
}
