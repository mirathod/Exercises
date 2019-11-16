package org.milan.algorithm.sorting;

/**
 * Problem: Merge Sort
 * <p>
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 * Stable algorithm
 * Divide and Conquer paradigm
 * <p>
 * For Linked list used this over {@link QuickSort}
 *
 * @author Milan Rathod
 */
public class MergeSort {

    /**
     * Recursive approach
     */
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Iterative Approach
     */
    public void sortIterative(int[] arr) {
        int length = arr.length;

        // For current size of sub arrays to be merged it varies from 1 to length/2
        int currentSize;

        // Merge sub arrays in bottom up manner.
        // First merge sub arrays of size 1 to create sorted sub arrays of size 2
        // Then sub arrays of size 2 to create sorted sub arrays of size 4
        for (currentSize = 1; currentSize <= length - 1; currentSize = currentSize * 2) {

            // Pick starting point of different sub arrays of current size
            for (int leftStart = 0; leftStart < length - 1; leftStart += 2 * currentSize) {
                int mid = Math.min(leftStart + currentSize - 1, length - 1);
                int rightEnd = Math.min(leftStart + 2 * currentSize - 1, length - 1);

                // Merge sub arrays arr[leftStart...mid] and arr[mid+1...rightEnd]
                merge(arr, leftStart, mid, rightEnd);
            }
        }
    }

    /**
     * Merge two sorted sub-arrays
     */
    public void merge(int[] arr, int low, int middle, int high) {

        // Find sizes of both sub-arrays
        int leftArrayLength = middle - low + 1;
        int rightArrayLength = high - middle;

        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];

        // Copy left array contents
        for (int i = 0; i < leftArrayLength; i++) {
            leftArray[i] = arr[low + i];
        }

        // Copy right array contents
        for (int i = 0; i < rightArrayLength; i++) {
            rightArray[i] = arr[middle + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while (i < leftArrayLength && j < rightArrayLength) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining contents of left sub-array
        while (i < leftArrayLength) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining contents of right sub-array
        while (j < rightArrayLength) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private void mergeSort(int[] arr, int low, int high) {

        if (low < high) {
            int middle = (low + high) / 2;

            mergeSort(arr, low, middle);

            mergeSort(arr, middle + 1, high);

            merge(arr, low, middle, high);
        }
    }
}
