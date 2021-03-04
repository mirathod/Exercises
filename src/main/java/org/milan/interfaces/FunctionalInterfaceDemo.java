package org.milan.interfaces;

import java.util.function.Function;

/**
 * {@link Function} demo
 *
 * @author Milan Rathod
 */
interface Functional<T, C> {
    Function<T, C> toFunction();
}

class TestA implements Functional<String, Integer> {

    @Override
    public Function<String, Integer> toFunction() {
        return TestA::length;
    }

    private static Integer length(String input) {
        return input.length();
    }
}

class TestB implements Functional<String, Integer> {

    @Override
    public Function<String, Integer> toFunction() {
        return TestB::hashCode;
    }

    private static Integer hashCode(String input) {
        return input.hashCode();
    }
}