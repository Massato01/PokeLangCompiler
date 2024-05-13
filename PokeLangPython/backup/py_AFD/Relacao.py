from _AFD import AFD
from Token import Token

class Relacao(AFD):
    def evaluate(self, code):
        current_char = code[0]

        if current_char == '<':
            code.next()

            if code[0] == '=':
                code.next()
                return Token("RELACAO_MENOR_IGUAL", "<=")

            return Token("RELACAO_MENOR", "<")
        elif current_char == '>':
            code.next()

            if code[0] == '=':
                code.next()
                return Token("RELACAO_MAIOR_IGUAL", ">=")
            else:
                return Token("RELACAO_MAIOR", ">")
        else:
            return None
