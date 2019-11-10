package org.milan.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: Breadth First Search
 * <p>
 * Time Complexity: O(V+E) where V is number of vertices in graph and E is number of edges in graph
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/}
 *
 * @author Milan Rathod
 */
public class BreadthFirstSearch {

    private Graph graph;

    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    /**
     * Breadth first search of graph
     *
     * @param vertex starting vertex
     */
    public void bfs(int vertex) {

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[graph.getSize()];

        // Create queue for bfs
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {

            // Dequeue a vertex from queue and print it
            vertex = queue.remove();
            System.out.println(vertex);

            for (int n : graph.getAdjList()[vertex]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

}
