from TreeNode import Node, Tree

class Parser:
    def __init__(self, tokens):
        self.tokens = tokens
        self.token = None

    def main(self):
        node = Node("ifelse")
        tree = Tree(node)

        self.token = self.get_next_token()
        if self.ifelse(node):
            if self.token.tipo == "EOF":
                print("\nSintaticamente correta")
                return tree
            else:
                self.erro("main")
        self.erro("main")
        return None

    def get_next_token(self):
        if len(self.tokens) > 0:
            return self.tokens.pop(0)
        else:
            return None

    def erro(self, node):
        print(f"regra: {node}")
        print(f"token inválido: {self.token.lexema}")
        exit(0)

    def ifelse(self, node):
        if (
            self.match_l("se", "if", node)
            and self.condicao(node.add_child("condicao"))
            and self.match_l("entao", "", node)
            and self.expressao(node.add_child("expressao"))
            and self.match_l("senao", "else", node)
            and self.expressao(node.add_child("expressao"))
        ):
            return True

        self.erro("ifelse")
        return False

    def expressao(self, node):
        node.enter = "{"
        if (
            self.var(node.add_child("var"))
            and self.operador_atribuicao(node.add_child("operadorAtribuicao"))
            and self.num(node.add_child("num"))
        ):
            node.exit = "}"
            return True
        self.erro("expressao")
        return False

    def operador(self, node):
        if self.match_l(">", ">", node) or self.match_l("<", "<", node) or self.match_l("==", "==", node):
            return True
        self.erro("operador")
        return False

    def condicao(self, node):
        node.enter = "("
        if self.var(node.add_child("var")) and self.operador(node.add_child("operador")) and self.num(
            node.add_child("num")
        ):
            node.exit = ")"
            return True
        self.erro("condicao")
        return False

    def operador_atribuicao(self, node):
        if self.match_l("=", self.token.lexema, node):
            return True
        self.erro("operadorAtribuicao")
        return False

    def var(self, node):
        if self.match_t("id", self.token.lexema, node):
            return True
        self.erro("var")
        return False

    def num(self, node):
        if self.match_t("num", self.token.lexema, node):
            return True
        self.erro("num")
        return False

    def match_l(self, palavra, newcode, node):
        if self.token.lexema == palavra:
            node.add_child(newcode)
            self.token = self.get_next_token()
            return True
        self.erro(palavra)
        return False

    def match_t(self, palavra, newcode, node):
        if self.token.tipo == palavra:
            node.add_child(newcode)
            self.token = self.get_next_token()
            return True
        self.erro(palavra)
        return False
