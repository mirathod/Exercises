package org.milan.datastructure.graph;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/}
 *
 * @author Milan Rathod
 */
public class UnionByRank {

    public boolean isCycleExists(Graph graph) {
        Subset[] subsets = new Subset[graph.getSize()];

        for (int i = 0, size = graph.getSize(); i < size; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        // Iterate through all edges of graph, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in graph.
        for (int i = 0; i < graph.getAdjList().length; i++) {
            Integer src = graph.getAdjList()[i].get(0);
            Integer dest = graph.getAdjList()[i].get(1);

            int x = find(subsets, src);
            int y = find(subsets, dest);

            if (x == y)
                return true;

            union(subsets, x, y);
        }
        return false;
    }

    /**
     * Find subset in which given element belongs to
     * It might take O(logn) time to find
     */
    public int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            return find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    /**
     * Do union of two elements by rank and placed both into same subsets
     * It might take O(logn) time to perform
     */
    public void union(Subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else {
            subsets[xRoot].parent = yRoot;
            subsets[yRoot].rank++;
        }

    }

}

class Subset {
    int parent;

    int rank;

    public Subset() {
    }

    public Subset(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
}
