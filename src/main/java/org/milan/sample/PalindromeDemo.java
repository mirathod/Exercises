package org.milan.sample;

/**
 * @author Milan Rathod
 */
public class PalindromeDemo {

    boolean palindromeString(String str) {
        String output = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            output += str.charAt(i);
        }
        if (str.equals(output)) return true;
        return false;
    }

    boolean palindromeNumber(int number) {
        int input = number, output = 0, mul = 1;
        while (number > 0) {
            int temp = number % 10;
            output += temp * mul;
            mul *= 10;
            number /= 10;
        }
        if (input == output) return true;
        return false;
    }


}
