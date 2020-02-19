package org.milan.datastructure.graph;

import java.util.Arrays;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/union-find/}
 *
 * @author Milan Rathod
 */
public class DisjointSet {

    public boolean isCycleExists(Graph graph) {

        int[] parent = new int[graph.getSize()];

        // Initialized all subsets as single element sets
        Arrays.fill(parent, -1);

        // Iterate through all edges of graph, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in graph.
        for (int i = 0; i < graph.getAdjList().length; i++) {
            Integer src = graph.getAdjList()[i].get(0);
            Integer dest = graph.getAdjList()[i].get(1);

            int x = find(parent, src);
            int y = find(parent, dest);

            if (x == y)
                return true;

            union(parent, x, y);
        }
        return false;
    }

    /**
     * Find subset in which given element belongs to
     * It might take O(n) time to find
     */
    private int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;

        return find(parent, parent[i]);
    }

    /**
     * Do union of two elements and placed both into same subsets
     * It might take O(n) time to perform
     */
    private void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);

        parent[xSet] = ySet;
    }

}
