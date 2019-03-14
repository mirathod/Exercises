package org.milan.datastructure.sorting;

/**
 * Problem: Tim Sort
 * <p>
 * Used in {@link java.util.Arrays#sort(int[])}
 *
 * @author Milan Rathod
 */
public class TimSort {

    private static final int RUN = 32;

    public void sort(int[] arr) {

        // Sort individual sub arrays of size RUN with insertion sort
        for (int i = 0; i < arr.length; i += RUN) {
            new InsertionSort().sort(arr, i, Math.min((i + 31), (arr.length - 1)));
        }

        // Merge all sorted sub arrays with merge operation of merge sort
        for (int size = RUN; size < arr.length; size = 2 * size) {
            for (int left = 0; left < arr.length; left += 2 * size) {

                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), arr.length - 1);

                new MergeSort().merge(arr, left, mid, right);
            }
        }
    }
}
