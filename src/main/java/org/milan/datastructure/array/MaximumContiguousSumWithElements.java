package org.milan.datastructure.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem: Maximum contiguous sum with consecutive elements of size k and l
 * <p>
 * example: given array {6, 1, 4, 6, 3, 2, 7, 4}, k = 3, l = 2
 * here for k =3 maximum sum consists of the elements {4, 6, 3} and sum is 13 till now.
 * after that array is merged together. Resultant array {6, 1, 3, 2 ,7, 4}
 * for l = 2 maximum sum consists of the elements {7, 4}
 * sum is 11.
 * Total sum is 24
 *
 * @author Milan Rathod
 */
public class MaximumContiguousSumWithElements {

    public int solution(int[] input, int k, int l) {

        // Base condition
        if (input.length < k + l) {
            return -1;
        }

        int total = 0;

        int[] maxAndStartingIndex = getMaxContiguousSumFromArray(input, k);

        total += maxAndStartingIndex[0];

        int[] leadingElements = Arrays.copyOfRange(input, 0, maxAndStartingIndex[1]);
        int[] trailingElements = Arrays.copyOfRange(input, (maxAndStartingIndex[1] + k), input.length);

        List<Integer> mergedElements = Arrays.stream(leadingElements).boxed().collect(Collectors.toList());

        mergedElements.addAll(Arrays.stream(trailingElements).boxed().collect(Collectors.toList()));

        int[] mergedElementsArray = mergedElements.stream().mapToInt(i -> i).toArray();

        maxAndStartingIndex = getMaxContiguousSumFromArray(mergedElementsArray, l);

        total += maxAndStartingIndex[0];

        return total;
    }

    private int[] getMaxContiguousSumFromArray(int[] a, int consecutiveElements) {
        int latestSum = 0;
        int prevSum = 0;
        int startingIndex = 0;
        int[] maxAndStartingIndex = new int[2];
        for (int i = 0; i < a.length; i++) {
            if (i <= a.length - consecutiveElements) {
                for (int j = i; j < i + consecutiveElements; j++) {
                    latestSum += a[j];
                }
            }

            if (latestSum > prevSum) {
                prevSum = latestSum;
                startingIndex = i;

            }
            latestSum = 0;
        }
        maxAndStartingIndex[0] = prevSum;
        maxAndStartingIndex[1] = startingIndex;
        return maxAndStartingIndex;
    }

}
