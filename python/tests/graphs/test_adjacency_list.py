from structures.graphs import AdjacencyList as Graph

def test_constructor():
    # arrange
    graph = Graph()

    # assert
    assert graph is not None, "Graph is None"
    assert graph.adjacencies is not None, "Graph should have adjacencies"
    assert len(graph.adjacencies) == 0, "Graph should have adjacencies, but empty"

def test_edges():
    # arrange
    graph = Graph()
    edges = set([(1, 3), (4, 1), (4, 2)])

    # act
    for edge in edges:
        graph.add_edge(*edge)

    # assert
    for src in range(max(map(lambda p: p[0], edges))):
        for dst in range(max(map(lambda p: p[1], edges))):
            edge = (src, dst)
            expected = edge in edges
            actual = graph.has_edge(*edge)
            assert expected == actual, f"expected graph to have edge {edge} is {expected}"

