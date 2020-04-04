package org.milan.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/snake-ladder-problem-2/}
 *
 * @author Milan Rathod
 */
public class SnakeLadderProblem {

    /**
     * @param moves moves[i] is -1 if not snake/ladder
     *              from cell i otherwise cell to which snake/ladder
     *              at i takes to
     * @param n     total number of cells in board
     * @return minimum of dice throws required to reach to destination
     */
    public int getMinDiceThrows(int[] moves, int n) {

        // Visited boolean array
        boolean[] visited = new boolean[n];


        Queue<Entry> queue = new LinkedList<>();

        Entry entry = new Entry();
        entry.vertex = 0;
        entry.distance = 0;

        // Mark the node 0 as visited and enqueue it.
        visited[0] = true;
        queue.add(entry);

        // Do a BFS starting from vertex at index 0
        while (!queue.isEmpty()) {
            entry = queue.remove();
            int vertex = entry.vertex;

            // If front vertex is the destination vertex we are done
            if (vertex == n - 1)
                break;

            // Otherwise dequeue the front vertex and
            // enqueue its adjacent vertices (or cell
            // numbers reachable through a dice throw)
            for (int j = vertex + 1; j <= (vertex + 6) && j < n; ++j) {
                // If this cell is already visited, then ignore
                if (!visited[j]) {
                    // Otherwise calculate its distance and
                    // mark it as visited
                    Entry newEntry = new Entry();
                    newEntry.distance = (entry.distance + 1);
                    visited[j] = true;

                    // Check if there a snake or ladder at 'j'
                    // then tail of snake or top of ladder
                    // become the adjacent of 'i'
                    if (moves[j] != -1)
                        newEntry.vertex = moves[j];
                    else
                        newEntry.vertex = j;
                    queue.add(newEntry);
                }
            }
        }

        return entry.distance;
    }

    private static final class Entry {
        int vertex;

        int distance;
    }

}
