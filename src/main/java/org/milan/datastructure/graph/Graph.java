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

    public Graph(int size) {
        this.size = size;

        adjList = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public int getSize() {
        return this.size;
    }

    public LinkedList<Integer>[] getAdjList() {
        return this.adjList;
    }

    /**
     * Add an edge between two vertices in directed graph
     */
    public void addEdge(Graph graph, int src, int dest) {
        // Add an edge from src to dest
        graph.adjList[src].add(dest);
    }

    /**
     * Add an edge between two vertices in undirected graph
     */
    public void addEdgeUndirected(Graph graph, int src, int dest) {
        // Add an edge from src to dest
        graph.adjList[src].add(dest);

        // Since graph is undirected, add an edge from dest to src
        graph.adjList[dest].add(src);
    }

    public void printGraph(Graph graph) {
        for (int i = 0; i < graph.size; i++) {
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head");
            for (Integer integer : graph.adjList[i]) {
                System.out.print(" -> " + integer);
            }
            System.out.println("\n");
        }
    }

}
