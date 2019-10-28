import operator
from math import floor

class Heap:
    __slots__ = ['preceeds', 'values', 'size']
    
    def __init__(self, preceeds = None):
        self.preceeds = preceeds or operator.ge
        self.values = []
        self.size = 0

    @staticmethod
    def create_min_heap():
        return Heap(preceeds=operator.le)
    
    @staticmethod
    def create_max_heap():
        return Heap(preceeds=operator.ge)

    def append(self, value):
        self.values.extend([None] * (self.size + 1 - len(self.values)))
        self.values[self.size] = value
        self.size += 1

    def add(self, value):
        self.append(value)
        self.heapify_up(self.size - 1)
    
    def pop(self):
        self.size -= 1
        self.swap(0, self.size)
        self.heapify_down(0)
        return self.values[self.size]
    
    def swap(self, i, j):
        swap = self.values[i]
        self.values[i] = self.values[j]
        self.values[j] = swap
    
    def heapify_up(self, index):
        if index <= 0:
            return
        
        parent_index = floor((index - 1) / 2)
        value = self.values[index]
        parent_value = self.values[parent_index]

        if self.preceeds(value, parent_value):
            self.swap(index, parent_index)
            self.heapify_up(parent_index)
    
    def heapify_down(self, index):
        if index >= self.size:
            return

        value = self.values[index]

        left_index, right_index = (2*index + 1, 2*index + 2)

        smallest_index = index
        smallest_value = value

        if left_index < self.size:
            left_value = self.values[left_index]
            if self.preceeds(left_value, smallest_value):
                smallest_value = left_value
                smallest_index = left_index
        
        if right_index < self.size:
            right_value = self.values[right_index]
            if self.preceeds(right_value, smallest_value):
                smallest_value = right_value
                smallest_index = right_index
        
        if smallest_index != index:
            self.swap(index, smallest_index)
            self.heapify_down(smallest_index)


                