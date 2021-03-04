package org.milan.lambda;

import java.util.function.Supplier;

/**
 * @author Milan Rathod
 */
public class BestPractices {

    private String value = "Enclosing scope value";

    public static void main(String[] args) {
        BestPractices bestPractices = new BestPractices();

        bestPractices.anonymousVsLambda();
    }

    /**
     * Anonymous implementation of interface/class:
     * When you use an anonymous implementation of interface/class, it creates a new scope.
     * You can hide local variables from the enclosing scope by instantiating new local variables with the same names.
     * You can also use the keyword this inside your inner class as a reference to its instance.
     * <p>
     * Lambda:
     * lambda expressions work with enclosing scope.
     * You can’t hide variables from the enclosing scope inside the lambda’s body.
     * In this case, the keyword this is a reference to an enclosing instance.
     * <p>
     * Thus lambda expression is said to be STATELESS
     */
    private void anonymousVsLambda() {
        Thread thread = new Thread() {
            String value = "Inner class value";

            @Override
            public void run() {
                System.out.println(this.value);
            }
        };
        thread.start();

        Supplier<String> supplier = () -> {
            String value = "Lambda value";
            return this.value;
        };

        System.out.println(supplier.get());
    }
}
