package org.milan.datastructure.graph;

/**
 * @author Milan Rathod
 */
class GraphCycle {

    private Graph graph;

    public GraphCycle(Graph graph) {
        this.graph = graph;
    }

    /**
     * Check if cycle exists in graph
     */
    public boolean isCycleExists() {

        // Visited boolean array
        boolean[] visited = new boolean[graph.getSize()];

        // Recursive stack boolean array indicates if current vertex is in rec stack or not
        boolean[] recStack = new boolean[graph.getSize()];

        for (int i = 0; i < graph.getSize(); i++) {
            if (isCyclicUtil(visited, i, recStack)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Utility function to perform actual cyclic check operation
     */
    private boolean isCyclicUtil(boolean[] visited, int i, boolean[] recStack) {

        if (recStack[i]) {
            return true;
        }

        if (visited[i]) {
            return false;
        }

        visited[i] = true;
        recStack[i] = true;

        for (int k : graph.getAdjList()[i]) {
            if (isCyclicUtil(visited, k, recStack)) {
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }
}

