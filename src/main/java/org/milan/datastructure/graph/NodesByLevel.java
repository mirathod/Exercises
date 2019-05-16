package org.milan.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Problem: Count number of nodes at given level
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/count-number-nodes-given-level-using-bfs/}
 *
 * @author Milan Rathod
 */
public class NodesByLevel {

    private Graph graph;

    private int[] levels;

    public NodesByLevel(Graph graph) {
        this.graph = graph;
        this.levels = new int[graph.getSize()];
    }

    public long totalNodesByLevel(int level) {
        calculateLevels();

        return IntStream.of(levels).filter(value -> value == level).count();
    }

    /**
     * Calculate levels for each nodes/vertices
     */
    private void calculateLevels() {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[graph.getSize()];

        // Create queue for bfs
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[0] = true;
        queue.add(0);

        // Level of 0 vertex is 0
        levels[0] = 0;

        while (!queue.isEmpty()) {

            // Dequeue a vertex from queue and print it
            int vertex = queue.remove();

            for (int n : graph.getAdjList()[vertex]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                    levels[n] = levels[vertex] + 1;
                }
            }
        }
    }


}