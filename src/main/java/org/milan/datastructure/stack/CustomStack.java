package org.milan.datastructure.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Custom Implementation of {@link java.util.Stack}
 *
 * @author Milan Rathod
 */
public class CustomStack<T> {

    /**
     * Default capacity of stack
     */
    private static final int DEFAULT_CAPACITY = 4;

    /**
     * current size of the stack
     */
    private int size = 0;

    /**
     * capacity of the stack
     */
    private int capacity;

    /**
     * data store to store stack elements
     */
    private T[] store;

    @SuppressWarnings("unchecked")
    public CustomStack() {
        this.capacity = DEFAULT_CAPACITY;
        store = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public CustomStack(int capacity) {
        this.capacity = capacity;
        store = (T[]) new Object[capacity];
    }

    /**
     * Push new item to top of the stack
     *
     * @param value item to be pushed
     */
    public void push(T value) {

        // If stack is full increase size of store
        if (this.size == capacity) {
            capacity = (size << 1);
            store = Arrays.copyOf(store, capacity);
        }

        store[size++] = value;
    }

    /**
     * Pop top item from the stack
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T value = store[--size];

        // To prevent memory leak dereference element at top of the stack
        store[size] = null;

        if (size <= capacity / 4 && capacity > DEFAULT_CAPACITY) {
            capacity = capacity >> 1;
            store = Arrays.copyOf(store, capacity);
        }
        return value;
    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            T element = store[i];
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return top of the stack
     */
    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return store[size - 1];
    }

    /**
     * size of the stack
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Clear all elements of the stack
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            store[i] = null;
        }
        size = 0;
    }

    /**
     * Check if stack is empty or not
     *
     * @return true if empty otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = size - 1; i >= 0; i--) {
            stringBuilder.append(store[i]);

            if (i > 0) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
