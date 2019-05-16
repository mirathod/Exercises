package org.milan.datastructure.subsequence;

/**
 * Problem: refer {@link @https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/}
 *
 * @author Milan Rathod
 */
public class SubSequenceOf {

    public boolean isSubSequence(String str1, String str2, int len1, int len2) {

        // Base Conditions
        if (len1 == 0) return true;

        if (len2 == 0) return false;

        if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
            return isSubSequence(str1, str2, len1 - 1, len2 - 1);
        }

        return isSubSequence(str1, str2, len1, len2 - 1);
    }
}
