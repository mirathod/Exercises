package org.milan;

/**
 * Example of Static Block, Static Method and Instance Block
 *
 * @author Milan Rathod
 */
public class StaticDemo {
    private static int count;

    public static void main(String[] a) {
        StaticDemo firstObject = new StaticDemo();
        StaticDemo secondObject = new StaticDemo();

        System.out.println("No of Objects Created :" + StaticDemo.count);

        // Correct Way
        StaticDemo.sayHello();

        // Incorrect Way
        firstObject.sayHello();
    }

    private StaticDemo() {
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

    private static void sayHello() {

        System.out.println("Hello LDites");
    }

}
