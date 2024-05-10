from Token.Token import Token
from AFD.AFD import *


class Lexer:
    '''
    Analisador Léxico, faz a verificação se os tokens estão corretos
    '''
    def __init__(self, code):
        self.tokens = [] # Lista para retornar os tokens
        self.code = list(code) # Lista para receber os tokens no input
        self.afds = [Number(), MathOperator(), String()] # AFDs que analisarão os caracteres

    def skip_white_space(self): # Pula os espaços em branco para não classificar incorretamente
        while self.code and self.code[0].isspace():
            self.code.pop(0)

    def get_tokens(self): # Realiza a verificação dos tokens
        while self.code: # Loop para percorrer o valor de entrada
            self.skip_white_space() # Pula espaços em branco
            
            token = None 
            for afd in self.afds: # Loop nas AFDs para utilizar todas as verificações

                token = afd.evaluate(self.code) # Realiza a verificação com a AFD atual
                if token: # Se um token for identificado, armazena na lista de tokens
                    self.tokens.append(token)
                    break

            if not token: # Senão interrompe e exibe um erro
                raise Exception(f"Erro: Token não reconhecido: {self.code[0]}")
            
        self.tokens.append(Token("$", "EOF")) # End Of File
        return self.tokens # Retorna a lista de tokens

if __name__ == "__main__":
    data = "1 +32 CHARLESGOSTOSO teste 2-346 * 45 / 5.3 () { } []"
    lexer = Lexer(data)
    tokens = lexer.get_tokens()

    for token in tokens:
        print(token)
