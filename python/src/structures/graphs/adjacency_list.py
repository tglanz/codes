from os import linesep
from dataclasses import dataclass, field
from typing import List, Set

from . import GraphInterface

@dataclass
class Node:
    value: any = None
    adjacencies: Set[int] = field(default_factory=set)

@dataclass
class AdjacencyList(GraphInterface):
    
    adjacencies: List[Node] = field(default_factory=list)

    def __str__(self) -> str:
        lines = []
        for idx, node in enumerate(self.adjacencies):
            sequence = (idx, *node.adjacencies)
            lines.append(" -> ".join(map(str, sequence)))
        return linesep.join(lines)

    def add_edge(self, src: int, dst: int):
        self.fit_to_size(max(src, dst))
        self.adjacencies[src].adjacencies.add(dst)
    
    def has_edge(self, src: int, dst: int) -> bool:
        self.fit_to_size(max(src, dst))
        return dst in self.adjacencies[src].adjacencies
    
    def fit_to_size(self, required: int):
        while len(self.adjacencies) <= required:
            self.adjacencies.append(Node())