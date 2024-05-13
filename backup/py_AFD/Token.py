class Token:
    def __init__(self, tipo, lexema, linha, coluna):
        self.lexema = lexema
        self.tipo = tipo
        self.linha = linha
        self.coluna = coluna

    def get_lexema(self):
        return self.lexema

    def get_tipo(self):
        return self.tipo

    def __str__(self):
        return "<" + self.lexema + ", " + self.tipo + ">"
