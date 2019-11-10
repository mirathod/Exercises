package org.milan.datastructure.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: Depth First Search
 * <p>
 * Time Complexity: O(V+E) where V is number of vertices in graph and E is number of edges in graph
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/}
 *
 * @author Milan Rathod
 */
public class DepthFirstSearch {

    private Graph graph;

    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    /**
     * Perform depth first search starting from given vertex
     *
     * @param v starting vertex
     */
    public void dfs(int v) {
        boolean[] visited = new boolean[graph.getSize()];
        visit(v, visited);
    }

    /**
     * Recursive helper function perform depth first search
     *
     * @param v       starting/current vertex
     * @param visited boolean array indicates whether vertices are visited or not
     */
    public void visit(int v, boolean[] visited) {

        // Print the current vertex
        System.out.println(v);

        // Update the visited array
        visited[v] = true;

        // Get all adjacent vertices
        List<Integer> neighbours = graph.getAdjList()[v];

        // Visit all adjacent vertices if visited flag is false
        for (Integer i : neighbours) {
            if (!visited[i]) {
                visit(i, visited);
            }
        }
    }

    /**
     * Perform depth first search starting from given vertex
     *
     * @param v starting vertex
     */
    public void dfsIterative(int v) {
        boolean[] visited = new boolean[graph.getSize()];

        Stack<Integer> stack = new Stack<>();

        stack.push(v);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited[current]) {
                visited[current] = true;
                System.out.println(current);
            }

            LinkedList<Integer> neighbours = graph.getAdjList()[current];

            neighbours.forEach(integer -> {
                if (!visited[integer]) {
                    stack.push(integer);
                }
            });
        }

    }

}