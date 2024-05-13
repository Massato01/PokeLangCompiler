from AFD import AFD
from Token import Token

class Reservada(AFD):
    reservadas = ["eevee", "espeon", "forretress", "poliwhirl", "porygon", "squirtle", "unown", "pokeball", "pokedex", "ditto"]

    def evaluate(self, code, linha, column):
        reservada = ""

        for palavra_reservada in self.reservadas:
            iterator = iter(code)
            i = 0
            try:
                while i < len(palavra_reservada) and next(iterator) == palavra_reservada[i]:
                    reservada += palavra_reservada[i]
                    i += 1
            except StopIteration:
                pass

            if i == len(palavra_reservada) and (not iterator or next(iterator) in (' ', '(', ')', '')):
                return Token("RESERVADA_" + palavra_reservada.upper(), reservada, linha, column)

        return None
