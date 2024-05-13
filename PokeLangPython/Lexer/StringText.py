from AFD import AFD
from Token import Token

class StringText(AFD):
    def evaluate(self, code, line, column):
        string_text = ""

        index = 0
        while index < len(code):
            if code[index] == '"':
                string_text += '"'
                index += 1
                string_text += self.read_string(code[index:])
                index += len(string_text) - 1

                if self.end_string(code[index:]):
                    string_text += '"'
                    index += 1
                    return Token("STRING", string_text, line, column)
            index += 1

        return None

    def read_string(self, code):
        string_text = ""

        index = 0
        while index < len(code) and code[index] != '"' and code[index] != AFD.DONE:
            string_text += code[index]
            index += 1

        return string_text

    def end_string(self, code):
        return code.startswith(('\r', '\n', '"')) or code == AFD.DONE

    def skip_white_space(self, code):  # Adiciona esta função
        while code.current() in (' ', '\n', '\r', '\t'):
            code.next()    