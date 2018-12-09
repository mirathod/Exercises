package org.milan.hackerearth;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link @https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/what-is-the-string-made-of-2/}
 *
 * @author Milan Rathod
 */
public class StringMadeOf {

    public int countDashes(String inputString) {

        Map<Integer, Integer> integerToDashesMapping = getIntegerToDashesMapping();

        char[] chars = inputString.toCharArray();

        int sum = 0;

        for (char ch : chars) {
            sum += integerToDashesMapping.get(Character.getNumericValue(ch));
        }

        return sum;

    }

    private Map<Integer, Integer> getIntegerToDashesMapping() {
        Map<Integer, Integer> mapping = new HashMap<>();
        mapping.put(0, 6);
        mapping.put(1, 2);
        mapping.put(2, 5);
        mapping.put(3, 5);
        mapping.put(4, 4);
        mapping.put(5, 5);
        mapping.put(6, 6);
        mapping.put(7, 3);
        mapping.put(8, 7);
        mapping.put(9, 6);
        return mapping;
    }
}
