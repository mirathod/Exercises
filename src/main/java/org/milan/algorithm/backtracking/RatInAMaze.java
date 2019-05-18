package org.milan.algorithm.backtracking;

/**
 * Problem: Rat in a maze
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/}
 *
 * @author Milan Rathod
 */
public class RatInAMaze {

    private static int N;

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        N = maze.length;
        new RatInAMaze().solve(maze);
    }

    private void solve(int[][] maze) {
        int[][] solution = new int[N][N];

        if (!explore(0, 0, maze, solution)) {
            System.out.println("Solution does not exist!");
        } else {
            printSolution(solution);
        }
    }

    private boolean explore(int x, int y, int[][] maze, int[][] solution) {

        if (x == N - 1 && y == N - 1) {
            solution[x][y] = 1;
            return true;
        }

        if (isValid(x, y, maze)) {
            solution[x][y] = 1;

            // Move forward in x direction
            if (explore(x + 1, y, maze, solution))
                return true;

            // If moving in x direction does not give solution move down in y direction
            if (explore(x, y + 1, maze, solution))
                return true;

            // Backtrack - if moving forward and down does not works
            solution[x][y] = 0;
            return false;
        }

        return false;
    }

    /**
     * x and y are valid indexes for next move in maze
     */
    private boolean isValid(int x, int y, int[][] maze) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    private void printSolution(int[][] solution) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

}
