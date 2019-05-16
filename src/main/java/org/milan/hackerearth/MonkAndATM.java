package org.milan.hackerearth;

import java.math.BigInteger;

/**
 * Problem: Monk and ATM - Number Theory
 * <p>
 * refer {@link @https://www.hackerearth.com/problem/algorithm/monk-and-atm/}
 *
 * @author Milan Rathod
 */
public class MonkAndATM {

    public int checkPin(int n) {
        int max = 0;
        int pin = 1;
        for (int i = pin; i <= n / 2; i++) {
            int temp = returnCoin(n, i);
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }

    private int returnCoin(int N, int pin) {
        if (N % pin != 0)
            return 0;

        int M = N / pin;
        int value = 0;
        for (int i = 1; i <= M; i++) {
            BigInteger b1 = new BigInteger(String.valueOf(i));
            BigInteger b2 = new BigInteger(String.valueOf(M));
            if (b1.gcd(b2).equals(b1)) {
                value++;
            }
        }
        if (isPowerof2(value))
            return value;
        else
            return 0;

    }

    private boolean isPowerof2(int value) {
        return (value & -value) == value;
    }

}
