package org.milan.datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/topological-sorting/}
 *
 * @author Milan Rathod
 */
public class TopologicalSort {

    private Graph graph;

    public TopologicalSort(Graph graph) {
        this.graph = graph;
    }

    /**
     * topological sort of given direct acyclic graph
     * <p>
     * Time complexity: O(V+E)
     *
     * @return list of integers of topologically sorted vertices
     */
    public List<Integer> sort() {

        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[graph.getSize()];

        // Visit all nodes recursively and call visit function
        // to store topological order
        for (int i = 0; i < graph.getSize(); i++) {
            if (!visited[i]) {
                visit(i, visited, stack);
            }
        }

        List<Integer> outputList = new ArrayList<>();

        while (!stack.isEmpty()) {
            outputList.add(stack.pop());
        }

        return outputList;
    }

    /**
     * Utility function to visit all vertices in topological order
     *
     * @param v       vertex
     * @param visited array storing status of visited vertices
     * @param stack   used for storing vertices
     */
    private void visit(int v, boolean[] visited, Stack<Integer> stack) {

        // Mark the current node as visited
        visited[v] = true;

        // Get all adjacent vertices
        List<Integer> neighbours = graph.getAdjList()[v];

        // Visit all adjacent vertices if visited flag is false
        for (Integer i : neighbours) {
            if (!visited[i]) {
                visit(i, visited, stack);
            }
        }

        // Push current vertex to stack to store result
        stack.push(v);
    }
}
