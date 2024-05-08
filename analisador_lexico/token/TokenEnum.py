from enum import Enum

class TokenEnum(Enum):
# Tipos
    porygon = 'int'
    porygon2 = 'float'
    porygonZ = 'Double'
    unown = 'string'
    charizard = 'char'
    pikachu = 'True'
    mimikyu = 'False'
    disguise = 'bool'

# Condição
    eevee = 'if'
    leafeon = 'elif'
    espeon = 'else'
    pokegym = 'function'
    pokecenter = 'return'

# Loop
    forretress = 'for'
    poliwhirl = 'while'

# Operação
    plusle = '+'
    minun = '-'
    dialga = '*'
    palkia = '/'
    mew = '='
    mewtwo = '=='
    ditto = '!='
    girafarig = '&&'
    farigiraf = '||'
    spoink = '\n'

# Leitura
    pokeball = 'input'
    pokedex = 'print'
    evolving = 'cast'


# print(dir(Token))
# print(TokenDict.porygon.value)
