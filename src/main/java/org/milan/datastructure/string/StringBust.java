package org.milan.datastructure.string;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem: Remove all repetitive chars from string based on bust size
 * <p>
 * Example: input string = abcdeeeeddcbfgf, burst size = 3
 * <p>
 * first round: abcdddcbfgf
 * second round: abccbfgf
 * <p>
 * output: abccbfgf
 *
 * @author Milan Rathod
 */
public class StringBust {

    public List<String> compute(List<String> inputArray, int burstSize) {

        String input = inputArray.stream().map(String::valueOf).collect(Collectors.joining());

        boolean isBurstSizeFound = false;

        StringBuilder output = new StringBuilder();

        while (true) {
            char prev = input.charAt(0);

            int counter = 1;

            int startIndex = 0;

            output.append(prev);

            for (int i = 1; i < input.length(); i++) {
                char curr = input.charAt(i);
                if (prev == curr) {
                    counter++;
                } else {

                    // Remove all repeated characters if count of repeated character are greater than burst size
                    if (counter >= burstSize) {
                        output.replace(startIndex, i, "");
                        isBurstSizeFound = true;
                    }

                    prev = curr;
                    startIndex = i;
                    counter = 1;
                }

                output.append(curr);
            }

            if (counter >= burstSize) {
                output.replace(startIndex, input.length(), "");
                isBurstSizeFound = true;
            }

            input = output.toString();
            output.delete(0, input.length());

            if (!isBurstSizeFound) {
                break;
            }

            isBurstSizeFound = false;

        }

        return input.chars().mapToObj(value -> Character.toString((char) value)).collect(Collectors.toList());

    }
}
