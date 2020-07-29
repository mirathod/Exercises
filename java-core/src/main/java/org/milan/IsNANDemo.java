package org.milan;

/**
 * Example of NAN
 *
 * @author Milan Rathod
 */
public class IsNANDemo {

    public static void main(String[] args) {
        Double d1 = 1 / 0.0;
        Double d2 = 0 / 0.;
        System.out.println(d1 + ":" + d1.isInfinite() + "," + d1.isNaN());
        System.out.println(d2 + ":" + d2.isInfinite() + "," + d2.isNaN());
    }
}