package org.milan.algorithm.dynamic;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/}
 *
 * @author Milan Rathod
 */
public class MatrixChainMultiplication {

    /**
     * Time complexity: O(n*n*n)
     * Space complexity: O(n*n)
     *
     * @param p array of integers containing dimensions
     * @return minimum number of matrix multiplication
     */
    public int findMinimum(int[] p) {

        int n = p.length;

        // m[i,j] = Minimum number of scalar multiplications needed
        // to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        // dimension of A[i] is p[i-1] x p[i]
        int[][] m = new int[n][n];

        int i, j, k, q;

        // cost is zero when multiplying one matrix.
        for (i = 1; i < n; i++)
            m[i][i] = 0;


        for (int d = 2; d < n; d++) {
            for (i = 1; i < n - d + 1; i++) {
                j = i + d - 1;
                if (j == n) continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++) {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n - 1];
    }

}
