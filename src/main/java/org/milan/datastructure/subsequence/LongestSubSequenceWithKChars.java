package org.milan.datastructure.subsequence;

/**
 * Problem: refer {@link @https://www.geeksforgeeks.org/longest-subsequence-where-every-character-appears-at-least-k-times/}
 *
 * @author Milan Rathod
 */
public class LongestSubSequenceWithKChars {

    private static final int MAX_CHARS = 26;

    public String compute(String input, int k) {
        StringBuilder output = new StringBuilder();

        int[] frequencies = new int[MAX_CHARS];

        for (int i = 0; i < input.length(); i++) {
            frequencies[input.charAt(i) - 'a']++;
        }

        for (int i = 0; i < input.length(); i++) {
            if (frequencies[input.charAt(i) - 'a'] >= k) {
                output.append(input.charAt(i));
            }
        }
        return output.toString();
    }
}
