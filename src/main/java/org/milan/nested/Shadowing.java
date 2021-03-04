package org.milan.nested;

/**
 * @author Milan Rathod
 */
public class Shadowing {

    int a = 1;
    static int b = 2;

    public class InnerClass {
        int a = 3;
        static final int b = 4;

        public void run() {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("NewOuterTest.this.a = " + Shadowing.this.a);
            System.out.println("NewOuterTest.b = " + Shadowing.b);
            System.out.println("NewOuterTest.this.b = " + Shadowing.this.b);
        }
    }
}
