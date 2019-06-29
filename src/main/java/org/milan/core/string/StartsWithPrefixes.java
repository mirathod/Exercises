package org.milan.core.string;

import java.util.stream.Stream;

/**
 * Problem: Check if string starts with any of given prefixes
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/check-if-a-string-starts-with-any-of-the-given-prefixes-in-java/}
 *
 * @author Milan Rathod
 */
public class StartsWithPrefixes {

    public boolean usingRegularExpression(String input, String[] prefixes) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");

        // Build regular expression
        for (int i = 0; i < prefixes.length - 1; i++) {
            stringBuilder.append(prefixes[i]);
            stringBuilder.append("|");
        }

        stringBuilder.append(prefixes[prefixes.length - 1]);
        stringBuilder.append(").*");

        return input.matches(stringBuilder.toString());
    }

    public boolean usingStreams(String input, String[] prefixes) {
        return Stream.of(prefixes)
                .anyMatch(input::startsWith);

    }
}
