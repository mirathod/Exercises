package org.milan.core.interfaces;

/**
 * Use of Default and Static keyword to define non-abstract & utility method
 *
 * @author Milan Rathod
 */
public interface Java8Interface {

    void testMethod();

    default String testDefaultMethod() {
        return "Test Default Method";
    }

    static String testStaticMethod() {
        return "Test Static Method";
    }
}
