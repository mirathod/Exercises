package org.milan.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Generic Class to Execute Regex with input string and returns number of matches
 * <p>
 * Notes: Mostly being use to test all regex combinations
 *
 * @author Milan Rathod
 */
public class RegularExpression {

    public int matches(String regex, String text) {
        return findMatches(Pattern.compile(regex), text);
    }

    public int matches(String regex, String text, int flags) {
        return findMatches(Pattern.compile(regex, flags), text);
    }

    private int findMatches(Pattern pattern, String text) {
        Matcher matcher = pattern.matcher(text);

        int matches = 0;

        while (matcher.find()) {
            matches++;
        }

        return matches;
    }
}
