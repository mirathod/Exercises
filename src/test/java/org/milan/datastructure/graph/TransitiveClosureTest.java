package org.milan.datastructure.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link TransitiveClosure}
 *
 * @author Milan Rathod
 */
public class TransitiveClosureTest {

    @Test
    public void testTransitiveClosure() {
        Graph graph = new Graph(4);

        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 1, 2);
        graph.addEdge(graph, 2, 0);
        graph.addEdge(graph, 2, 3);
        graph.addEdge(graph, 3, 3);

        TransitiveClosure transitiveClosure = new TransitiveClosure(graph);

        int[][] result = transitiveClosure.transitiveClosure();

        Assert.assertEquals(1, result[0][0]);
        Assert.assertEquals(0, result[3][0]);
    }
}