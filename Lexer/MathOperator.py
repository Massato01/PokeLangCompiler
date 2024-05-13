from Token import Token

class MathOperator:
    def evaluate(self, code, linha, column):
        code_iter = iter(code)
        for _ in code:
            current_char = next(code_iter, None)
            if current_char == '-':
                return Token("SUB", "-", linha, column)
            elif current_char == '*':
                return Token("MUL", "*", linha, column)
            elif current_char == '/':
                return Token("DIV", "/", linha, column)
            elif current_char == '(':
                return Token("LPAREN", "(", linha, column)
            elif current_char == ')':
                return Token("RPAREN", ")", linha, column)
            elif current_char == '{':
                return Token("LCHAVE", "{", linha, column)
            elif current_char == '[':
                return Token("LCOLCHETE", "[", linha, column)
            elif current_char == ']':
                return Token("rCOLCHETE", "]", linha, column)
            elif current_char == '}':
                return Token("RCHAVE", "}", linha, column)
            elif current_char == ';':
                return Token("FIM", ";", linha, column)
            elif current_char == '>':
                return Token("MAIORQ", ">", linha, column)
            elif current_char == '<':
                return Token("MENORQ", "<", linha, column)
            elif current_char == '&':
                next_char = next(code_iter, None)
                if next_char == '&':
                    return Token("AND", "&&", linha, column)
            elif current_char == '|':
                next_char = next(code_iter, None)
                if next_char == '|':
                    return Token("AND", "||", linha, column)
            elif current_char == '=':
                next_char = next(code_iter, None)
                if next_char == '=':
                    return Token("IGUAL", "==", linha, column)
                else:
                    return Token("ATRIBUICAO", "=", linha, column)
            elif current_char == '!':
                next_char = next(code_iter, None)
                if next_char == '=':
                    return Token("DIFERENTE", "!=", linha, column)
            elif current_char == '+':
                next_char = next(code_iter, None)
                if next_char == '+':
                    return Token("INCREMENTO_SOMA", "++", linha, column)
                else:
                    return Token("SOMA", "+", linha, column)
        return None

    def skip_white_space(self, code):  # Adiciona esta função
        while code.current() in (' ', '\n', '\r', '\t'):
            code.next()