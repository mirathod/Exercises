package org.milan.exception;

/**
 * Exception class thrown when queue is full
 *
 * @author Milan Rathod
 */
public class FullQueueException extends RuntimeException {

    public FullQueueException(String msg) {
        super(msg);
    }
}
