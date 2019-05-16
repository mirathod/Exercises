package org.milan.datastructure.stack;

import java.util.Arrays;

/**
 * Custom Implementation of {@link java.util.Stack}
 *
 * @author Milan Rathod
 */
public class CustomStack<T> {

    private static final int DEFAULT_CAPACITY = 5;

    private int size = 0;

    private int capacity;

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

    public boolean push(T value) {
        if (this.size >= store.length) {
            int newSize = size + (size >> 1);
            store = Arrays.copyOf(store, newSize);
        }

        store[size++] = value;
        return true;
    }

    public T pop() {
        if (size <= 0) {
            return null;
        }

        T value = store[--size];

        // To prevent memory leak dereference element at top of the stack
        store[size] = null;

        int reducedSize = size;
        if (size >= capacity && size < (reducedSize + (reducedSize << 1))) {
            System.arraycopy(store, 0, store, 0, size);
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

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            store[i] = null;
        }
        size = 0;
    }

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
