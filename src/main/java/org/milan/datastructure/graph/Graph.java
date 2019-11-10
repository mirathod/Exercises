package org.milan.datastructure.graph;

import java.util.LinkedList;

/**
 * A graph is an array of adjacency lists.
 * Size of an array is V (number of vertices in graph)
 *
 * @author Milan Rathod
 */
public class Graph {

    private int size;

    private LinkedList<Integer>[] adjList;

    /**
     * Default type is directed graph
     */
    private GraphType graphType;

    public Graph(int size) {
        this(size, GraphType.DIRECTED);
    }

    public Graph(int size, GraphType graphType) {
        this.graphType = graphType;
        this.size = size;

        adjList = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    /**
     * Get size of the graph
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Get adjacency list
     */
    public LinkedList<Integer>[] getAdjList() {
        return this.adjList;
    }

    /**
     * Add an edge between two vertices in given graph
     */
    public void addEdge(Graph graph, int src, int dest) {
        // Add an edge from src to dest
        graph.adjList[src].add(dest);

        if (graphType.equals(GraphType.UNDIRECTED)) {
            // Since graph is undirected, add an edge from dest to src
            graph.adjList[dest].add(src);
        }
    }
}

/**
 * Enum for type of graphs
 */
enum GraphType {
    DIRECTED, UNDIRECTED
}
