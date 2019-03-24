package org.milan.datastructure.graph;

import java.util.List;

/**
 * Problem: Depth First Search
 * <p>
 * Time Complexity: O(V+E) where V is number of vertices in graph and E is number of edges in graph
 *
 * @author Milan Rathod
 */
public class DepthFirstSearch {

    private Graph graph;

    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    public void dfs(int v) {
        boolean[] visited = new boolean[graph.getSize()];
        visit(v, visited);
    }

    public void visit(int v, boolean[] visited) {
        System.out.println(v);
        visited[v] = true;
        List<Integer> neighbours = graph.getAdjList()[v];
        for (Integer i : neighbours) {
            if (!visited[i]) {
                visit(i, visited);
            }
        }
    }

}