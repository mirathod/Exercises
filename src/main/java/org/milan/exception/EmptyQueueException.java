package org.milan.exception;

/**
 * Exception class thrown when queue is empty
 *
 * @author Milan Rathod
 */
public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException(String msg) {
        super(msg);
    }
}
