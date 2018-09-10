package org.milan.core.exception;

/**
 * Custom Exception
 *
 * @author Milan Rathod
 */
public class MyException extends Exception {

    @Override
    public String toString() {
        return "MyException: Divide by  zero";
    }

}
