from _AFD import AFD
from Token import Token

class Functions:
    validacoes = [' ', '+', '-', '*', '/', '(', ')', '{', '}', ';', '\n', None]

    @staticmethod
    def validate_end(code):
        return code[0] in Functions.validacoes

class ID(AFD):
    def evaluate(self, code):
        if code[0].isalpha():
            letter = self.read_letter(code)

            if Functions.validate_end(code):
                return Token("ID", letter)

        return None

    def read_letter(self, code):
        letter = ""
        while code[0].isalpha():
            letter += code[0]
            code.next()
        return letter
