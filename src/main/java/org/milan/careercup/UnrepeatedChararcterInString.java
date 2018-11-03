package org.milan.careercup;

import java.util.HashMap;
import java.util.Map;

/**
 * Find longest substring which has unrepeated characters
 * {@link @https://www.careercup.com/question?id=5684278553739264}
 *
 * @author Milan Rathod
 */
public class UnrepeatedChararcterInString {

    /**
     * @param inputString given string
     * @return target string
     */
    public String longestSubstringUnrepeatedChar(String inputString) {
        String longestSoFar = "";
        String longestSubstringResult = "";

        // Check if string is empty, return empty string
        if (inputString.isEmpty()) {
            return "";
        }

        // check if string is of 1 char, return input string
        if (inputString.length() == 1) {
            return inputString;
        }

        // Map consists of key/value pair of Character and its index position in array.
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < inputString.length(); i++) {
            char currentCharacter = inputString.charAt(i);

            if (longestSoFar.indexOf(currentCharacter) == -1) {
                longestSoFar += currentCharacter;
            } else {
                longestSoFar = inputString.substring(map.get(currentCharacter) + 1, i + 1);
            }
            map.put(currentCharacter, i);
            if (longestSoFar.length() > longestSubstringResult.length()) {
                longestSubstringResult = longestSoFar;
            }
        }
        return longestSubstringResult;
    }
}
