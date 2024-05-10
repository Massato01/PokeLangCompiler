class Node:
    def __init__(self, data):
        self.data = data
        self.children = []
        self.enter = ""
        self.exit = ""

    def add_child(self, node):
        self.children.append(node)

    def is_leaf(self):
        return len(self.children) == 0


class Tree:
    def __init__(self, root):
        self.root = root

    def simple_walk(self, node):
        print(f" {node.data} ")
        for child in node.children:
            self.simple_walk(child)

    def walk(self, node):
        print(node.enter, end="")
        if node.is_leaf():
            print(f" {node.data} ", end="")
        for child in node.children:
            self.walk(child)
        print(node.exit, end="")


# Exemplo de uso:
root_node = Node("Raiz")
child1 = Node("Filho 1")
child2 = Node("Filho 2")
root_node.add_child(child1)
root_node.add_child(child2)

tree = Tree(root_node)
tree.simple_walk(root_node)
tree.walk(root_node)
