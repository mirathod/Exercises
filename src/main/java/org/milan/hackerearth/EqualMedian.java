package org.milan.hackerearth;

import java.util.Arrays;

/**
 * {@link @https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/equal-median-8aba723b/}
 *
 * @author Milan Rathod
 */
public class EqualMedian {

    public int findMinimumSwapOperations(int[] A, int[] B, int N) {

        // Sort Array A
        Arrays.sort(A);

        // Sort Array B
        Arrays.sort(B);

        // Combine Array of Sorted A & Sorted B
        int[] combine = new int[2 * N];

        for (int i = 0; i < N; i++) {
            combine[i] = A[i];
        }

        for (int i = 0; i < N; i++) {
            combine[N + i] = B[i];
        }

        Arrays.sort(combine);

        int middle1 = combine[N - 1];

        int middle2 = combine[N];

        if (middle1 != middle2) {
            return -1;
        } else {

            int smallerMedianA = 0;
            int medianA = 0;
            int greaterMedianA = 0;
            int smallerMedianB = 0;
            int greaterMedianB = 0;
            int medianB = 0;

            for (int i = 0; i < A.length; i++) {
                if (A[i] < middle1) {
                    smallerMedianA++;
                } else if (A[i] == middle1) {
                    medianA++;
                } else {
                    greaterMedianA++;
                }
            }
            for (int i = 0; i < B.length; i++) {
                if (B[i] < middle1) {
                    smallerMedianB++;
                } else if (B[i] == middle1) {
                    medianB++;
                } else {
                    greaterMedianB++;
                }
            }
            int total = 0;

            // If Array A doesn't have median element then B has to give it to A
            if (medianA == 0) {

                // increase total as swap is required
                total++;
                medianB--;
                medianA++;
                if (smallerMedianA > greaterMedianA) {
                    smallerMedianA--;
                    smallerMedianB++;
                } else {
                    greaterMedianA--;
                    greaterMedianB++;
                }

            }

            // If Array B doesn't have median element then A has to give it to B
            if (medianB == 0) {

                // increase total as swap is required
                total++;
                medianA--;
                medianB++;
                if (smallerMedianB > greaterMedianB) {
                    smallerMedianB--;
                    smallerMedianA++;
                } else {
                    greaterMedianB--;
                    greaterMedianA++;
                }
            }

            int sub = 0;
            if (medianA + Math.min(greaterMedianA, smallerMedianA) <= N / 2) {
                sub = N / 2 + 1 - medianA - Math.min(greaterMedianA, smallerMedianA);
            }
            if (medianB + Math.min(greaterMedianB, smallerMedianB) <= N / 2) {
                sub = Math.max(sub, N / 2 + 1 - medianB - Math.min(greaterMedianB, smallerMedianB));
            }

            return total + sub;

        }

    }
}
