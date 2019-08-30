package org.milan.datastructure.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link NodesByLevel}
 *
 * @author Milan Rathod
 */
public class NodesByLevelTest {

    @Test
    public void testTotalNodesByLevel() {
        Graph graph = new Graph(7);
        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 1, 3);
        graph.addEdge(graph, 1, 4);
        graph.addEdge(graph, 1, 5);
        graph.addEdge(graph, 2, 6);

        NodesByLevel nodesByLevel = new NodesByLevel(graph);

        Assert.assertEquals(4, nodesByLevel.totalNodesByLevel(2));
    }
}