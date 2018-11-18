package org.milan.core.polymorphism;

/**
 * @author Milan Rathod
 */
public class Child extends Parent {

    /**
     * You can change return type of overridden method only if it is a subclass
     * <p>
     * You can change visibility of method of superclass from protected to public
     */
    @Override
    public int add(int a, int b) throws IndexOutOfBoundsException {
        return ((2 * (a + b)));
    }
}

