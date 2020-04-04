package org.milan.misc;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/maximum-sum-elements-row-matrix/}
 *
 * @author Milan Rathod
 */
public class MatrixSumFromEachRow {

    /**
     * Find maximum sum by selected one element in each row such that element
     * selected at nth row must be greater than element selected at (n-1)th row
     *
     * @return sum with above criteria otherwise -1
     */
    public int maxSum(int[][] input) {

        int rowLength = input.length;

        int columnLength = input[0].length;


        // First find largest element in last row
        int prevMax = 0;

        for (int i = 0; i < columnLength; i++) {
            if (input[rowLength - 1][i] > prevMax) {
                prevMax = input[rowLength - 1][i];
            }
        }

        int sum = prevMax;

        for (int i = rowLength - 2; i >= 0; i--) {
            int currMax = Integer.MIN_VALUE;

            for (int j = 0; j < columnLength; j++) {
                if (prevMax > input[i][j] && input[i][j] > currMax) {
                    currMax = input[i][j];
                }
            }

            if (currMax == Integer.MIN_VALUE) {
                return -1;
            }

            prevMax = currMax;
            sum += prevMax;
        }

        return sum;
    }
}
