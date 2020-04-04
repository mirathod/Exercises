package org.milan.datastructure.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/}
 *
 * @author Milan Rathod
 */
public class KruskalMST {

    private UnionByRank unionByRank;

    public KruskalMST() {
        unionByRank = new UnionByRank();
    }

    public Set<Edge> find(Graph graph) {

        Set<Edge> output = new HashSet<>();

        // Sort all edges in non-decreasing order of their weight
        Set<Edge> edges = new HashSet<>();

        graph.getVertices().forEach(vertex -> edges.addAll(vertex.getEdges()));

        // O(ElogE) to sort the given edges where E is number of edges
        List<Edge> edgeList = edges.stream().sorted(Comparator.comparingInt(Edge::getWeight)).collect(Collectors.toList());

        Subset[] subsets = new Subset[graph.getVertices().size()];

        for (int i = 0; i < subsets.length; i++) {
            subsets[i] = new Subset(i, 0);
        }

        int edgeCount = 0;

        // Index used to take next edge from edgeList
        int index = 0;

        // O(ElogV) to iterate through all edges and apply find-union algorithm
        while (edgeCount < graph.getVertices().size() - 1) {

            // Pick smallest edge from list of edges
            Edge edge = edgeList.get(index++);

            int x = unionByRank.find(subsets, Integer.parseInt(edge.getSrc().getLabel()));
            int y = unionByRank.find(subsets, Integer.parseInt(edge.getDest().getLabel()));

            if (x != y) {
                edgeCount++;
                output.add(edge);
                unionByRank.union(subsets, x, y);
            }
        }

        return output;
    }

    public static class Graph {
        private Set<Vertex> vertices;

        public Graph() {
            vertices = new HashSet<>();
        }

        public Set<Vertex> getVertices() {
            return vertices;
        }

        public boolean addVertex(Vertex vertex) {
            return vertices.add(vertex);
        }
    }
}

class Vertex {
    private String label;

    private Set<Edge> edges;

    public Vertex(String label) {
        this.label = label;
        this.edges = new HashSet<>();
    }

    public String getLabel() {
        return label;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public boolean addEdge(Edge edge) {
        return edges.add(edge);
    }
}

class Edge {
    private Vertex src;

    private Vertex dest;

    private int weight;

    public Edge(Vertex src, Vertex dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public Vertex getSrc() {
        return src;
    }

    public Vertex getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return weight == edge.weight &&
                Objects.equals(src, edge.src) &&
                Objects.equals(dest, edge.dest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(src, dest, weight);
    }
}
