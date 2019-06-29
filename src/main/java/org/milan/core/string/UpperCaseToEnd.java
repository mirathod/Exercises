package org.milan.core.string;

/**
 * Problem: Move all uppercase characters to the end of the string
 * <p>
 * refer {@linkplain @https://www.geeksforgeeks.org/move-all-uppercase-char-to-the-end-of-string/}
 *
 * @author Milan Rathod
 */
public class UpperCaseToEnd {

    /**
     * First take all lowercase letters and then uppercase letters and finally concatenate both and return
     */
    public String move(String input) {
        return input.replaceAll("[A-Z]+", "") + input.replaceAll("[^A-Z]+", "");
    }
}
