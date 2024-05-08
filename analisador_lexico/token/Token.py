class Token:
    def __init__(self, tipo, valor, regex=None):
        """ Performs the creation of an object of type Token

        :param type: Type of the token
        :param value: Value of the token
        :param regex: Regex of the token
        """
        self.tipo = tipo
        self.valor = valor
        self.regex = regex

    def __str__(self):
        """ Custom log

        """
        return "Token({}, {})".format(self.tipo, repr(self.valor))

    def __repr__(self):
        return self.__str__()


token1 = Token("NUMBER", 42)
token2 = Token("STRING", "Hello, world!")
token3 = Token("IDENTIFIER", "variable_name", r"[a-zA-Z_][a-zA-Z0-9_]*")

print(token1)  # Deve imprimir: Token(NUMBER, 42)
print(token2)  # Deve imprimir: Token(STRING, 'Hello, world!')
print(token3)  # Deve imprimir: Token(IDENTIFIER, 'variable_name')
