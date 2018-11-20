package org.milan.hackerearth;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link @https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/the-great-kian/}
 *
 * @author Milan Rathod
 */
public class TheGreatKian {

    /**
     * return first three values of sum in series a1,a2,a3,..an
     * such that a1+a4+a7+..,a2+a5+a8+..,a3+a6+a9+..
     */
    public List<Long> getSumValues(int[] inputArray) {
        long number1 = 0;
        long number2 = 0;
        long number3 = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i % 3 == 1) {
                number2 += inputArray[i];
            } else if (i % 3 == 2) {
                number3 += inputArray[i];
            } else {
                number1 += inputArray[i];
            }
        }

        List<Long> output = new ArrayList<>();

        output.add(number1);
        output.add(number2);
        output.add(number3);

        return output;
    }
}
