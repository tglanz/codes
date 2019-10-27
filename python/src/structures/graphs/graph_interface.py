from abc import ABC, abstractmethod
from typing import Iterable

class GraphInterface(ABC):
    
    @abstractmethod
    def __str__(self) -> str:
        pass

    @abstractmethod
    def add_edge(self, src: int, dst: int):
        pass

    @abstractmethod
    def has_edge(self, src: int, dst: int) -> bool:
        pass