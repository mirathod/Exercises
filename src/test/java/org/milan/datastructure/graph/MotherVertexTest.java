package org.milan.datastructure.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link MotherVertex}
 *
 * @author Milan Rathod
 */
public class MotherVertexTest {

    @Test
    public void testFind() {
        Graph graph = new Graph(7);
        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 1, 3);
        graph.addEdge(graph, 4, 1);
        graph.addEdge(graph, 6, 4);
        graph.addEdge(graph, 5, 6);
        graph.addEdge(graph, 5, 2);
        graph.addEdge(graph, 6, 0);

        MotherVertex motherVertex = new MotherVertex(graph);

        int result = motherVertex.find();

        Assert.assertEquals(5, result);
    }
}