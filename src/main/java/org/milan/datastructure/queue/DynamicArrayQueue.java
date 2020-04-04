package org.milan.datastructure.queue;

import org.milan.exception.EmptyQueueException;

/**
 * Queue implementation using dynamic sized array
 *
 * @author Milan Rathod
 */
public class DynamicArrayQueue {

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

    public DynamicArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArrayQueue(int capacity) {

        items = new int[capacity];

        this.capacity = capacity;

        size = 0;

        front = 0;

        rear = 0;
    }

    /**
     * Insert an element to rear of the queue
     *
     * @param element element to be inserted
     */
    public void enqueue(int element) {

        // If queue is full expand the size of it
        if (isFull()) {
            expandSpace();
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

        //
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }

        // Shrink array size by 1/2 if 3/4th of array is empty
        if (size <= capacity / 4 && capacity > DEFAULT_CAPACITY) {
            shrinkSpace();
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
     * TODO should we expose this method or not?
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

    /**
     * Expand the size of array by double
     */
    public void expandSpace() {
        capacity = (size << 1);

        // Copy all elements from current array to new array
        copyElements(capacity);
    }

    /**
     * Shrink the size of array by half
     */
    public void shrinkSpace() {
        capacity = capacity >> 1;

        // Copy all elements from current array to new array
        copyElements(capacity);
    }

    /**
     * Copy all elements from current array to newly created array based on
     * input capacity
     *
     * @param capacity size of newly created array to which current array should be copied
     */
    private void copyElements(int capacity) {
        int[] newArray = new int[capacity];

        int tempFront = front;

        int index = -1;

        // Copy all elements from current array to new array
        while (true) {
            newArray[++index] = items[tempFront];
            tempFront++;

            if (tempFront == items.length) {
                tempFront = 0;
            }

            if (index + 1 == size) {
                break;
            }
        }

        items = newArray;

        front = 0;

        rear = (index + 1) % capacity;
    }
}
