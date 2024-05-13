from Token import Token
import Comentario, Delimitadores, ID, MathOperator, Number, Relacao, Types


class Lexer:
    def __init__(self, code):
        self.tokens = []
        self.afds = [
            Comentario.Comentario(),
            Delimitadores.Delimitadores(),
            Types.Types(),
            MathOperator.MathOperator(),
            Relacao.Relacao(),
            Number.Number(),
            ID.ID()
        ]
        self.code = iter(code)
        self.line = 1
        self.last_column = 0

    def skip_white_space(self):
        buffer = []
        for char in self.code:
            if char in [' ', '\n', '\t', '\r']:
                if char == '\n':
                    self.line += 1
                    self.last_column = self.code.index(char)
            else:
                buffer.append(char)
                break
        self.code = iter(buffer + list(self.code)) 

    def get_tokens(self):
        for index, char in enumerate(self.code):
            accepted = False
            self.skip_white_space()
            if char is None:
                break

            char_position = index  # Store the current position of the iterator
            for afd in self.afds:
                t = afd.evaluate(self.code)
                if t:
                    accepted = True
                    if t.tipo != "COMENTARIO":
                        self.tokens.append(t)
                    break
                else:
                    self.code = iter(list(self.code)[char_position:])  # Restore iterator to its position if no token is recognized

            if accepted:
                continue
            raise RuntimeError(f"Error: Token not recognized: {char} | Line: {self.line} Column: {char_position} - {self.last_column}")

        self.tokens.append(Token("EOF", "$"))
        return self.tokens

# Exemplo de teste
if __name__ == "__main__":
    # Exemplo de código para análise
    code_example = "int main() { return 0; }"

    # Crie uma instância do objeto Lexer com o código de exemplo
    lexer = Lexer(code_example)

    # Obtenha os tokens resultantes
    tokens = lexer.get_tokens()

    # Imprima os tokens resultantes
    for token in tokens:
        print(token.tipo, token.lexema)
