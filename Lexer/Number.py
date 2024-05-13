from AFD import AFD
from Token import Token

class Number(AFD):
    def evaluate(self, code, linha, column):
        number = ""

        if code.isdigit():
            number = self.read_number(code)

            if self.end_number(code):
                return Token("NUM", number, linha, column)

            if code.startswith('.'):
                number += '.'
                code = next(code, None)
                number += self.read_number(code)

                if self.end_number(code):
                    return Token("FLUTUANTE", number, linha, column)

        return None

    def read_number(self, code):
        number = ""

        while code.isdigit():
            number += code
            code = next(code, None)

        return number

    def end_number(self, code):
        return code in (' ', '+', '-', '*', '(', ')', '{', '}', '[', ']', ';', '\n', None)
    
    def skip_white_space(self, code):  # Adiciona esta função
        while code.current() in (' ', '\n', '\r', '\t'):
            code.next()
