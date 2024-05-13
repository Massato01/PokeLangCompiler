import io
from Lexer import Lexer
# from Lexer.Token import Token
# from Sintatico import Parser

def main():
    tokens = None

    # codigo_fonte = arquivo()
    codigo_fonte = 'porygon x = 1'

    lexer = Lexer(codigo_fonte)
    tokens = lexer.get_tokens()

    # print(tokens)

    for token in tokens:
        print(token)

    # parser = Parser(tokens)
    # parser.main()

def arquivo():
    with io.open("validacao.txt", "r", encoding="utf-8") as file:
        data = file.read()
    return data

if __name__ == "__main__":
    main()
