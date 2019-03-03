package org.milan.core.singleton;

/**
 * Static Handler Singleton
 *
 * @author Milan Rathod
 */
public class StaticHandlerSingleton {

    private static class SingletonHandler {
        public static final StaticHandlerSingleton INSTANCE = new StaticHandlerSingleton();
    }

    public static StaticHandlerSingleton getInstance() {
        return SingletonHandler.INSTANCE;
    }
}
