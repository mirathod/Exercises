package org.milan.datastructure.graph;

import java.util.TreeSet;

/**
 * Dijkstra algorithm for finding single source shortest path
 *
 * @author Milan Rathod
 */
public class DijkstraAlgorithm {

    public void find(WeightedGraph graph, int src) {

        int size = graph.getSize();

        // Whether a vertex is in priority queue or not
        boolean[] masterSet = new boolean[size];
        QueueNode[] nodes = new QueueNode[size];

        int[] distances = new int[size];

        for (int i = 0; i < size; i++) {
            nodes[i] = new QueueNode();
        }

        TreeSet<QueueNode> queue = new TreeSet<>((o1, o2) ->
                o1.distance - o2.distance != 0 ? o1.distance - o2.distance : o1.vertex - o2.vertex);

        for (int i = 0; i < size; i++) {
            // Initialize key values to infinity
            nodes[i].distance = Integer.MAX_VALUE;
            nodes[i].vertex = i;
            distances[i] = Integer.MAX_VALUE;
        }

        // Include the source vertex in master set
        masterSet[src] = true;

        // Set key value to 0
        // So that it is extracted first from priority queue
        nodes[src].distance = 0;
        distances[src] = 0;

        int[] parents = new int[size];

        parents[src] = -1;

        queue.add(nodes[src]);

        while (!queue.isEmpty()) {

            QueueNode queueNode = queue.pollFirst();

            // Include that node into master set
            masterSet[queueNode.vertex] = true;

            // Iterate over all adjacent vertices of extracted vertex V
            for (Node node : graph.getAdjList()[queueNode.vertex]) {

                // If V is in queue and key value of adjacent vertex is more than
                // the extracted key
                if (!masterSet[node.dest] && distances[queueNode.vertex] != Integer.MAX_VALUE && distances[queueNode.vertex] + node.weight < distances[node.dest]) {
                    distances[node.dest] = distances[queueNode.vertex] + node.weight;

                    // TODO can we optimize this?
                    nodes[node.dest].distance = node.weight;
                    queue.add(nodes[node.dest]);

                    parents[node.dest] = queueNode.vertex;
                }
            }
        }
        printSolution(src, distances, parents);
    }

    private void printSolution(int src, int[] distances, int[] parents) {
        for (int i = 0; i < distances.length; i++) {
            if (src != i) {
                System.out.println("From Vertex:" + src + " To Vertex: " + i);
                System.out.println("Distance: " + distances[i]);
                printPath(i, parents);
                System.out.println();
                System.out.println("-----------------------------------");
            }

        }
    }

    private void printPath(int currentVertex, int[] parents) {
        if (currentVertex != -1) {
            printPath(parents[currentVertex], parents);
            System.out.print(currentVertex + " ");
        }
    }

    /**
     * Class to represent node in priorityQueue/minHeap
     */
    static class QueueNode {
        int vertex;

        int distance;
    }
}
