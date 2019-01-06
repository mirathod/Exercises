package org.milan.core;

public class Unboxer {
    private Integer x;

    public boolean compare(int y) {
        return (x == y);
    }

    public static void main(String[] args) {
        Unboxer u = new Unboxer();
        if (u != null) {
            System.out.println("hi" + u);
            if (u.compare(21)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
