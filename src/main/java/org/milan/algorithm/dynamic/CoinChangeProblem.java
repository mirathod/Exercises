package org.milan.algorithm.dynamic;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/coin-change-dp-7/}
 *
 * @author Milan Rathod
 */
public class CoinChangeProblem {

    /**
     * Recursive approach
     *
     * @param coins valued coins
     * @param m     total coins
     * @param n     N cents
     */
    public int count(int[] coins, int m, int n) {

        // If n is 0 then there is 1 solution
        // Do not include this coin
        if (n == 0) {
            return 1;
        }

        // If n is less than 0 or there are no coins then no solution exists
        if (n <= 0 || m <= 0) {
            return 0;
        }

        return count(coins, m - 1, n) + count(coins, m, n - coins[m - 1]);
    }

    /**
     * Dynamic programming
     *
     * @param coins valued coins
     * @param m     total coins
     * @param n     N cents
     */
    public int countV2(int[] coins, int m, int n) {

        int[] combinations = new int[n + 1];

        combinations[0] = 1;

        for (int coin : coins) {
            for (int i = 1; i < combinations.length; i++) {
                if (i >= coin) {
                    combinations[i] += combinations[i - coin];
                }
            }
        }

        return combinations[n];
    }

}
