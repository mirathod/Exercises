package org.milan.datastructure.graph;

import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * Test class for {@link KruskalMST}
 *
 * @author Milan Rathod
 */
public class KruskalMSTTest {

    @Test
    public void testFind() {
        KruskalMST.Graph graph = new KruskalMST.Graph();

        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");

        // Edge 0-1
        v0.addEdge(new Edge(v0, v1, 10));

        // Edge 0-2
        v0.addEdge(new Edge(v0, v2, 6));

        // Edge 0-3
        v0.addEdge(new Edge(v0, v3, 5));

        // Edge 1-3
        v1.addEdge(new Edge(v1, v3, 15));

        // Edge 2-3
        v2.addEdge(new Edge(v2, v3, 4));

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        KruskalMST kruskalMST = new KruskalMST();

        Set<Edge> result = kruskalMST.find(graph);

        Assert.assertEquals(Sets.newHashSet(new Edge(v2, v3, 4), new Edge(v0, v3, 5), new Edge(v0, v1, 10)), result);
    }
}