from _AFD import AFD
from Token import Token

class Comentario(AFD):
    def evaluate(self, code):
        if code[0] != '/':
            return None
        code.next()
        if code[0] != '/':
            return None
        code.next()

        comment = self.read_comment(code)
        return Token("COMENTARIO", comment)

    def read_comment(self, code):
        comment = "//"
        while code[0] != '\n' and code[0] != None:
            comment += code[0]
            code.next()
        return comment
