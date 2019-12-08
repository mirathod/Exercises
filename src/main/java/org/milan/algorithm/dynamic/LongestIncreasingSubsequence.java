package org.milan.algorithm.dynamic;

import java.util.Arrays;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/}
 *
 * @author Milan Rathod
 */
public class LongestIncreasingSubsequence {

    private int[] subsequence;

    /**
     * Find longest increasing subsequence using dynamic programming
     * <p>
     * Time complexity: O(n*n)
     *
     * @param arr input array
     * @return length of longest increasing subsequence
     */
    public int find(int[] arr) {

        int n = arr.length;

        int[] lis = new int[n];

        int i, j;

        // Initialize lis values for all indexes
        for (i = 0; i < n; i++) {
            lis[i] = 1;
        }

        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        return Arrays.stream(lis).max().getAsInt();
    }

    /**
     * Find longest increasing subsequence
     * <p>
     * Time complexity: O(nlogn)
     *
     * @param arr input array
     * @return length of longest increasing subsequence
     */
    public int findV2(int[] arr) {
        int n = arr.length;
        int[] tailIndices = new int[n];

        int[] prevIndices = new int[n];

        Arrays.fill(prevIndices, -1);

        // Always points to empty slot
        int index = 1;

        for (int i = 1; i < n; i++) {

            // If arr[i] is smallest among all
            if (arr[i] < arr[tailIndices[0]]) {
                // New smallest element
                tailIndices[0] = i;
            } else if (arr[i] > arr[tailIndices[index - 1]]) {
                // arr[i] wants to extend largest subsequence
                prevIndices[i] = tailIndices[index - 1];
                tailIndices[index++] = i;
            } else {
                // arr[i] wants to be current end element of an existing subsequence.
                // It will replace ceil value in tailIndices
                int pos = ceilIndex(arr, tailIndices, -1, index - 1, arr[i]);
                prevIndices[i] = tailIndices[pos - 1];
                tailIndices[pos] = i;
            }
        }

        int[] output = new int[index];

        // Compute longest increasing subsequence
        for (int i = tailIndices[index - 1]; i >= 0; i = prevIndices[i]) {
            output[--index] = arr[i];
        }
        setSubsequence(output);

        return output.length;
    }

    /**
     * Set longest increasing subsequence
     *
     * @param subsequence longest increasing subsequence
     */
    private void setSubsequence(int[] subsequence) {
        this.subsequence = subsequence;
    }

    /**
     * Get longest increasing subsequence for given array
     *
     * @return longest increasing subsequence
     */
    public int[] getSubsequence() {
        return subsequence;
    }

    /**
     * Using binary search to find ceil index in given array for a key
     */
    private int ceilIndex(int[] arr, int[] tailIndices, int left, int right, int key) {
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (arr[tailIndices[mid]] >= key) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
