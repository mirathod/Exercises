package org.milan;

/**
 * @author Milan Rathod
 */
public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        Adder adder = (a, b) -> a + b;

        System.out.println(adder.add(4, 5));
    }

}

@FunctionalInterface
interface Adder {

    int add(int a, int b);

}
