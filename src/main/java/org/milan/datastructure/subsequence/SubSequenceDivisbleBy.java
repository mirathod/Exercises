package org.milan.datastructure.subsequence;

/**
 * Problem: refer {@link @https://www.geeksforgeeks.org/number-subsequences-string-divisible-n/}
 *
 * @author Milan Rathod
 */
public class SubSequenceDivisbleBy {

    public int count(String str, int n) {

        int length = str.length();

        // Divison by n can leave only n remainder [0..n-1]
        // divison[i][j] indicates number of
        // sub in string [0..i] which leaves
        // remainder j after division by n.
        int[][] divison = new int[length][n];

        divison[0][str.charAt(0) - '0']++;

        for (int i = 1; i < length; i++) {
            divison[i][(str.charAt(i) - '0') % n]++;

            for (int j = 0; j < n; j++) {

                // Exclude 'i'th character from all the current sub sequence of string [0...i-1]
                divison[i][j] += divison[i - 1][j];

                // Include 'i'th character in all the current sub sequence of string [0...i-1]
                divison[i][(j * 10 + (str.charAt(i) - '0')) % n] += divison[i - 1][j];
            }
        }

        return divison[length - 1][0];

    }
}
