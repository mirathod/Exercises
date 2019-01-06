package org.milan.core.varargs;

public class Demo {

    public static void main(String[] a) {

        System.out.println(sum(10, 20, 30));
        System.out.println(sum(10, 20));
        System.out.println(sum());

    }

    static int sum(int... v) { // ellipsis
        int sum = 0;
        for (int i : v) { // for each style loop
            sum += i;
        }
        return (sum);
    }
}
