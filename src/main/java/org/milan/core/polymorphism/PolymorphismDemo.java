package org.milan.core.polymorphism;

/**
 * @author Milan Rathod
 */
public class PolymorphismDemo {

    public static void main(String[] a) {

        Parent parent = new Parent();

        // Overloading means static binding
        int result = parent.add(10, 20);
        System.out.println(result);

        // Parent class reference can refer to its Children
        parent = new Child();

        // Overriding means dynamic binding
        result = parent.add(10, 20);
        System.out.println(result);
    }
}
