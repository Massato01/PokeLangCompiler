class Token:
    def __init__(self, lexema, tipo):
        self.lexema = lexema
        self.tipo = tipo

    def __str__(self):
        return f"<{self.lexema}, {self.tipo}>"

class Number:
    '''
    Função que verifica se o caracter atual é um número ou um flutuante
    '''
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
    '''
    Função que verifica se o caracter atual é algum operador listado no dicionário "operators"
    '''
    def evaluate(self, code):
        operators = {
            '+': 'SOMA',
            '-': 'SUBTRACAO',
            '*': 'MULTIPLICACAO',
            '/':'DIVISAO'
            }
        
        if code and code[0] in operators:
            operator = code.pop(0)
            return Token(operator, operators[operator])
        return None

class Lexer:
    '''
    Analisador Léxico, faz a verificação se os tokens estão corretos
    '''
    def __init__(self, code):
        self.tokens = [] # Lista para retornar os tokens
        self.code = list(code) # Lista para receber os tokens no input
        self.afds = [Number(), MathOperator()] # AFDs que analisarão os caracteres

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
    data = "1 +32 2-346 * 45 / 5.3"
    lexer = Lexer(data)
    tokens = lexer.get_tokens()

    for token in tokens:
        print(token)