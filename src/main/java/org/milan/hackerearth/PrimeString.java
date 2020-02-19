package org.milan.hackerearth;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Challenge: Policy Bazaar
 * Problem: Prime String {@link @https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/primestring/}
 *
 * @author Milan Rathod
 */
public class PrimeString {

    private Map<Character, Integer> mapping = new HashMap<>();

    public boolean isPrimeString(String input) {
        for (char ch : input.toCharArray()) {
            if (!mapping.containsKey(ch)) {
                mapping.put(ch, 1);
            } else {
                mapping.put(ch, mapping.get(ch) + 1);
            }
        }

        if (!isPrime(mapping.size())) {
            return false;
        } else {
            Set<Map.Entry<Character, Integer>> entries = mapping.entrySet();
            for (Map.Entry<Character, Integer> entry : entries) {
                if (!isPrime(entry.getValue())) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}
