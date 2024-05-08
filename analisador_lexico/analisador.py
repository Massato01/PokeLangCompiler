# class Token:
#     def __init__(self, lexema, tipo):
#         self.lexema = lexema
#         self.tipo = tipo

#     def __str__(self):
#         return f"<{self.lexema}, {self.tipo}>"

# class Number:
#     def evaluate(self, code):
#         number = ''
#         while code and code[0].isdigit():
#             number += code.pop(0)
#         if number:
#             return Token(number, "NUMERO, [0-9]")
#         return None

# class MathOperator:
#     def evaluate(self, code):
#         operators = {'+': 'SOMA', '-': 'SUB', '*': 'MUL', '/': 'DIV'}
#         if code and code[0] in operators:
#             operator = code.pop(0)
#             return Token(operator, operators[operator])
#         return None

# class Lexer:
#     def __init__(self, code):
#         self.tokens = []
#         self.code = list(code)
#         self.afds = [Number(), MathOperator()]

#     def skip_white_space(self):
#         while self.code and self.code[0].isspace():
#             self.code.pop(0)

#     def get_tokens(self):
#         while self.code:
#             self.skip_white_space()
#             token = None
#             for afd in self.afds:
#                 token = afd.evaluate(self.code)
#                 if token:
#                     self.tokens.append(token)
#                     break
#             if not token:
#                 raise Exception(f"Erro: Token não reconhecido: {self.code[0]}")
#         self.tokens.append(Token("$", "EOF"))
#         return self.tokens

# if __name__ == "__main__":
#     data = "1 +32 2-346 * 45/ 53"
#     lexer = Lexer(data)
#     tokens = lexer.get_tokens()

#     for token in tokens:
#         print(token)









import re
from typing import Optional, Match, List, Any
from token.TokenEnum import TokenEnum
from typing.io import TextIO
from token.TokenArray import TokenArray
from token.Token import Token
"""
Check if the words (tokens) are correct
"""


class Lexer:
    def __init__(self):
        """ Performs the creation of an object of type Lexer

        """
        self.token_array = TokenArray()
        self.current_text: str or None = None
        self.is_reading: bool = False

        self.all_tokens: List[Token] or None = None
        self.index_tokens = 0
        self.current_token = None

        self.pattern_split_semicolon = ''';(?=(?:"[^"]*")*$)'''
        self.pattern_split_text = '''\s+(?=(?:[^"]|"[^"]*")*$)'''

    def run_lexer(self, code: TextIO) -> List[Any]:
        """ Run the lexer to get all tokens in .dtb file

        """
        self.all_tokens: List[Any] = []

        for line in code.readlines():
            space_semicolon = re.sub(self.pattern_split_semicolon, ' ;', line)
            splited_line = re.split(self.pattern_split_text, space_semicolon)
            splited_line = list(filter(''.__ne__, splited_line))
            for word in splited_line:
                self.get_input(word)
                try:
                    tokens = self.get_tokens()
                    self.all_tokens.extend(tokens)
                except Exception as e:
                    self.all_tokens.append(e)

                self.finish()

        return self.all_tokens

    def get_input(self, text):
        """ Get the text input and set in current text variable

        :param text: text to set in current_text

        """
        self.current_text = text
        self.is_reading = True

    def finish(self):
        """ Finish the read

        """
        self.current_text: str or None = None
        self.is_reading: bool = False

    def check_word(self, pattern: str, text: str) -> Optional[Match[str]]:
        """ Check the word

        """
        match = re.match(pattern, text, re.MULTILINE)
        return match

    def replace_word(self, pattern: str, replacement: str, target: str):
        """ Replace the word

        """
        return re.sub(pattern, replacement, target)

    def find_longest_match(self):
        """ Find the longest match

        """
        max_match = [0, None]
        k_index = -1

        for k, v in self.token_array.dict_tokens.items():
            match = self.check_word(v.regex, self.current_text)
            if match:
                num_match = match.end() - match.start()
                if num_match > max_match[0]:
                    max_match = [num_match, match]
                    k_index = k

        return max_match[1], k_index

    def get_tokens(self) -> List[Token]:
        """ return the list of all tokens

        """
        if not self.is_reading:
            return []

        error = False

        tokens = []

        while self.current_text != "" and not error:
            continue_loop = False
            # print(f"current text: {self.current_text}")

            match, k = self.find_longest_match()
            if match:
                aaa = match[0]
                # print(f"\tinside if: {self.token_array.dict_tokens[k].type}")
                if self.token_array.dict_tokens[k].type == TokenEnum.INTEGER:
                    tokens.append(Token(self.token_array.dict_tokens[k].type, int(match[0])))
                elif self.token_array.dict_tokens[k].type == TokenEnum.FLOAT:
                    tokens.append(Token(self.token_array.dict_tokens[k].type, float(match[0])))
                else:
                    tokens.append(Token(self.token_array.dict_tokens[k].type, match[0]))
                self.current_text = self.replace_word(self.token_array.dict_tokens[k].regex, '', self.current_text)
                continue_loop = True

            if continue_loop:
                continue

            error = True

        if len(tokens) == 0 or error:
            self.error(self.current_text)

        return tokens

    def error(self, text):
        """ Raise a custom exception

        """
        raise Exception(f"Invalid token: {text}")
