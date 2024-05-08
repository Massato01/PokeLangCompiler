class Token:
    def __init__(self, lexema, tipo):
        self.lexema = lexema
        self.tipo = tipo

    def __str__(self):
        return f"<{self.lexema}, {self.tipo}>"

class Number:
    def evaluate(self, code):
        number = ''
        decimal_encontrado = False
        while code and (code[0].isdigit() or (code[0] == '.' and not decimal_encontrado)):
            if code[0] == '.':
                decimal_encontrado = True
            number += code.pop(0)
        if number:
            tipo = "NUMERO"
            if decimal_encontrado:
                tipo = "FLUTUANTE"
            return Token(number, tipo)
        return None

class MathOperator:
    def evaluate(self, code):
        operators = {'+': 'SOMA', '-': 'SUB', '*': 'MUL', '/': 'DIV'}
        if code and code[0] in operators:
            operator = code.pop(0)
            return Token(operator, operators[operator])
        return None

class Lexer:
    def __init__(self, code):
        self.tokens = []
        self.code = list(code)
        self.afds = [Number(), MathOperator()]

    def skip_white_space(self):
        while self.code and self.code[0].isspace():
            self.code.pop(0)

    def get_tokens(self):
        while self.code:
            self.skip_white_space()
            token = None
            for afd in self.afds:
                token = afd.evaluate(self.code)
                if token:
                    self.tokens.append(token)
                    break
            if not token:
                raise Exception(f"Erro: Token não reconhecido: {self.code[0]}")
        self.tokens.append(Token("$", "EOF"))
        return self.tokens

if __name__ == "__main__":
    data = "1 +32 2-346 * 45/ 5.3"
    lexer = Lexer(data)
    tokens = lexer.get_tokens()

    for token in tokens:
        print(token)