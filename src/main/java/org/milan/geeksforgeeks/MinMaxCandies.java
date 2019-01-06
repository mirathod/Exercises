package org.milan.geeksforgeeks;

import java.util.Arrays;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/find-minimum-maximum-amount-buy-n-candies/}
 *
 * @author Milan Rathod
 */
public class MinMaxCandies {

    public int getMinAmount(int[] inputArray, int k) {
        Arrays.sort(inputArray);

        int initial = 0;

        int last = inputArray.length;

        int minimumAmount = 0;
        while (initial < last) {
            minimumAmount += inputArray[initial++];
            last -= k;
        }

        return minimumAmount;
    }

    public int getMaxAmount(int[] inputArray, int k) {
        Arrays.sort(inputArray);

        int initial = 0;

        int last = inputArray.length - 1;

        int maximumAmount = 0;

        while (initial < last) {
            maximumAmount += inputArray[last--];
            initial += k - 1;
        }

        return maximumAmount;
    }
}
