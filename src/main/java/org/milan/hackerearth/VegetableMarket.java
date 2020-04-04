package org.milan.hackerearth;

import java.util.Arrays;
import java.util.List;

/**
 * Vegetable Market Problem
 * <p>
 * Problem: {@link @https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/vegetable-market-ea2b4462/}
 *
 * @author Milan Rathod
 */
public class VegetableMarket {

    public int minimumToBuy(List<Integer> stalls, int query) {
        return calculateMinimumQuantity(stalls.stream().mapToInt(i -> i).toArray(), query);

    }

    /**
     * Calculate Minimum Quantity required to fulfil requirement of vegetable distribution
     */
    private int calculateMinimumQuantity(int[] arr, int total) {

        // Check if requirement can be fulfilled
        if (totalQuantitiesOfAllStalls(arr) < total) {
            return -1;
        }

        // Start the iteration
        int minimum = total / arr.length;

        int tempTotal = 0;

        while (true) {
            for (int element : arr) {
                if (element >= minimum) {
                    tempTotal += minimum;
                } else {
                    tempTotal += element;
                }
            }

            if (tempTotal >= total) {
                return minimum;
            }

            tempTotal = 0;

            minimum++;

        }
    }

    /**
     * Calculate Sum of All quantities available in all stalls
     */
    private int totalQuantitiesOfAllStalls(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
