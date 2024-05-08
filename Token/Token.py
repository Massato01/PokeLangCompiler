class Token:
    '''
    Classe de inicilização dos Tokens
    '''
    def __init__(self, lexema, tipo):
        self.lexema = lexema # Elemento de entrada
        self.tipo = tipo # Tipo do elemento (STR, INT, FLOAT, ...)

    def __str__(self):
        return f"<{self.lexema}, {self.tipo}>" # String de retorno