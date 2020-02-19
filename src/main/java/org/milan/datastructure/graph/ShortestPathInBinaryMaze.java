package org.milan.datastructure.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/}
 *
 * @author Milan Rathod
 */
public class ShortestPathInBinaryMaze {

    private int row;

    private int column;

    private int[] rows = {-1, 0, 0, 1};

    private int[] columns = {0, -1, 1, 0};

    public int find(int[][] maze, Point src, Point dest) {

        // Base condition
        if (maze[src.x][src.y] == 0) {
            return -1;
        }

        row = maze.length;

        column = maze[0].length;

        boolean[][] visited = new boolean[row][column];

        visited[src.x][src.y] = true;

        QueueNode first = new QueueNode(src, 0);

        Queue<QueueNode> queue = new ArrayDeque<>();

        queue.add(first);

        while (!queue.isEmpty()) {
            QueueNode current = queue.poll();

            Point point = current.point;

            if (point.x == dest.x && point.y == dest.y) {
                return current.distance;
            }

            for (int i = 0; i < 4; i++) {

                int row = point.x + rows[i];

                int column = point.y + columns[i];

                if (isValid(row, column) && maze[row][column] == 1 && !visited[row][column]) {
                    visited[row][column] = true;
                    QueueNode node = new QueueNode(new Point(row, column), current.distance + 1);
                    queue.add(node);
                }
            }

        }

        return -1;
    }

    private boolean isValid(int row, int column) {
        return (row >= 0 && row < this.row) && (column >= 0 && column < this.column);
    }
}

class QueueNode {
    Point point;

    int distance;

    QueueNode(Point point, int distance) {
        this.point = point;
        this.distance = distance;
    }
}

class Point {
    int x;

    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
