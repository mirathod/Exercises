package org.milan.hackerearth;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Vegetable Market Problem
 *
 * @author Milan Rathod
 */
public class VegetableMarket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStalls = scanner.nextInt();

        int[] stallQuantities = new int[numberOfStalls];

        for (int i = 0; i < numberOfStalls; i++) {
            stallQuantities[i] = scanner.nextInt();
        }

        int numberOfQueries = scanner.nextInt();

        VegetableMarket vegetableMarket = new VegetableMarket();

        while (numberOfQueries > 0) {
            int minimumQuantity = vegetableMarket.calculateMinimumQuantity(stallQuantities, scanner.nextInt());
            System.out.println(minimumQuantity);
            numberOfQueries--;
        }
    }

    /**
     * Calculate Minimum Quantity required to fulfil requirement of vegetable distribution
     */
    private int calculateMinimumQuantity(int[] arr, int total) {

        // Check if requirement can be fulfilled
        if (totalQunatitiesOfAllStalls(arr) < total) {
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
    private int totalQunatitiesOfAllStalls(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
