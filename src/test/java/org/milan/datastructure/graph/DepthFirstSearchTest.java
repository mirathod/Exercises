package org.milan.datastructure.graph;

import org.junit.Test;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class DepthFirstSearchTest {

    @Test
    public void testDfs() {
        Graph graph = new Graph(4);
        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 1, 2);
        graph.addEdge(graph, 2, 0);
        graph.addEdge(graph, 2, 3);
        graph.addEdge(graph, 3, 3);

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph);
        depthFirstSearch.dfs(2);
    }
}