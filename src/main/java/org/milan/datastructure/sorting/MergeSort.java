package org.milan.datastructure.sorting;

/**
 * Problem: Merge Sort
 *
 * @author Milan Rathod
 */
public class MergeSort {

    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Recursive Approach
     */
    private void mergeSort(int[] arr, int low, int high) {

        if (low < high) {
            int middle = (low + high) / 2;

            mergeSort(arr, low, middle);

            mergeSort(arr, middle + 1, high);

            merge(arr, low, middle, high);

        }
    }

    /**
     * Iterative Approach
     */
    public void itertiveSort(int[] arr, int length) {

        // For current size of sub arrays to be merged it varies from 1 to length/2
        int currentSize;

        for (currentSize = 1; currentSize <= length - 1; currentSize = currentSize * 2) {
            for (int leftStart = 0; leftStart < length - 1; leftStart += 2 * currentSize) {
                int mid = leftStart + currentSize - 1;
                int rightEnd = Math.min(leftStart + 2 * currentSize - 1, length - 1);

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
            rightArray[i] = arr[middle + 1 + i];
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
}
