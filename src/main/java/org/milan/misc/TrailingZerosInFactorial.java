package org.milan.misc;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/}
 *
 * @author Milan Rathod
 */
public class TrailingZerosInFactorial {

    /**
     * In any factorial of a number, trailing zeros are contributed by 5s and 2s
     * At any time number of 2s are more than number of 5s
     * So to calculate total number of trailing zeros in factorial
     * all we have to do is to find number of 5s in given number
     * This can be achieved by diving number by 5, 25, 125..
     * and counting total of it.
     * <p>
     * Time complexity: O(log(base 5)n)
     *
     * @param n number
     * @return number of trailing zeros in factorial
     */
    public int find(int n) {
        int count = 0;

        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
