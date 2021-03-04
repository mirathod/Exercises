package org.milan.nested;

/**
 * Anonymous Inner Class Demo
 *
 * @author Milan Rathod
 */
public class AnonymousInnerClass {

    public static void main(String[] args) {

        int count = 1;

        Cookable cookable = new Cookable() {

            // static members are not allowed inside anonymous inner class unless it is a constant
            // static int test = 1;

            @Override
            public void cook() {
                System.out.println("Anonymous Cookable implementation");
                test();
            }

            public void test() {
                // count variable must be effectively final or final
                System.out.println("Additional method" + count);
            }
        };

        cookable.cook();

        Sport sport = new Sport() {
            @Override
            int totalPlayers() {
                return 12;
            }
        };

        System.out.println(sport.totalPlayers());
    }
}

/**
 * Cookable Interface
 */
interface Cookable {
    void cook();
}

/**
 * Sport Abstract Class
 */
abstract class Sport {
    abstract int totalPlayers();
}


