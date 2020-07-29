package org.milan.string;

/**
 * Equals and == comparison
 *
 * @author Milan Rathod
 */
public class DiffEqualDemo {

    public static void main(String[] s) {

        Animal animal1 = new Animal();
        animal1.setWeight(10);

        Animal animal2 = new Animal();
        animal2.setWeight(10);

        if (animal1 == animal2) {
            System.out.println("objects cannot be compared through ==");
        }

        if (animal1.equals(animal2)) {
            System.out.println("can be compared if equal method is overridden");
        }

        String s1 = "Hello";

        String s2 = new String("Hello");

        if (s1.equals(s2)) {
            System.out.println("Are Equal using equals"); // for String equal method is already overridden
        }
        if (s1 == s2) {
            System.out.println("Are Equal using ==");
        }
    }

}

class Animal {

    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        boolean flag = false;
        if (this.weight == ((Animal) o).weight) {
            flag = true;
        }
        return flag;

    }
}
