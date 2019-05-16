package org.milan.core;

/**
 * Example of Cloneable Interface
 *
 * @author Milan Rathod
 */
public class CloneableDemo {

    public static void main(String[] f) {
        Duplicate d1 = new Duplicate(10, "LD College");
        System.out.println("int i=" + d1.i + "  name= " + d1.name);
        Duplicate d2 = d1.createClone();
        d2.i = 30;
        System.out.println("int i=" + d2.i + "  name=" + d2.name);
        System.out.println("int i=" + d1.i + "  name= " + d1.name);
    }
}

class Duplicate implements Cloneable {
    int i;
    String name;

    public Duplicate(int i, String name) {
        this.i = i;
        this.name = name;
    }

    public Duplicate clone() {
        return new Duplicate(this.i, this.name);
    }

    public Duplicate createClone() {
        try {
            return (Duplicate) super.clone();
        } catch (Exception e) {

            return this;
        }
    }

}
