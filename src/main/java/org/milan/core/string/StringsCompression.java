package org.milan.core.string;

/**
 * Problem: String compression
 *
 * @author Milan Rathod
 */
public class StringsCompression {

    public String compression(String input) {
        if (input != null) {
            StringBuffer sb = new StringBuffer();
            int count = 1;
            char prev = input.charAt(0);
            for (int i = 1; i < input.length(); i++) {
                char curr = input.charAt(i);
                if (prev == curr) {
                    count++;
                } else {
                    sb.append(prev);
                    sb.append(count);
                    prev = curr;
                    count = 1;
                }
            }
            sb.append(prev);
            sb.append(count);
            if (sb.length() < input.length()) {
                return sb.toString();
            } else {
                return input;
            }

        } else {
            return "Empty String";
        }
    }
}
