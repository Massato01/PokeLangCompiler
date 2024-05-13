from AFD import AFD
from Token import Token

class Comment(AFD):
    def evaluate(self, code, line, column):
        comment = ""

        for char in code:
            if char == '#':
                comment += "#"
                next_char = next(code, None)
                while next_char and next_char not in {'\r', '\n'}:
                    comment += next_char
                    next_char = next(code, None)

                if not next_char or next_char == '\r' or next_char == '\n':
                    return Token("COMENTARIO", comment, line, column)

        return None
