package org.milan.algorithm.dynamic;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/}
 *
 * @author Milan Rathod
 */
public class Knapsack {

    /**
     * Time complexity: O(n*weight)
     * Space complexity: O(n*weight)
     * <p>
     * where n is number of items and weight is the capacity of knapsack
     *
     * @param weight  capacity of knapsack
     * @param weights array of weights
     * @param profits arry of profits
     * @return maximum profit for given capacity
     */
    public int findMaximum(int weight, int[] weights, int[] profits) {
        int[][] k = new int[profits.length + 1][weight + 1];

        for (int i = 0; i <= profits.length; i++) {
            for (int w = 0; w <= weight; w++) {
                if (i == 0 || w == 0) {
                    k[i][w] = 0;
                } else if (weights[i-1] <= w) {
                    k[i][w] = Math.max(k[i - 1][w], k[i - 1][w - weights[i-1]] + profits[i-1]);
                } else {
                    k[i][w] = k[i - 1][w];
                }
            }
        }

        return k[profits.length][weight];
    }
}
