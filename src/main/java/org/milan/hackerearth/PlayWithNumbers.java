package org.milan.hackerearth;

/**
 * {@link @https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/play-with-numbers-2/}
 *
 * @author Milan Rathod
 */
public class PlayWithNumbers {

    /**
     * find mean value of sub array specified by start and end index
     */
    public int findMean(int[] inputArray, int startIndex, int endIndex) {

        int totalNumbers = endIndex - startIndex + 1;

        int sum = 0;

        for (int i = startIndex - 1; i < endIndex; i++) {
            sum += inputArray[i];
        }

        return sum / totalNumbers;

    }

    /**
     * find mean value of sub array specified by start and end index
     */
    public long findMeanByCumulativeSum(int[] inputArray, int startIndex, int endIndex) {

        int totalNumbers = endIndex - startIndex + 1;

        long[] sums = new long[inputArray.length + 1];
        sums[0] = 0;


        for (int i = 0; i < inputArray.length; i++) {
            sums[i + 1] = sums[i] + inputArray[i];
        }

        return (sums[endIndex] - sums[startIndex - 1]) / totalNumbers;

    }
}
