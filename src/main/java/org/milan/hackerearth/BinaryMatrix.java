package org.milan.hackerearth;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Binary Matrix
 *
 * @author Milan Rathod
 */
public class BinaryMatrix {

    public int main(String args[]) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        s.nextLine();
        BigInteger maxValue = new BigInteger("0");
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            String binary = s.nextLine();
            BigInteger decimal = new BigInteger(binary, 2);
            if (maxValue.compareTo(decimal) < 0) {
                maxValue = decimal;
                maxIndex = i;
            }
        }
        return maxIndex + 1;

    }

}

