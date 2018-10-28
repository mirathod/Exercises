package org.milan.hackerearth;

import java.util.Scanner;

/**
 * Sheldon and array - Number Theory
 *
 * @author Milan Rathod
 */
public class SheldonAndArray {

    p

    public static void main(String args[]) throws Exception {

        Scanner sn = new Scanner(System.in);
        int N = sn.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sn.nextInt();
        }
        System.out.print("-1 ");

        for (int i = 1; i < arr.length; i++) {
            int index = i, maxGCD = 1;
            for (int j = i - 1; j >= 0; j--) {

                int gcd = gcd(arr[i], arr[j]);

                if (gcd > maxGCD) {
                    index = j + 1;
                    maxGCD = gcd;
                }

            }
            System.out.print(index + " ");

        }

    }

    /*
     * private static int gcd(int a,int b){ BigInteger b1 = BigInteger.valueOf(a);
     * BigInteger b2 = BigInteger.valueOf(b); BigInteger gcd = b1.gcd(b2); return
     * gcd.intValue(); }
     */
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
