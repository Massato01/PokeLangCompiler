package AFD;

import java.text.CharacterIterator;
import Token.Token;

public class MathOperator extends AFD {
    @Override
    public Token evaluate(CharacterIterator code) {
        switch (code.current()) {
            case '+':
                code.next();
                if (code.current() == '+') {
                    code.next();
                    return new Token("incremento", "++");
                } else {
                    code.next();
                    return new Token("soma", "+");
                }
            // case 'p':
            //     code.next();
            //     if (code.current() == 'i') {
            //         code.next();
            //         return new Token("incremento", "++")
            //     }
            case '-':
                code.next();
                if (code.current() == '-') {
                    code.next();
                    return new Token("decremento", "--");
                } else {
                    code.next();
                    return new Token("sub", "-");
                }
            case '*':
                code.next();
                return new Token("mul", "*");
            case '/':
                code.next();
                return new Token("div", "/");
            case '(':
                code.next();
                return new Token("lparen", "(");
            case ')':
                code.next();
                return new Token("rparen", ")");
            case '[':
                code.next();
                return new Token("lcolchete", "[");
            case ']':
                code.next();
                return new Token("rcolchete", "]");
            case '{':
                code.next();
                return new Token("lchave", "{");
            case '}':
                code.next();
                return new Token("rchave", "}");
            case ';':
                code.next();
                return new Token("fim", ";");
            case '>':
                code.next();
                if (code.current() == '=') {
                    code.next();
                    return new Token("maiorigual", ">=");
                } else {
                    return new Token("maiorque", ">");
                }
            case '<':
                code.next();
                if (code.current() == '=') {
                    code.next();
                    return new Token("menorigual", "<=");
                } else {
                    return new Token("menorque", "<");
                }
            case '&':
                code.next();
                return new Token("and", "&");
            case '|':
                code.next();
                if (code.current() == '|') {
                    code.next();
                    return new Token("or", "||");
                }
            case '=':
                code.next();
                if (code.current() == '=') {
                    code.next();
                    return new Token("igual", "==");
                } else {
                    return new Token("atribuicao", "=");
                }
            case '!':
                code.next();
                if (code.current() == '=') {
                    code.next();
                    return new Token("diferente", "!=");
                }
            default:
                return null;
        }
    }
}
