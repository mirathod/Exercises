package org.milan.datastructure.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link DisjointSet}
 *
 * @author Milan Rathod
 */
public class DisjointSetTest {

    @Test
    public void testIsCycleExists() {
        Graph graph = new Graph(3, GraphType.UNDIRECTED);

        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 1, 2);
        graph.addEdge(graph, 0, 2);

        DisjointSet disjointSet = new DisjointSet();

        Assert.assertTrue(disjointSet.isCycleExists(graph));
    }
}