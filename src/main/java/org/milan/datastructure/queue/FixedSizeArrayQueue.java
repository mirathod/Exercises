package org.milan.datastructure.queue;

import org.milan.exception.EmptyQueueException;
import org.milan.exception.FullQueueException;

/**
 * Queue implementation using fixed sized array
 *
 * @author Milan Rathod
 */
public class FixedSizeArrayQueue {

    /**
     * front pointer for pointing first element in queue
     */
    private int front;

    /**
     * rear pointer for pointing last element in queue
     */
    private int rear;

    /**
     * size of the queue
     */
    private int size;

    /**
     * capacity of the queue
     */
    private int capacity;

    /**
     * default capacity of the queue
     */
    private static final int DEFAULT_CAPACITY = 8;

    /**
     * array for storing queue elements
     */
    private int[] items;

    public FixedSizeArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public FixedSizeArrayQueue(int capacity) {
        front = 0;

        rear = 0;

        size = 0;

        this.capacity = capacity;

        items = new int[capacity];
    }

    /**
     * Insert an element to rear of the queue
     *
     * @param element element to be inserted
     * @throws FullQueueException if stack is full
     */
    public void enqueue(int element) {

        if (isFull()) {
            throw new FullQueueException("Queue is full");
        }

        // Insert element in array
        items[rear] = element;

        // Increment rear pointer
        rear = (rear + 1) % capacity;

        // Increment size
        size++;
    }

    /**
     * Remove an element from the front of the queue
     *
     * @return element at front pointer
     * @throws EmptyQueueException if stack is empty
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }

        // Store element at front pointer to item temp variable
        int temp = items[front];

        // Increment front pointer
        front = (front + 1) % capacity;

        // Decrement size
        size--;

        return temp;
    }

    /**
     * returns number of elements in queue
     */
    public int size() {
        return size;
    }

    /**
     * Check if queue is full or not
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Check if queue is empty or not
     */
    public boolean isEmpty() {
        return size == 0;
    }

}