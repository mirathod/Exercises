package org.milan.datastructure.misc;

/**
 * Exponentiation Example
 *
 * @author Milan Rathod
 */
public class Exponentiation {

    public long pow(long x, long n) {
        if (n == 0)
            return 1;
        //if(n==1)
        //	return x;
        if (n % 2 == 0)
            return pow(x * x, n / 2);
        else
            return pow(x * x, n / 2) * x;
    }
}
