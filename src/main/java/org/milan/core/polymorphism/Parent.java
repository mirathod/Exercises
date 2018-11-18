package org.milan.core.polymorphism;

/**
 * @author Milan Rathod
 * <p>
 * Overloading Demo
 * <p>
 * Signature must be different
 */
public class Parent {

    protected int add(int a, int b) {
        return (a + b);
    }

    public int add(int a, int b, int c) {
        return (a + b + c);
    }

}
