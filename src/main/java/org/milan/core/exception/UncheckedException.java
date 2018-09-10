package org.milan.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unchecked Exceptions
 */
public class UncheckedException {

    private static final Logger LOG = LoggerFactory.getLogger(UncheckedException.class);

    public int arithmeticException(int a, int b) {

        // If b is zero then exception caught by JVM
        return a / b;
    }

    public int arithmeticExceptionHandled(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            LOG.error("Arithmetic Exception Caught by User {} ", e.getMessage());
        } catch (Exception e) {
            LOG.error("Exception Caught by User {} ", e.getMessage());
        } finally {
            // Clean up code
            LOG.debug("Clean up code");
        }
        return -1;
    }

    public int customExceptionHandled(int a, int b) {
        // Outer Try
        try {
            // Inner Try
            try {
                return a / b;
            } catch (Exception e) {
                throw new MyException();
            }
        } catch (MyException e) {
            LOG.error("Custom Exception Caught by User {} ", e.getMessage());
        }
        return -1;
    }

    public int explicitlyExceptionThrown(int a, int b) {
        try {
            if (b < 0) {
                throw new ArithmeticException("Explicitly Thrown");
            }
        } catch (ArithmeticException e) {
            LOG.error("Explicit Thrown Exception Caught by User {} ", e.getMessage());
        }
        return -1;
    }

}
