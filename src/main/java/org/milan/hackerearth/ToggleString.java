package org.milan.hackerearth;

import com.google.common.base.Strings;

/**
 * {@link @https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/modify-the-string/}
 *
 * @author Milan Rathod
 */
public class ToggleString {

    /**
     * Toggle string character from uppercase/lowercase
     */
    public String toggle(String input) {

        if (Strings.isNullOrEmpty(input)) {
            return "";
        }

        StringBuilder output = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char ch : chars) {
            if (Character.isLowerCase(ch)) {
                output.append(Character.toUpperCase(ch));
            } else {
                output.append(Character.toLowerCase(ch));
            }
        }
        return output.toString();
    }
}
