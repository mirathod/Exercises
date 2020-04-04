package org.milan.misc;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/}
 *
 * @author Milan Rathod
 */
public class BiggestNumber {

    public BigInteger find(int[] arr) {

        List<Integer> list = Arrays.stream(arr).boxed().sorted((o1, o2) -> {
            String s1 = o1 + String.valueOf(o2);
            String s2 = o2 + String.valueOf(o1);

            return s2.compareTo(s1);
        }).collect(Collectors.toList());

        StringBuilder output = new StringBuilder();

        list.forEach(output::append);

        return new BigInteger(output.toString());
    }
}
