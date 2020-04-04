package org.milan.misc;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/maximum-path-sum-matrix/}
 *
 * @author Milan Rathod
 */
public class MaximumPathSumMatrix {

    /**
     * Find maximum sum in given matrix by selected one element from each row
     * such that we are allowed to move down or diagonally left or diagonally right
     * <p>
     * Time complexity: O(n)
     *
     * @param input given matrix
     * @return max sum possible
     */
    public int getMax(int[][] input) {

        int rowLength = input.length;

        int columnLength = input[0].length;


        // First find largest element in first row
        int outputSum = 0;

        for (int i = 0; i < columnLength; i++) {
            outputSum = Math.max(input[0][i], outputSum);
        }

        for (int i = 1; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                // When all paths are possible
                if (j > 0 && j < columnLength - 1) {
                    input[i][j] += Math.max(input[i - 1][j], Math.max(input[i - 1][j - 1], input[i - 1][j + 1]));
                } else if (j > 0) {
                    // When diagonal right is not possible
                    input[i][j] += Math.max(input[i - 1][j - 1], input[i - 1][j]);
                } else if (j < columnLength - 1) {
                    // When diagonal left is not possible
                    input[i][j] += Math.max(input[i - 1][j], input[i - 1][j + 1]);
                }
                outputSum = Math.max(input[i][j], outputSum);
            }
        }
        return outputSum;
    }
}
