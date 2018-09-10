package org.milan.core;

public class Hello {

    public static void main(String[] a) {
        StaticDemo a1 = new StaticDemo();
        StaticDemo a2 = new StaticDemo();

        System.out.println("No of Objects Created :" + StaticDemo.count);
        StaticDemo.sayHello(); // proper way

        a1.sayHello(); // no error but aa not proper way to call static method
    }

}
