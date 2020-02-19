package org.milan.datastructure.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link UnionByRank}
 *
 * @author Milan Rathod
 */
public class UnionByRankTest {

    @Test
    public void testIsCycleExists() {
        Graph graph = new Graph(3, GraphType.UNDIRECTED);

        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 1, 2);
        graph.addEdge(graph, 0, 2);

        UnionByRank unionByRank = new UnionByRank();

        Assert.assertTrue(unionByRank.isCycleExists(graph));
    }
}