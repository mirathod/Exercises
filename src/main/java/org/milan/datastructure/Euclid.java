package org.milan.datastructure;

/**
 * Euclid Algorithm
 *
 * @author Milan Rathod
 */
public class Euclid {

    public static void main(String[] args) {
        int result = new Euclid().Gcd(5, 1);
        System.out.println("result : " + result);
    }

    int Gcd(int M, int N) {
        int Remainder;
        while (N > 0) {
            Remainder = M % N;
            M = N;
            N = Remainder;
        }

        return M;
    }
}
