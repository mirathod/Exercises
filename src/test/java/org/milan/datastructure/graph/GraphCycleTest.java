package org.milan.datastructure.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link GraphCycle}
 *
 * @author Milan Rathod
 */
public class GraphCycleTest {

    @Test
    public void TestIsCycleExists() {
        Graph graph = new Graph(4);
        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 1, 2);
        graph.addEdge(graph, 2, 0);
        graph.addEdge(graph, 2, 3);

        GraphCycle graphCycle = new GraphCycle(graph);

        Assert.assertTrue(graphCycle.isCycleExists());
    }
}