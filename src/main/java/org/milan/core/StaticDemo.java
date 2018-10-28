package org.milan.core;

/**
 * @author Milan Rathod
 */
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

    public static void main(String[] a) {
        StaticDemo a1 = new StaticDemo();
        StaticDemo a2 = new StaticDemo();

        System.out.println("No of Objects Created :" + StaticDemo.count);
        StaticDemo.sayHello(); // proper way

        a1.sayHello(); // no error but aa not proper way to call static method
    }

}
