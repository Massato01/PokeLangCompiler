from _AFD import AFD
from Token import Token

class Delimitadores(AFD):
    def evaluate(self, code):
        current_char = code[0]

        if current_char == '(':
            code.next()
            return Token("LPAREN", "(")
        elif current_char == ')':
            code.next()
            return Token("RPAREN", ")")
        elif current_char == '{':
            code.next()
            return Token("LCHAVE", "{")
        elif current_char == '}':
            code.next()
            return Token("RCHAVE", "}")
        elif current_char == '=':
            code.next()

            if code[0] == '=':
                code.next()
                return Token("RELACAO_IGUAL", "==")

            return Token("ATRIBUICAO", "=")
        elif current_char == ';':
            code.next()
            return Token("FIM", ";")
        else:
            return None
