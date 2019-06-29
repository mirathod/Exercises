package org.milan.core.string;

import java.util.stream.IntStream;

/**
 * Generate Random string
 * <p>
 * refer {@link @https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/}
 *
 * @author Milan Rathod
 */
public class RandomString {

    private static final String ALPHA_NUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";

    public static void main(String[] args) {
        System.out.println(new RandomString().generate(20));

        IntStream intStream = "geeks".chars();

        intStream.collect(StringBuilder::new,
                StringBuilder::appendCodePoint,
                StringBuilder::append);
    }

    public String generate(int size) {
        StringBuilder stringBuilder = new StringBuilder(size);

        for (int i = 0; i < size; i++) {
            int index = (int) (ALPHA_NUMERIC.length() * Math.random());

            stringBuilder.append(ALPHA_NUMERIC.charAt(index));
        }

        return stringBuilder.toString();
    }
}
