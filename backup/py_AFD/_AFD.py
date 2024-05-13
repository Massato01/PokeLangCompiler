from abc import ABC, abstractmethod
from typing import Iterator

from Token import Token


class AFD(ABC):
    @abstractmethod
    def evaluate(self, code: Iterator[str]) -> Token:
        pass
