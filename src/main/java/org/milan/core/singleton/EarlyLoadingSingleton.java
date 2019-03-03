package org.milan.core.singleton;

/**
 * Early Loaded Singleton using static final initialization
 *
 * @author Milan Rathod
 */
public class EarlyLoadingSingleton {

    private static final EarlyLoadingSingleton INSTANCE = new EarlyLoadingSingleton();

    private EarlyLoadingSingleton() {

    }

    public static EarlyLoadingSingleton getInstance() {
        return INSTANCE;
    }
}
