package Lexer;

import java.text.CharacterIterator;

public class MathOperator extends AFD {
    @Override
    public Token evaluate(CharacterIterator code, int linha, int column) {
        switch (code.current()) {
            case '-':
                code.next();
                return new Token("SUB", "-", linha, column);
            case '*':
                code.next();
                return new Token("MUL", "*", linha, column);
            case '/':
                code.next();
                return new Token("DIV", "/", linha, column);
            case '(':
                code.next();
                return new Token("LPAREN", "(", linha, column);
            case ')':
                code.next();
                return new Token("RPAREN", ")", linha, column);
            case '{':
                code.next();
                return new Token("LCHAVE", "{", linha, column);
            case '[':
                code.next();
                return new Token("LCOLCHETE", "[", linha, column);
            case ']':
                code.next();
                return new Token("rCOLCHETE", "]", linha, column);
            case '}':
                code.next();
                return new Token("RCHAVE", "}", linha, column);
            case ';':
                code.next();
                return new Token("FIM", ";", linha, column);
            case '>':
                code.next();
                return new Token("MAIORQ", ">", linha, column);
            case '<':
                code.next();
                return new Token("MENORQ", "<", linha, column);
            case '&':
                code.next();
                if (code.current() == '&') {
                    code.current();
                    return new Token("AND", "&&", linha, column);
                }
            case '|':
                code.next();
                if (code.current() == '|') {
                    code.next();
                    return new Token("AND", "||", linha, column);
                }
            case '=':
                code.next();
                if (code.current() == '=') {
                    code.next();
                    return new Token("IGUAL", "==", linha, column);
                } else {
                    return new Token("ATRIBUICAO", "=", linha, column);
                }
            case '!':
                code.next();
                if (code.current() == '=') {
                    code.next();
                    return new Token("DIFERENTE", "!=", linha, column);
                }
            case '+':
                code.next();
                if (code.current() == '+') {
                    code.next();
                    return new Token("INCREMENTO_SOMA", "++", linha, column);
                } else {
                    return new Token("SOMA", "+", linha, column);
                }
            default:
                return null;
        }
    }
}
