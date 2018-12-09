package org.milan.hackerearth;

import java.util.ArrayList;
import java.util.List;

/**
 * given array a of size n with i, j & k such that
 * a[k] is > a[i]  & < a[j] or
 * a[k] is < a[i]  & > a[j]
 *
 * @author Milan Rathod
 */
public class SmallLargeCombination {

    public long computeSmallLargeCount(long[] arr) {

        int count = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            int leftMax = findMax(arr, i, true);
            int rightMax = findMax(arr, i, false);
            int leftMin = findMin(arr, i, true);
            int rightMin = findMin(arr, i, false);

            count += leftMax * rightMin + leftMin * rightMax;

        }

        return count;

    }

    private static int findMax(long[] arr, int index, boolean isLeft) {
        List<Long> output = new ArrayList<>();
        if (isLeft) {
            for (int i = 0; i < index; i++) {
                if (arr[i] > arr[index]) {
                    output.add(arr[i]);
                }
            }
        } else {
            for (int i = index + 1; i < arr.length; i++) {
                if (arr[i] > arr[index]) {
                    output.add(arr[i]);
                }
            }

        }
        return output.size();
    }

    private static int findMin(long[] arr, int index, boolean isLeft) {
        List<Long> output = new ArrayList<>();
        if (isLeft) {
            for (int i = 0; i < index; i++) {
                if (arr[i] < arr[index]) {
                    output.add(arr[i]);
                }
            }
        } else {
            for (int i = index + 1; i < arr.length; i++) {
                if (arr[i] < arr[index]) {
                    output.add(arr[i]);
                }
            }

        }
        return output.size();
    }
}
