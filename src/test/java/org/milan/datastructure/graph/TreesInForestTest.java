package org.milan.datastructure.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link TreesInForest}
 *
 * @author Milan Rathod
 */
public class TreesInForestTest {

    @Test
    public void totalTrees() {
        Graph graph = new Graph(5);
        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 3, 4);

        TreesInForest treesInForest = new TreesInForest(graph);

        Assert.assertEquals(2, treesInForest.totalTrees());
    }
}