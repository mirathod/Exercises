package org.milan.datastructure.graph;

import org.junit.Test;

/**
 * Test Class for {@link BreadthFirstSearch}
 *
 * @author Milan Rathod
 */
public class BreadthFirstSearchTest {

    @Test
    public void testBfs() {
        Graph graph = new Graph(4);
        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 1, 2);
        graph.addEdge(graph, 2, 0);
        graph.addEdge(graph, 2, 3);
        graph.addEdge(graph, 3, 3);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);
        breadthFirstSearch.bfs(2);
    }
}