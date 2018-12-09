package org.milan.hackerearth;

import java.util.Arrays;

/**
 * Given Array of size n and number k
 * find minimum operation required to make it k-prime array
 * if already have k prime return 0
 * otherwise return minimum operations.
 *
 * @author Milan Rathod
 */
class KthPrime {

    public int calculateMinimumOperations(int[] inputArray, int length, int k) {

        int primeCount = 0;

        for (int i = 0; i < length; i++) {
            if (isPrime(inputArray[i])) {
                primeCount++;
                inputArray[i] = Integer.MAX_VALUE;
            }
        }

        if (primeCount >= k) return 0;

        Arrays.sort(inputArray);

        int minimumOperations = 0;

        for (int i = 0; i < length; i++) {
            if (inputArray[i] != Integer.MAX_VALUE) {
                int count = increaseNumber(inputArray[i]);
                minimumOperations += count;
                primeCount++;
            }

            if (primeCount >= k) {
                return minimumOperations;
            }
        }
        return minimumOperations;

    }

    private static int increaseNumber(int element) {

        int count = 0;

        while (!isPrime(element)) {
            element++;
            count++;
        }

        return count;

    }

    private static boolean isPrime(int n) {

        if (n == 1) {
            return false;
        }

        for (int i = 2; 2 * i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}
