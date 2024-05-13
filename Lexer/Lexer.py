from AFD import AFD
from Token import Token
from Comment import Comment
from Reservada import Reservada
from MathOperator import MathOperator
from Number import Number
from ID import ID
from StringText import StringText

class Lexer:
    def __init__(self, code):
        self.tokens = []
        self.code = iter(code)
        self.line_error = 1
        self.column = 0
        self.pos = 0  # Variável para rastrear a posição atual do iterador
        self.afds = [Comment(), Reservada(), MathOperator(), Number(), ID(), StringText()]

    def skip_white_space(self):
        while True:
            try:
                current = next(self.code)
                self.column += 1
                if current == ' ' or current == '\n' or current == '\r' or current == '\t':
                    if current == '\n':
                        self.line_error += 1
                        self.column = 0
                else:
                    break
            except StopIteration:
                break

    def get_tokens(self):
        while True:
            try:
                self.skip_white_space()
                current = next(self.code)
                accepted = False

                for afd in self.afds:
                    self.pos += 1  # Atualizar a posição manualmente
                    pos = self.pos  # Salvar a posição atual
                    t = afd.evaluate(current, self.line_error, abs(self.pos - self.column))

                    if t is not None:
                        accepted = True
                        self.tokens.append(t)
                        break
                    else:
                        self.pos = pos  # Voltar para a posição original

                if not accepted:
                    raise RuntimeError(f"Error: Token not recognized: {current} at line: {self.line_error} column: {abs(self.pos - self.column)}")
            except StopIteration:
                break

        self.tokens.append(Token("EOF", "$", self.line_error, abs(self.pos - self.column)))
        return self.tokens
