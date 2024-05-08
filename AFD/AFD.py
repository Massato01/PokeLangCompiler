from Token.Token import Token


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
            '/':'DIVISAO'
            }
        
        if code and code[0] in operators: # Verifica se o primeiro elemento está no dicionário
            operator = code.pop(0) # Se estiver, remove e pega ele
            return Token(operator, operators[operator]) # Retorna a string "<{self.lexema}, {self.tipo}>"
        
        return None
