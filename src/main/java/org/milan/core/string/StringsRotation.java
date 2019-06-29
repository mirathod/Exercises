package org.milan.core.string;

/**
 * Problem: String Roatation
 *
 * @author Milan Rathod
 */
public class StringsRotation {

    public boolean isRotated(String s1, String s2) {
        if ((s1 == null || s2 == null) || s1.length() != s2.length()) {
            return false;
        }
        return (s1 + s1).contains(s2);
    }

}
