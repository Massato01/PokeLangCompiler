'''
Aqui criamos um dicionário com todos os Tokens de pokémons
'''
from TokenEnum import TokenEnum
from Token import Token


class TokenArray(object):
    def __init__(self, dict_tokens=None):
        """
        Cria um dicionário de Tokens

        :param dict_tokens: Array de Tokens
        """
        if dict_tokens is None:
            dict_tokens = {}
        self.dict_tokens = dict_tokens
        self.add_tokens()

    def add_tokens(self):
        """
        Adiciona todos os Tokens no dicionário
        """
        self.dict_tokens['porygon'] = Token(TokenEnum.porygon, "porygon")
        self.dict_tokens['porygon2'] = Token(TokenEnum.porygon2, "porygon2")
        self.dict_tokens['porygonZ'] = Token(TokenEnum.porygonZ, "porygonZ")
        self.dict_tokens['unown'] = Token(TokenEnum.unown, "unown")
        self.dict_tokens['charizard'] = Token(TokenEnum.charizard, "charizard")
        self.dict_tokens['disguise'] = Token(TokenEnum.disguise, "disguise")
        self.dict_tokens['pikachu'] = Token(TokenEnum.pikachu, "pikachu")
        self.dict_tokens['mimikyu'] = Token(TokenEnum.mimikyu, "mimikyu")
        self.dict_tokens['eevee'] = Token(TokenEnum.eevee, "eevee")
        self.dict_tokens['leafeon'] = Token(TokenEnum.leafeon, "leafeon")
        self.dict_tokens['espeon'] = Token(TokenEnum.espeon, "espeon")
        self.dict_tokens['pokegym'] = Token(TokenEnum.pokegym, "pokegym")
        self.dict_tokens['pokecenter'] = Token(TokenEnum.pokecenter, "pokecenter")
        self.dict_tokens['forretress'] = Token(TokenEnum.forretress, "forretress")
        self.dict_tokens['poliwhirl'] = Token(TokenEnum.poliwhirl, "poliwhirl")
        self.dict_tokens['plusle'] = Token(TokenEnum.plusle, "plusle")
        self.dict_tokens['minun'] = Token(TokenEnum.minun, "minun")
        self.dict_tokens['dialga'] = Token(TokenEnum.dialga, "dialga")
        self.dict_tokens['mew'] = Token(TokenEnum.mew, "mew")
        self.dict_tokens['mewtwo'] = Token(TokenEnum.mewtwo, "mewtwo")
        self.dict_tokens['ditto'] = Token(TokenEnum.ditto, "ditto")
        self.dict_tokens['girafarig'] = Token(TokenEnum.girafarig, "girafarig")
        self.dict_tokens['spoink'] = Token(TokenEnum.spoink, "spoink")
        self.dict_tokens['pokeball'] = Token(TokenEnum.pokeball, "pokeball")
        self.dict_tokens['pokedex'] = Token(TokenEnum.pokedex, "pokedex")
        self.dict_tokens['evolving'] = Token(TokenEnum.evolving, "evolving")

# array = TokenArray()
# print(array.dict_tokens)