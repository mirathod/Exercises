package org.milan.core.singleton;

/**
 * Lazy Loaded Singleton using double locking mechanism
 *
 * @author Milan Rathod
 */
public class LazyLoadingSingleton {

    private static volatile LazyLoadingSingleton INSTANCE;

    private LazyLoadingSingleton() {

    }

    public static LazyLoadingSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (LazyLoadingSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyLoadingSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
