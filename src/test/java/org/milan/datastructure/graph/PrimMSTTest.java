package org.milan.datastructure.graph;

import org.junit.Test;

/**
 * Test class for {@link PrimMST}
 *
 * @author Milan Rathod
 */
public class PrimMSTTest {

    @Test
    public void testFind() {
        WeightedGraph graph = new WeightedGraph(4);

        // Edge 0-1
        graph.addEdge(graph, 0, 1, 10);

        // Edge 0-2
        graph.addEdge(graph, 0, 2, 6);

        // Edge 0-3
        graph.addEdge(graph, 0, 3, 5);

        // Edge 1-3
        graph.addEdge(graph, 1, 3, 15);

        // Edge 2-3
        graph.addEdge(graph, 2, 3, 4);

        PrimMST primMST = new PrimMST();

        primMST.find(graph);
    }
}