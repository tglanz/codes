from structures.heap import Heap

def test_default_constructor():
    heap = Heap()
    assert heap is not None, "shouldn't be None"

def test_min_heap_builder():
    heap = Heap.create_min_heap()
    assert heap is not None, "shouldn't be None"

def test_max_heap_builder():
    heap = Heap.create_min_heap()
    assert heap is not None, "shouldn't be None"

def test_descending_sort():
    # arrange
    array = [4, 2, 7, 1, 3]
    heap = Heap.create_min_heap()
    
    # act
    for value in array:
        heap.add(value)
    
    for _ in array:
        heap.pop()
    
    # assert
    assert all([x == y for (x, y) in zip(heap.values, sorted(array, key=lambda x: x * -1))])


def test_ascending_sort():
    # arrange
    array = [4, 2, 7, 1, 3]
    heap = Heap.create_max_heap()
    
    # act
    for value in array:
        heap.add(value)
    
    for _ in array:
        heap.pop()
    
    # assert
    assert all([x == y for (x, y) in zip(heap.values, sorted(array, key=lambda x: x))])