package org.milan.hackerearth;

/**
 * Problem Statement {@link @https://www.hackerearth.com/problem/algorithm/chandu-and-primes-1/}
 *
 * @author Milan Rathod
 */
public class AlphaPrimes {

    private static int[] count;

    static {
        boolean[] ar = new boolean[1000001];
        for (int i = 2; i < ar.length; i++)
            ar[i] = true;

        for (int i = 2; i < ar.length; i++) {
            if (ar[i]) {
                for (int j = i << 1; j < ar.length; j += i)
                    ar[j] = false;
            }
        }

        for (int i = 2, j = 10; i < ar.length; i++) {
            if (i == j)
                j *= 10;

            if (ar[i]) {
                for (int k = j + i; k < ar.length; k += j)
                    ar[k] = true;
            }
        }

        count = new int[1000001];
        for (int i = 2; i < ar.length; i++) {
            if (ar[i])
                count[i] = count[i - 1] + 1;
            else
                count[i] = count[i - 1];
        }
    }

    public int getCount(int left, int right) {

        return count[right] - count[left - 1];

    }
}
