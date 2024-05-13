class Token:
    '''
    Classe de inicilização dos Tokens
    '''
    def __init__(self, lexema, tipo):
        self.lexema = lexema # Elemento de entrada
        self.tipo = tipo # Tipo do elemento (STR, INT, FLOAT, ...)

    def get_lexema(self):
        return self.lexema
    
    def get_tipo(self):
        return self.tipo

    def to_string(self):
        return f"<{self.lexema}, {self.tipo}>" # String de retorno

# print('deu certo')