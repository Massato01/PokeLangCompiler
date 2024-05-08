from analisador_lexico.token.Token import Token
from analisador_lexico.token.TokenEnum import TokenEnum


class TokenArray(object):
    def __init__(self, dict_tokens=None):
        """ Performs the creation of an object of type TokenArray

        :param dict_tokens: Array of tokens
        """
        if dict_tokens is None:
            dict_tokens = {}
        self.dict_tokens = dict_tokens
        self.add_tokens()

    def add_tokens(self):
        """ Added all tokens in array

        """
        self.dict_tokens['porygon'] = Token(TokenEnum.porygon, "porygon", r"^(porygon)$")
        self.dict_tokens['porygon2'] = Token(TokenEnum.porygon2, "porygon2", r"^(porygon2)$")
        self.dict_tokens['porygonZ'] = Token(TokenEnum.porygonZ, "porygonZ", r"^(porygonZ)$")
        self.dict_tokens['unown'] = Token(TokenEnum.unown, "unown", r"^(unown)$")
        self.dict_tokens['charizard'] = Token(TokenEnum.charizard, "charizard", r"^(charizard)$")
        self.dict_tokens['disguise'] = Token(TokenEnum.disguise, "disguise", r"^(disguise)$")
        self.dict_tokens['pikachu'] = Token(TokenEnum.pikachu, "pikachu", r"^(pikachu)$")
        self.dict_tokens['mimikyu'] = Token(TokenEnum.mimikyu, "mimikyu", r"^(mimikyu)$")
        self.dict_tokens['eevee'] = Token(TokenEnum.eevee, "eevee", r"^(eevee)$")
        self.dict_tokens['leafeon'] = Token(TokenEnum.leafeon, "leafeon", r"^(leafeon)$")
        self.dict_tokens['espeon'] = Token(TokenEnum.espeon, "espeon", r"^(espeon)$")
        self.dict_tokens['pokegym'] = Token(TokenEnum.pokegym, "pokegym", r"^(pokegym)$")
        self.dict_tokens['pokecenter'] = Token(TokenEnum.pokecenter, "pokecenter", r"^(pokecenter)$")
        self.dict_tokens['forretress'] = Token(TokenEnum.forretress, "forretress", r"^(forretress)$")
        self.dict_tokens['poliwhirl'] = Token(TokenEnum.poliwhirl, "poliwhirl", r"^(poliwhirl)$")
        self.dict_tokens['plusle'] = Token(TokenEnum.plusle, "plusle", r"^(plusle)$")
        self.dict_tokens['minun'] = Token(TokenEnum.minun, "minun", r"^(minun)$")
        self.dict_tokens['dialga'] = Token(TokenEnum.dialga, "dialga", r"^(dialga)$")
        self.dict_tokens['mew'] = Token(TokenEnum.mew, "mew", r"^(mew)$")
        self.dict_tokens['mewtwo'] = Token(TokenEnum.mewtwo, "mewtwo", r"^(mewtwo)$")
        self.dict_tokens['ditto'] = Token(TokenEnum.ditto, "ditto", r"^(ditto)$")
        self.dict_tokens['girafarig'] = Token(TokenEnum.girafarig, "girafarig", r"^(girafarig)$")
        self.dict_tokens['spoink'] = Token(TokenEnum.spoink, "spoink", r"^(spoink)$")
        self.dict_tokens['pokeball'] = Token(TokenEnum.pokeball, "pokeball", r"^(pokeball)$")
        self.dict_tokens['pokedex'] = Token(TokenEnum.pokedex, "pokedex", r"^(pokedex)$")
        self.dict_tokens['evolving'] = Token(TokenEnum.evolving, "evolving", r"^(evolving)$")
