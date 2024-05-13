class Token:
    '''
    Classe de inicilização dos Tokens
    '''
    def __init__(self, lexema, tipo):
        self.lexema = lexema # Elemento de entrada
        self.tipo = tipo # Tipo do elemento (STR, INT, FLOAT, ...)

    def __str__(self):
        return f"<{self.lexema}, {self.tipo}>" # String de retorno


class Number:
    '''
    Função que verifica se o caracter atual é um número ou um flutuante
    '''
    def evaluate(self, code):
        number = ''
        decimal_encontrado = False
        while code and (code[0].isdigit() or (code[0] == '.' and not decimal_encontrado)): # Loop para dígitos númericos(int) ou floats

            if code[0] == '.': # Se for encontrado "." é considerado float
                decimal_encontrado = True # Ativa a flag de decimal

            number += code.pop(0) # Remove e pega o primeiro elemento da lista "code"

        if number:
            tipo = "NUMERO"
            if decimal_encontrado:
                tipo = "FLUTUANTE"

            return Token(number, tipo) # Retorna a string "<{self.lexema}, {self.tipo}>"
        return None


class String:
    '''
    Função que verifica se o caracter atual é uma string
    '''
    def evaluate(self, code):
        string = ''
        while code and code[0].isalpha(): # Loop para strings

            string += code.pop(0) # Remove e pega o primeiro elemento da lista "code"

        if string:
            tipo = "STRING"

            return Token(string, tipo) # Retorna a string "<{self.lexema}, {self.tipo}>"
        return None
    

class MathOperator:
    '''
    Função que verifica se o caracter atual é algum operador listado no dicionário "operators"
    '''
    def evaluate(self, code):
        operators = { # Dicionário de operadores matemáticos
            '+': 'SOMA',
            '-': 'SUBTRACAO',
            '*': 'MULTIPLICACAO',
            '/': 'DIVISAO',
            '(': 'LPAREN',
            ')': 'RPAREN',
            '{': 'LCHAVE',
            '}': 'RCHAVE',
            '[': 'LCOLCHETE',
            ']': 'RCOLCHETE',
            '>': 'MAIORQUE',
            '<': 'MENORQUE',
            '&': 'AND',
            '|': 'OR',
            '=': "ATRIBUICAO",
            '==': 'IGUAL',
            '!=': 'DIFERENTE',
            '++': 'INCREMENTO'
            }
        
        if code and code[0] in operators: # Verifica se o primeiro elemento está no dicionário
            operator = code.pop(0) # Se estiver, remove e pega ele
            return Token(operator, operators[operator]) # Retorna a string "<{self.lexema}, {self.tipo}>"
        
        return None
    

class Reservada:
    '''
    Função que verifica se o caracter atual é algum operador listado no dicionário "operators"
    '''
    def evaluate(self, code):
        reservadas = { # Dicionário de palavras reservadas
        'eevee': 'if',
        'leafeon': 'elif',
        'espeon': 'else',
        'pokegym': 'function',
        'pokecenter': 'return',
        '==': 'equals',
        '=': 'atribuicao',
        'pokedex': 'print'
        }

        reservada = ''
        
        for i in range(len(reservadas)):
        if code and code[0] in reservadas: # Verifica se o primeiro elemento está no dicionário
            reservada = code.pop(0) # Se estiver, remove e pega ele
            return Token(reservada, reservadas[reservada]) # Retorna a string "<{self.lexema}, {self.tipo}>"
        
        return None
    

class Lexer:
    '''
    Analisador Léxico, faz a verificação se os tokens estão corretos
    '''
    def __init__(self, code):
        self.tokens = [] # Lista para retornar os tokens
        self.code = list(code) # Lista para receber os tokens no input
        self.afds = [Number(), MathOperator(), String(), Reservada()] # AFDs que analisarão os caracteres

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
    data = "eevee x == 10 pokedex x"
    lexer = Lexer(data)
    tokens = lexer.get_tokens()

    for token in tokens:
        print(token)
