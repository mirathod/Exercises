package org.milan.nested;

/**
 * Example of static nested class
 *
 * @author Milan Rathod
 */
public class StaticEnclosing {

    private static String hello = "Hello";

    public static class StaticNested {

        public String run() {
            return hello;
        }
    }

}
