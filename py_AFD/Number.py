from _AFD import AFD
from Token import Token

class Functions:
    validacoes = [' ', '+', '-', '*', '/', '(', ')', '{', '}', ';', '\n', None]

    @staticmethod
    def validate_end(code):
        return code[0] in Functions.validacoes


class Number(AFD):
    def evaluate(self, code):
        if code[0].isdigit():
            number = self.read_number(code)

            if code[0] != '.' and Functions.validate_end(code):  # Fix here
                return Token("NUM", number)

            code.next()
            number += '.' + self.read_number(code)
            if Functions.validate_end(code):  # Fix here
                return Token("FLUTUANTE", number)

        return None

    def read_number(self, code):
        number = ""
        while code[0].isdigit():
            number += code[0]
            code.next()
        return number
