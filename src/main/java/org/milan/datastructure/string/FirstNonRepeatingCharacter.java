package org.milan.datastructure.string;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/}
 *
 * @author Milan Rathod
 */
public class FirstNonRepeatingCharacter {

    private static final int NO_OF_CHARS = 256;

    public int find(String input) {
        char[] count = new char[NO_OF_CHARS];

        for (int i = 0; i < input.length(); i++) {
            count[input.charAt(i)]++;
        }

        for (int i = 0; i < input.length(); i++) {
            if (count[input.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }
}
