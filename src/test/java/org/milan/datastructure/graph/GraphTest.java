package org.milan.datastructure.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link Graph}
 *
 * @author Milan Rathod
 */
public class GraphTest {

    @Test
    public void testAddEdge() {
        Graph graph = new Graph(5);
        graph.addEdge(graph, 1, 2);

        Assert.assertEquals(2, graph.getAdjList()[1].get(0).intValue());
    }
}