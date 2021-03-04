package org.milan.exception;

/**
 * Try with resources example
 *
 * @author Milan Rathod
 */
public class TryWithResources {

    public static void main(String[] args) {
        AutoCloseableResourcesFirst autoCloseableResourcesFirst = new AutoCloseableResourcesFirst();
        AutoCloseableResourcesSecond autoCloseableResourcesSecond = new AutoCloseableResourcesSecond();

        try (autoCloseableResourcesFirst; autoCloseableResourcesSecond) {
            autoCloseableResourcesFirst.test();
            autoCloseableResourcesSecond.test();
        } catch (Exception e) {
            System.err.println("Something bad happened!");
        }
    }
}
