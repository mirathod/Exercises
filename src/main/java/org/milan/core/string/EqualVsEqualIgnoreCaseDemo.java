package org.milan.core.string;

/**
 * Equals and EqualIgnoreCase Comparison
 *
 * @author Milan Rathod
 */
public class EqualVsEqualIgnoreCaseDemo {

    public static void main(String[] a) {
        String s1 = "yash";
        String s2 = "Yash";

        if (s1.equals(s2)) {
            System.out.println("case wise they are equal");
        }
        if (s1.equalsIgnoreCase(s2)) {
            System.out.println("they are equal ignoring case");
        }

    }
}
