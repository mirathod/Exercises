package org.milan.interfaces;

/**
 * Test Interface Demo
 */
public class TestInterfaceDemo {

    public static void main(String[] a) {
        TestInterface a1 = new TestInterfaceImpl();
        a1.sayHello();
        // a1.sayBye(); // cannot be called

        TestInterfaceImpl p = new TestInterfaceImpl();
        p.sayHello();
        p.sayBye();
    }
}
