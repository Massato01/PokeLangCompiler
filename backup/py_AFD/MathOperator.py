from _AFD import AFD
from Token import Token

class MathOperator(AFD):
    def evaluate(self, code):
        current_char = code[0]

        if current_char == '+':
            code.next()
            return Token("OPERADOR_MAIS", "+")
        elif current_char == '-':
            code.next()
            return Token("OPERADOR_MENOS", "-")
        elif current_char == '*':
            code.next()

            if code[0] == '*':
                code.next()
                return Token("OPERADOR_VEZES", "**")
            else:
                return Token("OPERADOR_EXPONENCIACAO", "*")
        elif current_char == '/':
            code.next()
            return Token("OPERADOR_DIVIDIR", "/")
        else:
            return None
