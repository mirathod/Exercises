package org.milan.datastructure.heap;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/merge-two-binary-max-heaps/}
 *
 * @author Milan Rathod
 */
public class MergeTwoMaxHeaps {

    private BinaryHeap binaryHeap;

    public MergeTwoMaxHeaps(BinaryHeap binaryHeap) {
        this.binaryHeap = binaryHeap;
    }

    /**
     * Merge two max heaps by first merging both the array representation of max heaps
     * and then calling buildHeap to build heap from merged array
     *
     * @param a array representation of first max heap
     * @param b array representation of second max heap
     * @param m size of first max heap
     * @param n size of second max heap
     * @return merged max heap
     */
    public int[] merge(int[] a, int[] b, int m, int n) {
        int[] mergedArray = new int[m + n];

        // Copy first array
        for (int i = 0; i < m; i++) {
            mergedArray[i] = a[i];
        }

        // Copy second array
        for (int j = 0; j < n; j++) {
            mergedArray[m + j] = b[j];
        }

        // Call buildHeap to build heap from array
        binaryHeap.buildHeap(mergedArray);

        return binaryHeap.getStore();
    }
}
