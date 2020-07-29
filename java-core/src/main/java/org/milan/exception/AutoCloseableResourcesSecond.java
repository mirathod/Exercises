package org.milan.exception;

/**
 * Custom {@link AutoCloseable}
 *
 * @author Milan Rathod
 */
public class AutoCloseableResourcesSecond implements AutoCloseable {

    public AutoCloseableResourcesSecond() {
        System.out.println("Inside AutoCloseableResourcesSecond Constructor!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Inside AutoCloseableResourcesSecond close method!");
    }

    public void test() {
        System.out.println("Inside AutoCloseableResourcesSecond test method!");
    }
}
