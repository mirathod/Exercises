package org.milan.algorithm.dynamic;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/}
 *
 * @author Milan Rathod
 */
public class MaximumSizeSquareSubMatrix {

    /**
     * Time complexity: O(m*n)
     * Space complexity: O(m*n)
     * where m is number of rows and n is number of columns in the given matrix
     *
     * @param matrix given matrix of size m*n
     */
    public int findMaximum(int[][] matrix) {
        int i, j;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] S = new int[rows][columns];

        for (i = 1; i < rows; i++) {
            for (j = 1; j < columns; j++) {
                if (matrix[i][j] == 1)
                    S[i][j] = Math.min(S[i][j - 1],
                            Math.min(S[i - 1][j], S[i - 1][j - 1])) + 1;
                else
                    S[i][j] = 0;
            }
        }

        // Find the maximum entry, and indexes of maximum entry in S[][]
        int max_of_s = S[0][0];

        for (i = 0; i < rows; i++) {
            for (j = 0; j < columns; j++) {
                if (max_of_s < S[i][j]) {
                    max_of_s = S[i][j];
                }
            }
        }

        return max_of_s;
    }
}
