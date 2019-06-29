package org.milan.core.string;

/**
 * Problem: expand given string range
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/java-program-expand-string-range-given/}
 *
 * @author Milan Rathod
 */
public class ExpandStringRange {

    public String expand(String input) {
        StringBuilder output = new StringBuilder();

        String[] arr = input.split(", ");

        for (int i = 0; i < arr.length - 1; i++) {
            expand(arr[i], output);
            output.append(", ");
        }
        expand(arr[arr.length - 1], output);

        return output.toString();
    }

    private void expand(String range, StringBuilder output) {
        if (range.contains("-")) {
            String[] split = range.split("-");
            int start = Integer.valueOf(split[0]);
            int end = Integer.valueOf(split[1]);
            for (int i = start; i < end; i++) {
                output.append(i).append(", ");
            }
            output.append(end);
        } else {
            output.append(range);
        }
    }
}
