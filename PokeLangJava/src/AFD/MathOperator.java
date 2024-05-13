package AFD;

import java.text.CharacterIterator;
import Token.Token;

public class MathOperator extends AFD {
    @Override
    public Token evaluate(CharacterIterator code) {
        switch (code.current()) {
            case '-':
                code.next();
                return new Token("SUB", "-");
            case '*':
                code.next();
                return new Token("MUL", "*");
            case '/':
                code.next();
                return new Token("DIV", "/");
            case '(':
                code.next();
                return new Token("LPAREN", "(");
            case ')':
                code.next();
                return new Token("RPAREN", ")");
            case '{':
                code.next();
                return new Token("LCHAVE", "{");
            case '[':
                code.next();
                return new Token("LCOLCHETE", "[");
            case ']':
                code.next();
                return new Token("rCOLCHETE", "]");
            case '}':
                code.next();
                return new Token("RCHAVE", "}");
            case ';':
                code.next();
                return new Token("FIM", ";");
            case '>':
                code.next();
                return new Token("MAIORQ", ">");
            case '<':
                code.next();
                return new Token("MENORQ", "<");
            case '&':
                code.next();
                if (code.current() == '&') {
                    code.current();
                    return new Token("AND", "&&");
                }
            case '|':
                code.next();
                if (code.current() == '|') {
                    code.next();
                    return new Token("AND", "||");
                }
            case '=':
                code.next();
                if (code.current() == '=') {
                    code.next();
                    return new Token("IGUAL", "==");
                } else {
                    return new Token("ATRIBUICAO", "=");
                }
            case '!':
                code.next();
                if (code.current() == '=') {
                    code.next();
                    return new Token("DIFERENTE", "!=");
                }
            case '+':
                code.next();
                if (code.current() == '+') {
                    code.next();
                    return new Token("INCREMENTO_SOMA", "++");
                } else {
                    return new Token("SOMA", "+");
                }
            default:
                return null;
        }
    }
}
