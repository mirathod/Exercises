package org.milan.datastructure.graph;

import org.junit.Test;

/**
 * Test class for {@link DijkstraAlgorithm}
 *
 * @author Milan Rathod
 */
public class DijkstraAlgorithmTest {

    @Test
    public void testFind() {
        WeightedGraph graph = new WeightedGraph(4);

        // Edge 0-1
        graph.addEdge(graph, 0, 1, 10);

        // Edge 0-2
        graph.addEdge(graph, 0, 2, 6);

        // Edge 0-3
        graph.addEdge(graph, 0, 3, 15);

        // Edge 1-3
        graph.addEdge(graph, 1, 3, 15);

        // Edge 2-3
        graph.addEdge(graph, 2, 3, 4);

        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();

        dijkstraAlgorithm.find(graph, 0);
    }
}