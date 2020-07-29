package org.milan.exception;

/**
 * Custom {@link AutoCloseable}
 *
 * @author Milan Rathod
 */
public class AutoCloseableResourcesFirst implements AutoCloseable {

    public AutoCloseableResourcesFirst() {
        System.out.println("Inside AutoCloseableResourcesFirst Constructor!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Inside AutoCloseableResourcesFirst close method!");
    }

    public void test() {
        System.out.println("Inside AutoCloseableResourcesFirst test method!");
    }
}
