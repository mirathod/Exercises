package org.milan.hackerearth;

/**
 * {@link @https://www.hackerearth.com/problem/algorithm/mystery/}
 *
 * @author Milan Rathod
 */
public class Mystery {

    public int solve(int a, int b, int c) {
        if (c == 0) return a;

        if (c == 1) return b;

        int sum = 0;

        for (int i = 0; i < c - 1; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
