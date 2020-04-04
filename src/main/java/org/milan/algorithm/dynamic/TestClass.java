package org.milan.algorithm.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class TestClass {

    static List<Integer> findTruckCargo(int maxCargoWeight, List<List<Integer>> cargoList) {

        int n = cargoList.size();

        int[][] K = new int[n + 1][maxCargoWeight + 1];

        int[] wt = new int[n];

        int[] val = new int[n];

        int[] cargoNumbers = new int[n];

        for (int j = 0; j < n; j++) {
            cargoNumbers[j] = cargoList.get(j).get(0);
            wt[j] = cargoList.get(j).get(1);
            val[j] = cargoList.get(j).get(2);
        }

        // Build table K[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= maxCargoWeight; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] +
                            K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        // stores the result of Knapsack
        int res = K[n][maxCargoWeight];

        List<Integer> outputList = new ArrayList<>();
        outputList.add(res);

        int w = maxCargoWeight;
        for (int i = n; i > 0 && res > 0; i--) {

            if (res == K[i - 1][w])
                continue;
            else {

                // This item is included.
                outputList.add(cargoNumbers[i - 1]);
                res = res - val[i - 1];
                w = w - wt[i - 1];
            }
        }

        Collections.reverse(outputList);

        return outputList;
    }

    public static void main(String[] args) {
        List<Integer> input1 = List.of(38, 130, 500);
        List<Integer> input2 = List.of(21, 280, 1800);
        List<Integer> input3 = List.of(13, 120, 1500);


        findTruckCargo(300, List.of(input1, input2, input3));
    }
}
