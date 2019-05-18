package org.milan.algorithm.sorting;

/**
 * Problem: Quick Sort
 *
 * @author Milan Rathod
 */
public class QuickSort {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public void iterativeSort(int[] arr, int low, int high) {
        int[] stack = new int[high - low + 1];

        // Initialize top of the stack
        int top = -1;

        stack[++top] = low;
        stack[++top] = high;

        while (top >= 0) {
            high = stack[top--];
            low = stack[top--];

            int partitionIndex = partition(arr, low, high);

            // Push elements which are left side of pivot if available
            if (partitionIndex - 1 > low) {
                stack[++top] = low;
                stack[++top] = partitionIndex - 1;
            }

            // Push elements which are right side of pivot if available
            if (partitionIndex + 1 < high) {
                stack[++top] = partitionIndex + 1;
                stack[++top] = high;
            }
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
