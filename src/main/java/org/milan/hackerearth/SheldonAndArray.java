package org.milan.hackerearth;

/**
 * Problem: {@link @https://www.hackerearth.com/problem/algorithm/sheldon-and-array/}
 *
 * @author Milan Rathod
 */
public class SheldonAndArray {

    /**
     * Time complexity: O(n*n)
     *
     * @param arr given input array
     * @return array of integers consisting of nearest max gcd
     */
    public int[] findNearestMaxGCD(int[] arr) {

        int[] output = new int[arr.length];

        // First element is left extreme thus put it -1 as output
        output[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            int index = i, maxGCD = 1;
            for (int j = i - 1; j >= 0; j--) {

                int gcd = gcd(arr[i], arr[j]);

                if (gcd > maxGCD) {
                    index = j + 1;
                    maxGCD = gcd;
                }

            }
            output[i] = index;
        }
        return output;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
