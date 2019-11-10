package org.milan.datastructure.graph;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link DepthFirstSearch}
 *
 * @author Milan Rathod
 */
public class DepthFirstSearchTest {

    private DepthFirstSearch depthFirstSearch;

    @Before
    public void setup() {
        Graph graph = new Graph(4);
        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 1, 2);
        graph.addEdge(graph, 2, 0);
        graph.addEdge(graph, 2, 3);
        graph.addEdge(graph, 3, 3);

        depthFirstSearch = new DepthFirstSearch(graph);
    }

    @Test
    public void testDfs() {
        depthFirstSearch.dfs(2);
    }

    @Test
    public void testDfsIterative() {
        depthFirstSearch.dfsIterative(2);
    }
}