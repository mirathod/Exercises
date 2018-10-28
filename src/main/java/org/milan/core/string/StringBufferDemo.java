package org.milan.core.string;

/**
 * @author Milan Rathod
 */
public class StringBufferDemo {

    public static void main(String[] a) {
        StringBuffer d = new StringBuffer("LD College");
        d.append("Yash");
        System.out.println(d);
        System.out.println(d.length());
        System.out.println(d.capacity());
        d.ensureCapacity(100);
        System.out.println(d.capacity());
    }
}
