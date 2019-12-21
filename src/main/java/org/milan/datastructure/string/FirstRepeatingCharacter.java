package org.milan.datastructure.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/find-the-first-repeated-character-in-a-string/}
 *
 * @author Milan Rathod
 */
public class FirstRepeatingCharacter {

    public char find(String input) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (set.contains(ch)) {
                return ch;
            }
            set.add(ch);
        }
        return '\0';
    }
}
