package org.milan.datastructure.graph;

import java.util.LinkedList;

/**
 * Graph representation where each edge contains some weights
 *
 * @author Milan Rathod
 */
public class WeightedGraph {
    private int size;

    private LinkedList<Node>[] adjList;

    public WeightedGraph(int size) {
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
    public LinkedList<Node>[] getAdjList() {
        return this.adjList;
    }

    /**
     * Add an edge between two vertices in given graph
     */
    public void addEdge(WeightedGraph graph, int src, int dest, int weight) {
        Node srcNode = new Node(src, weight);

        Node destNode = new Node(dest, weight);

        graph.adjList[src].add(destNode);
        graph.adjList[dest].add(srcNode);
    }
}

class Node {
    int dest;

    int weight;

    public Node(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}