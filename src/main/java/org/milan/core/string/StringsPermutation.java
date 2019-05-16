package org.milan.core.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Problem: String Permutation
 *
 * @author Milan Rathod
 */
public class StringsPermutation {

    public boolean isPermutate(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        // put first string's characters and number of count as key-value pair in hash
        // map.
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }

        // get second string's characters and number of count as key-value pair in hash
        // map.
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (hashMap.containsKey(c)) {
                int value = hashMap.get(c);
                if (value == 0) {
                    return false;
                }
                hashMap.put(c, value - 1);
            } else {
                return false;
            }
        }

        Set<Character> keys = hashMap.keySet();

        Iterator<Character> iterator = keys.iterator();

        while (iterator.hasNext()) {
            char c = iterator.next();
            if (hashMap.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

}
