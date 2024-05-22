package AFD;

import java.text.CharacterIterator;
import java.util.Arrays;
import java.util.List;
import Token.Token;

public class ID extends AFD {
    @Override
    public Token evaluate(CharacterIterator code) {
        if (Character.isLetter(code.current())) {
            String letter = readID(code);

            if (endID(code) == true) {
                return new Token("id", letter);
            }
        }

        return null;
    }

    private String readID(CharacterIterator code) { // Lê a entrada e verifica se é uma letra, se for, incrementa em "letter"
        String letter = "";

        while (Character.isLetter(code.current())) {
            letter += code.current();
            code.next();
        }
        return letter;
    }

    private boolean endID(CharacterIterator code) { // Verifica se finalizou a declaração do ID
        List<Character> finalizadores = Arrays.asList(' ', '+', '-', '*', '/', '(', ')', '{', '}', '[', ']', ';', '\n' , CharacterIterator.DONE);

        for (char finalizador : finalizadores) {
            if (code.current() == finalizador) {
                return true;
            }
        }
        return false;
    }
}
