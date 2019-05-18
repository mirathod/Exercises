package org.milan.misc;

/**
 * Add 1 to any number
 *
 * @author Milan Rathod
 */
public class AddNumber {

    public int add(int number) {
        int m = 1;
        while ((number & m) == m) {
            number = number ^ m;
            m <<= 1;
        }
        number = number ^ m;
        return number;
    }
}
