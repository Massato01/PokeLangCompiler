from _AFD import AFD
from Token import Token

class Types(AFD):
    def evaluate(self, code):
        reservadas = {
            'double': 'doseDupla',
            'float': 'dose',
            'short': 'shot',
            'int': 'latinha'
        }

        for reservada in reservadas:
            for c in reservada.valor:
                if code[0] == c:
                    code.next()

            if self.end_palavra(code):
                return Token("RESERVADA_" + reservada.chave.upper(), reservada.valor)

        return None

    def end_palavra(self, code):
        return code[0] == ' ' or code[0] == '\n' or code[0] == None
