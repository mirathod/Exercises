package org.milan.core.singleton;

/**
 * Singleton using Enum
 *
 * @author Milan Rathod
 */
public enum Singleton {
    INSTANCE;

    public void show() {
        System.out.println("Singleton using Enum in Java");
    }
}
