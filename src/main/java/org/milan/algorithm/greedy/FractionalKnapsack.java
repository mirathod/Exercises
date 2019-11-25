package org.milan.algorithm.greedy;

import java.util.Arrays;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/fractional-knapsack-problem/}
 *
 * @author Milan Rathod
 */
public class FractionalKnapsack {

    public double getMaxProfit(int[] weights, int[] profits, int capacity) {
        ItemValue[] itemValues = new ItemValue[weights.length];

        for (int i = 0; i < weights.length; i++) {
            itemValues[i] = new ItemValue(weights[i], profits[i], i);
        }

        // Sort the item values based on cost values
        Arrays.sort(itemValues, (o1, o2) -> o2.cost.compareTo(o1.cost));

        double total = 0d;

        for (ItemValue itemValue : itemValues) {
            int currentWeight = itemValue.weight;
            int currentProfit = itemValue.profit;

            if (capacity - currentWeight >= 0) {
                // Whole item can be picked
                capacity -= currentWeight;
                total += currentProfit;
            } else {
                // Whole item can't be picked
                double fraction = (double) capacity / (double) currentWeight;
                total += currentProfit * fraction;
                capacity = (int) (capacity - currentWeight * fraction);
                break;
            }
        }
        return total;
    }

    static class ItemValue {
        Double cost;

        int weight, profit, index;

        public ItemValue(int weight, int profit, int index) {
            this.weight = weight;
            this.profit = profit;
            this.index = index;
            this.cost = (double) profit / weight;
        }
    }
}


