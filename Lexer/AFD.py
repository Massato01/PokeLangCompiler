from abc import ABC, abstractmethod

class AFD(ABC):
    @abstractmethod
    def evaluate(self, code, line, column):
        pass
