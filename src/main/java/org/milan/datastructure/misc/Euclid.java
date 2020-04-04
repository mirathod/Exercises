package org.milan.datastructure.misc;

/**
 * Euclid Algorithm
 *
 * @author Milan Rathod
 */
public class Euclid {

    public int gcd(int M, int N) {
        int Remainder;
        while (N > 0) {
            Remainder = M % N;
            M = N;
            N = Remainder;
        }
        return M;
    }
}
