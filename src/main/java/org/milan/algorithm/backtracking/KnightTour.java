package org.milan.algorithm.backtracking;

import java.util.Arrays;

/**
 * Problem: The knight's tour problem
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/}
 *
 * @author Milan Rathod
 */
public class KnightTour {

    private static final int N = 8;

    public static void main(String[] args) {
        new KnightTour().solve();
    }

    private void solve() {
        int[][] solution = new int[N][N];

        // Initialization of solution matrix
        for (int[] row : solution) {
            Arrays.fill(row, -1);
        }

        // xMove and yMove defined next move of knight
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        // Knight will initially starts from 0
        solution[0][0] = 0;

        if (!explore(0, 0, 1, solution, xMove, yMove)) {
            System.out.println("Solution does not exist!");
        } else {
            printSolution(solution);
        }
    }

    /**
     * A recursive method to solve knight tour problem
     */
    private boolean explore(int x, int y, int move, int[][] solution, int[] xMove, int[] yMove) {
        int k, nextX, nextY;
        if (move == N * N) {
            return true;
        }

        for (k = 0; k < N; k++) {
            nextX = x + xMove[k];
            nextY = y + yMove[k];
            if (isValid(nextX, nextY, solution)) {
                solution[nextX][nextY] = move;
                if (explore(nextX, nextY, move + 1, solution, xMove, yMove)) {
                    return true;
                } else {
                    // Backtracking
                    solution[nextX][nextY] = -1;
                }
            }
        }

        return false;
    }

    /**
     * x and y are valid indexes for next move in chessboard
     */
    private boolean isValid(int x, int y, int[][] solution) {
        return (x >= 0 && x < N && y >= 0 && y < N && solution[x][y] == -1);
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
