package org.milan.algorithm.backtracking;

/**
 * Problem: N Queen problem
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/}
 *
 * @author Milan Rathod
 */
public class NQueen {

    private static int N = 4;

    public static void main(String[] args) {
        new NQueen().solve();
    }

    private void solve() {
        int[][] board = new int[N][N];

        if (!explore(0, board)) {
            System.out.println("Solution does not exist!");
        } else {
            printSolution(board);
        }
    }

    private boolean explore(int column, int[][] board) {

        // Base condition: if all queens are placed
        if (column >= N) {
            return true;
        }

        // Consider this column and try placing this queen in all rows one by one
        for (int i = 0; i < N; i++) {

            // Check if it is safe to place queen on board[i][column]
            if (isValid(i, column, board)) {
                board[i][column] = 1;

                if (explore(column + 1, board)) {
                    return true;
                }

                // Backtrack - if placing an queen on board[i][column] does not lead to solution
                board[i][column] = 0;
            }
        }

        return false;
    }

    private boolean isValid(int row, int column, int[][] board) {

        // Check left side of row
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1)
                return false;
        }

        // Check for upper diagonal on left side
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check for lower diagonal on left side
        for (int i = row, j = column; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    private void printSolution(int[][] solution) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}
