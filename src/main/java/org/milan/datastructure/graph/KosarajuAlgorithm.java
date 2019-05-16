package org.milan.datastructure.graph;

import java.util.List;
import java.util.Stack;

/**
 * Problem: Kosaraju's Algorithm
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/strongly-connected-components/}
 *
 * @author Milan Rathod
 */
public class KosarajuAlgorithm {

    private Graph graph;

    private DepthFirstSearch depthFirstSearch;

    public KosarajuAlgorithm(Graph graph) {
        this.graph = graph;
    }

    /**
     * Get Transport graph of a graph
     */
    private Graph getTranspose() {
        Graph newGraph = new Graph(graph.getSize());
        for (int i = 0; i < graph.getSize(); i++) {
            List<Integer> neighbours = graph.getAdjList()[i];
            for (Integer integer : neighbours) {
                newGraph.getAdjList()[integer].add(i);
            }
        }
        return newGraph;
    }

    /**
     * Print Strongly Connected Components
     */
    public void printSCCs() {
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[graph.getSize()];

        for (int i = 0; i < graph.getSize(); i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }

        Graph newGraph = getTranspose();

        // Mark all vertices as not visited for 2nd DFS
        for (int i = 0; i < graph.getSize(); i++) {
            visited[i] = false;
        }

        depthFirstSearch = new DepthFirstSearch(newGraph);

        while (!stack.isEmpty()) {
            int v = stack.pop();

            if (!visited[v]) {
                depthFirstSearch.visit(v, visited);
            }
        }

    }

    private void fillOrder(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;

        List<Integer> neighbours = graph.getAdjList()[vertex];
        for (Integer i : neighbours) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }

        // All vertices reachable from v are processed by now
        // Push v to stack
        stack.push(vertex);
    }
}
