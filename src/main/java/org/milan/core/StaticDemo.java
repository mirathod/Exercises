package org.milan.core;

public class StaticDemo {
    static int count;
    int j;

    public StaticDemo() {
        count++;
        System.out.println("Inside Constructor");
    }

    // instance block
    {
        System.out.println("Inside Instance Block");
    }

    // static block
    static {
        System.out.println("Static block is executed first and only once.");
    }

    public static void sayHello() {

        System.out.println("Hello LDites");
    }

}
