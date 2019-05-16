package org.milan.datastructure.graph;

/**
 * Problem: Find Mother Vertex in Graph
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/}
 *
 * @author Milan Rathod
 */
public class MotherVertex {

    private Graph graph;

    private DepthFirstSearch depthFirstSearch;

    public MotherVertex(Graph graph) {
        this.graph = graph;
        depthFirstSearch = new DepthFirstSearch(graph);
    }

    /**
     * Method to return mother vertex
     *
     * @return return mother vertex if exists otherwise returns -1
     */
    public int find() {
        boolean[] visited = new boolean[graph.getSize()];

        // Store last finished vertex
        int lastFinishedVertex = 0;

        // Do a DFS traversal and find the last finished vertex
        for (int i = 0; i < graph.getSize(); i++) {
            if (!visited[i]) {
                depthFirstSearch.visit(i, visited);
                lastFinishedVertex = i;
            }
        }

        for (int i = 0; i < graph.getSize(); i++) {
            visited[i] = false;
        }

        depthFirstSearch.visit(lastFinishedVertex, visited);

        for (int i = 0; i < graph.getSize(); i++) {
            if (!visited[i]) return -1;
        }
        return lastFinishedVertex;
    }
}
