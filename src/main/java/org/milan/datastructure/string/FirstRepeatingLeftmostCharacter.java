package org.milan.datastructure.string;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/repeated-character-whose-first-appearance-is-leftmost/}
 *
 * @author Milan Rathod
 */
public class FirstRepeatingLeftmostCharacter {

    private static final int NUMBER_OF_CHARS = 256;

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param input input string
     * @return first repeated character from leftmost otherwise \0
     */
    public char find(String input) {
        boolean[] visited = new boolean[NUMBER_OF_CHARS];

        char repeatedChar = '\0';

        // Traverse from right to left and update repeatedChar as we
        // see a visited character
        for (int i = input.length() - 1; i >= 0; i--) {
            char ch = input.charAt(i);
            if (!visited[ch]) {
                visited[ch] = true;
            } else {
                repeatedChar = ch;
            }
        }
        return repeatedChar;
    }
}
