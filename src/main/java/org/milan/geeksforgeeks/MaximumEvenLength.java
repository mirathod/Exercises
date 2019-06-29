package org.milan.geeksforgeeks;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/find-the-first-maximum-length-even-word-from-a-string/}
 *
 * @author Milan Rathod
 */
public class MaximumEvenLength {

    public String find(String input) {

        // Base condition
        if (input == null || input.length() == 0) {
            return null;
        }

        String[] words = input.split("\\s");

        String output = "";

        for (int i = 0; i < words.length; i++) {
            String current = words[i];

            if (current.length() % 2 == 0 && current.length() > output.length()) {
                output = current;
            }
        }
        return output;
    }
}
