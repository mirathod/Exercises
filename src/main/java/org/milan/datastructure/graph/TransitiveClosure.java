package org.milan.datastructure.graph;

import java.util.List;

/**
 * Problem: Transitive Closure of a graph using DFS
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/transitive-closure-of-a-graph-using-dfs/}
 *
 * @author Milan Rathod
 */
public class TransitiveClosure {

    private Graph graph;

    private int[][] transitiveClosureMatrix;

    public TransitiveClosure(Graph graph) {
        this.graph = graph;
        transitiveClosureMatrix = new int[graph.getSize()][graph.getSize()];
    }

    public int[][] transitiveClosure() {

        for (int i = 0; i < graph.getSize(); i++) {
            dfsUtil(i, i);
        }

        return transitiveClosureMatrix;
    }

    /**
     * Recursive DFS traversal method that finds all reachable vertices from source
     */
    private void dfsUtil(int src, int dst) {

        // Mark reachability from src to dst as true
        transitiveClosureMatrix[src][dst] = 1;

        List<Integer> neighbours = graph.getAdjList()[dst];

        for (int vertex : neighbours) {
            if (transitiveClosureMatrix[src][vertex] == 0) {
                dfsUtil(src, vertex);
            }
        }
    }
}
