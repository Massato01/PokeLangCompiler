from analisador_lexico.token import Token
from analisador_lexico.token_dicionario import TokenDict


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
        self.dict_tokens['porygon'] = Token(TokenDict.porygon, "porygon", r"^(porygon)$")
        self.dict_tokens['porygon2'] = Token(TokenDict.porygon2, "porygon2", r"^(porygon2)$")
        self.dict_tokens['porygonZ'] = Token(TokenDict.porygonZ, "porygonZ", r"^(porygonZ)$")
        self.dict_tokens['unown'] = Token(TokenDict.unown, "unown", r"^(unown)$")
        self.dict_tokens['charizard'] = Token(TokenDict.charizard, "charizard", r"^(charizard)$")
        self.dict_tokens['disguise'] = Token(TokenDict.disguise, "disguise", r"^(disguise)$")
        self.dict_tokens['pikachu'] = Token(TokenDict.pikachu, "pikachu", r"^(pikachu)$")
        self.dict_tokens['mimikyu'] = Token(TokenDict.mimikyu, "mimikyu", r"^(mimikyu)$")
        self.dict_tokens['eevee'] = Token(TokenDict.eevee, "eevee", r"^(eevee)$")
        self.dict_tokens['leafeon'] = Token(TokenDict.leafeon, "leafeon", r"^(leafeon)$")
        self.dict_tokens['espeon'] = Token(TokenDict.espeon, "espeon", r"^(espeon)$")
        self.dict_tokens['pokegym'] = Token(TokenDict.pokegym, "pokegym", r"^(pokegym)$")
        self.dict_tokens['pokecenter'] = Token(TokenDict.pokecenter, "pokecenter", r"^(pokecenter)$")
        self.dict_tokens['forretress'] = Token(TokenDict.forretress, "forretress", r"^(forretress)$")
        self.dict_tokens['poliwhirl'] = Token(TokenDict.poliwhirl, "poliwhirl", r"^(poliwhirl)$")
        self.dict_tokens['plusle'] = Token(TokenDict.plusle, "plusle", r"^(plusle)$")
        self.dict_tokens['minun'] = Token(TokenDict.minun, "minun", r"^(minun)$")
        self.dict_tokens['dialga'] = Token(TokenDict.dialga, "dialga", r"^(dialga)$")
        self.dict_tokens['mew'] = Token(TokenDict.mew, "mew", r"^(mew)$")
        self.dict_tokens['mewtwo'] = Token(TokenDict.mewtwo, "mewtwo", r"^(mewtwo)$")
        self.dict_tokens['ditto'] = Token(TokenDict.ditto, "ditto", r"^(ditto)$")
        self.dict_tokens['girafarig'] = Token(TokenDict.girafarig, "girafarig", r"^(girafarig)$")
        self.dict_tokens['spoink'] = Token(TokenDict.spoink, "spoink", r"^(spoink)$")
        self.dict_tokens['pokeball'] = Token(TokenDict.pokeball, "pokeball", r"^(pokeball)$")
        self.dict_tokens['pokedex'] = Token(TokenDict.pokedex, "pokedex", r"^(pokedex)$")
        self.dict_tokens['evolving'] = Token(TokenDict.evolving, "evolving", r"^(evolving)$")
