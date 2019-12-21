package org.milan.datastructure.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Test class for {@link TopologicalSort}
 *
 * @author Milan Rathod
 */
public class TopologicalSortTest {

    @Test
    public void testSort() {
        Graph graph = new Graph(6);
        graph.addEdge(graph, 5, 2);
        graph.addEdge(graph, 5, 0);
        graph.addEdge(graph, 4, 0);
        graph.addEdge(graph, 4, 1);
        graph.addEdge(graph, 2, 3);
        graph.addEdge(graph, 3, 1);

        TopologicalSort topologicalSort = new TopologicalSort(graph);

        List<Integer> sortedList = topologicalSort.sort();

        Assert.assertEquals(Arrays.asList(5, 4, 2, 3, 1, 0), sortedList);
    }
}