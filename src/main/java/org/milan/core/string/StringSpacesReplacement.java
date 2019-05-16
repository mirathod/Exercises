package org.milan.core.string;

/**
 * Problem: String space replacement
 *
 * @author Milan Rathod
 */
public class StringSpacesReplacement {

    public String replaceSpaces(String input) {
        char[] arr = input.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 32)
                sb.append("%20");
            else
                sb.append(arr[i]);

        }
        return sb.toString();
    }

}
