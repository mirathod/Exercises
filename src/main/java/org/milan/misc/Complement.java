package org.milan.misc;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/1s-2s-complement-binary-number/}
 *
 * @author Milan Rathod
 */
public class Complement {

    public String onesComplement(String number) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            output.append(number.charAt(i) == '0' ? '1' : '0');
        }
        return output.toString();
    }

    public String twosComplement(String number) {
        String onesComplement = onesComplement(number);

        String output = onesComplement;

        int i;
        for (i = onesComplement.length() - 1; i >= 0; i--) {
            if (onesComplement.charAt(i) == '1') {
                output = output.substring(0, i) + '0' + output.substring(i + 1);
            } else {
                output = output.substring(0, i) + '1' + output.substring(i + 1);
                break;
            }
        }

        if (i == -1) {
            output = '1' + output;
        }
        return output;
    }
}
