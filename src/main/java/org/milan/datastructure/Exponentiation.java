package org.milan.datastructure;

public class Exponentiation {
    public static void main(String[] args) {
        long exp = new Exponentiation().pow(2, 5);
        System.out.println("Exponentiation : " + exp);
    }

    long pow(long x, long n) {
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
