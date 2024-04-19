from enum import Enum

class Token(Enum):
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

#
    pokeball = 'input'
    pokedex = 'print'
    evolving = 'cast'

print(dir(Token))