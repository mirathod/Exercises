package org.milan.datastructure.graph;

import java.util.TreeSet;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/}
 * <p>
 * Time complexity: O(ElogV)
 *
 * @author Milan Rathod
 */
public class PrimMST {

    public void find(WeightedGraph graph) {

        int size = graph.getSize();

        // Whether a vertex is in priority queue or not
        boolean[] masterSet = new boolean[size];
        QueueNode[] nodes = new QueueNode[size];

        int[] parent = new int[size];

        for (int i = 0; i < size; i++) {
            nodes[i] = new QueueNode();
        }

        TreeSet<QueueNode> queue = new TreeSet<>((o1, o2) ->
                o1.key - o2.key != 0 ? o1.key - o2.key : o1.vertex - o2.vertex);

        for (int i = 0; i < size; i++) {
            // Initialize key values to infinity
            nodes[i].key = Integer.MAX_VALUE;
            nodes[i].vertex = i;
            parent[i] = -1;
        }

        // Include the source vertex in master set
        masterSet[0] = true;

        // Set key value to 0
        // So that it is extracted first from priority queue
        nodes[0].key = 0;

        for (int i = 0; i < size; i++) {
            queue.add(nodes[i]);
        }

        while (!queue.isEmpty()) {

            QueueNode queueNode = queue.pollFirst();

            // Include that node into master set
            masterSet[queueNode.vertex] = true;

            // Iterate over all adjacent vertices of extracted vertex V
            for (Node node : graph.getAdjList()[queueNode.vertex]) {

                // If V is in queue and key value of adjacent vertex is more than
                // the extracted key
                if (!masterSet[node.dest] && nodes[node.dest].key > node.weight) {
                    queue.remove(nodes[node.dest]);
                    nodes[node.dest].key = node.weight;
                    queue.add(nodes[node.dest]);
                    parent[node.dest] = queueNode.vertex;
                }
            }
        }

        for (int i = 1; i < size; i++) {
            System.out.println(parent[i] + " - " + i);
        }

    }

    /**
     * Class to represent node in priority queue
     */
    static class QueueNode {
        int vertex;

        int key;
    }

}

