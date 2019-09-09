package org.milan.datastructure.misc;

/**
 * Problem: Josephus problem
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/}
 *
 * @author Milan Rathod
 */
public class Josephus {

    public int luckyPerson(int n, int k) {
        if (n == 1) {
            return 1;
        } else {
            return (luckyPerson(n - 1, k) + k - 1) % n + 1;
        }
    }
}
