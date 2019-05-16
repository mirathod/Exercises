package org.milan.datastructure.graph;

/**
 * Problem: Count number of trees in forest
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/count-number-trees-forest/}
 *
 * @author Milan Rathod
 */
public class TreesInForest {

    private Graph graph;

    private DepthFirstSearch depthFirstSearch;

    public TreesInForest(Graph graph) {
        this.graph = graph;
        depthFirstSearch = new DepthFirstSearch(graph);
    }

    public int totalTrees() {
        boolean[] visited = new boolean[graph.getSize()];

        int count = 0;

        for (int i = 0; i < graph.getSize(); i++) {
            if (!visited[i]) {
                depthFirstSearch.visit(i, visited);
                count++;
            }
        }
        return count;
    }
}
