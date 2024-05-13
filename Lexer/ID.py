from AFD import AFD
from Token import Token

class ID(AFD):
    def evaluate(self, code, line, column):
        code_iter = iter(code)
        current_char = next(code_iter, None)  # Obtém o próximo caractere da sequência
        if current_char is not None and current_char.isalpha():  # Verifica se o caractere é uma letra
            identifier = self.read_id(code_iter, current_char)  # Lê o identificador
            if self.end_id(code_iter):  # Verifica se o identificador terminou
                return Token("ID", identifier, line, column)
        return None

    def read_id(self, code_iter, current_char):
        identifier = ""
        while current_char is not None and current_char.isalnum():  # Enquanto o caractere for uma letra ou um número
            identifier += current_char
            current_char = next(code_iter, None)  # Obtém o próximo caractere
        return identifier

    def end_id(self, code_iter):
        # Verifica se o próximo caractere não é alfanumérico
        return next(code_iter, None) is None

    def skip_white_space(self, code):  # Adiciona esta função
        while code.current() in (' ', '\n', '\r', '\t'):
            code.next()