package org.milan.datastructure.graph;

import org.junit.Test;

/**
 * Test Class for {@link KosarajuAlgorithm}
 *
 * @author Milan Rathod
 */
public class KosarajuAlgorithmTest {

    @Test
    public void testPrintSCCs() {
        Graph graph = new Graph(5);
        graph.addEdge(graph, 1, 0);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 2, 1);
        graph.addEdge(graph, 0, 3);
        graph.addEdge(graph, 3, 4);

        KosarajuAlgorithm kosarajuAlgorithm = new KosarajuAlgorithm(graph);
        kosarajuAlgorithm.printSCCs();
    }
}