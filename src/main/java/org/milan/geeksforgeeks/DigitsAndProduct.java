package org.milan.geeksforgeeks;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/count-numbers-in-range-such-that-digits-in-it-and-its-product-with-q-are-unequal/}
 *
 * @author Milan Rathod
 */
public class DigitsAndProduct {

    public int count(int left, int right, int q) {

        int count = 0;

        for (int i = left; i <= right; i++) {
            if (checkIfUnEqual(i, q)) {
                count++;
            }
        }

        return count;
    }

    private boolean checkIfUnEqual(int n, int q) {

        // Convert integer to string
        String str = String.valueOf(n);

        int[] a = new int[10];

        // Insert elements from 1st number to hash
        for (int i = 0; i < str.length(); i++) {
            a[str.charAt(i) - '0']++;
        }

        // Convert product integer to string
        String product = String.valueOf(n * q);

        // Using hash check if any digit of product matches
        // with the digits of input
        for (int i = 0; i < product.length(); i++) {
            if (a[product.charAt(i) - '0'] == 1) {
                return false;
            }
        }
        return true;
    }
}
