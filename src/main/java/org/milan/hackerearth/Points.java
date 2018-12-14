package org.milan.hackerearth;

/**
 * {@link @https://www.hackerearth.com/problem/algorithm/points/description/}
 *
 * @author Milan Rathod
 */
public class Points {

    public long findWays(long[] inputArray, int n, long k) {

        int next = 2;
        long count = 0L;
        for (int i = 0; i < n; i++) {
            int l = next;
            while (l < n && inputArray[l] - inputArray[i] <= k) l++;
            long temp = l - i - 1;
            next = l;
            count = count + (temp - 1) * (temp) / 2;
        }
        return count;
    }
}
