package org.milan;

/**
 * @author Milan Rathod
 */
public class DeprecatedDemo {

    public static void main(String[] args) {
        new DeprecatedDemo().test();
    }

    /**
     * This method is deprecated and should not be used
     *
     * @deprecated
     */
    @Deprecated(since = "1.2", forRemoval = true)
    public void test() {
        System.out.println("Deprecated");
    }
}
