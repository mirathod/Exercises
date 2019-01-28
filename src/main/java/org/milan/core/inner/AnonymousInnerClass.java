package org.milan.core.inner;

/**
 * Anonymous Inner Class Demo
 *
 * @author Milan Rathod
 */
public class AnonymousInnerClass {

    public static void main(String[] args) {

        Cookable cookable = new Cookable() {

            @Override
            public void cook() {
                System.out.println("Anonymous Cookable implementation");
                test();
            }

            public void test() {
                System.out.println("Additional method");
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


