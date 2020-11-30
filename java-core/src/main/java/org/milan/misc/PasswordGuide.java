package org.milan.misc;

import java.util.Arrays;

/**
 * Refer {@link @https://www.baeldung.com/java-storing-passwords}
 *
 * @author Milan Rathod
 */
public class PasswordGuide {

    public static void main(String[] args) {
        PasswordGuide passwordGuide = new PasswordGuide();

        passwordGuide.stringAsPassword("password");

        passwordGuide.charArrayAsPassword(new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'});
    }

    /**
     * Since String object is immutable in java
     * any modification to existing string will create new string
     * and old string password will be stored in string pool till
     * garbage collection happens and garbage collector will take
     * longer time to clean up string literals then actual objects
     * since string literals stored in string pool are reusable.
     * <p>
     * So it is recommended to use char[] to store password in memory
     *
     * @param stringPassword password sent as type String
     */
    private void stringAsPassword(String stringPassword) {
        System.out.print("Original String password value: ");
        System.out.println(stringPassword);
        System.out.println("Original String password hashCode: "
                + Integer.toHexString(stringPassword.hashCode()));

        String newString = "********";
        stringPassword.replace(stringPassword, newString);

        System.out.print("String password value after trying to replace it: ");
        System.out.println(stringPassword);
        System.out.println(
                "hashCode after trying to replace the original String: "
                        + Integer.toHexString(stringPassword.hashCode()));
    }

    private void charArrayAsPassword(char[] charPassword) {
        System.out.println("Original char password value: " + charPassword);
        System.out.print("Original char password value: ");
        System.out.println(charPassword);
        System.out.println(
                "Original char password hashCode: "
                        + Integer.toHexString(charPassword.hashCode()));

        Arrays.fill(charPassword, '*');

        System.out.print("Changed char password value: ");
        System.out.println(charPassword);
        System.out.println(
                "Changed char password hashCode: "
                        + Integer.toHexString(charPassword.hashCode()));
    }
}
