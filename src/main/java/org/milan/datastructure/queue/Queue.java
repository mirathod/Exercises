package org.milan.datastructure.queue;

/**
 * Queue Implementation using Array
 *
 * @author Milan Rathod
 */
public class Queue {

    private int front;

    private int rear;

    private int size;

    private int[] items;

    public Queue(int size) {
        front = 0;

        this.size = size;

        rear = 0;

        items = new int[size];
    }

    /**
     * Check if items is full
     */
    public boolean isFull(Queue queue) {
        return queue.rear == queue.size;
    }

    /**
     * Check if items is empty
     */
    public boolean isEmpty(Queue queue) {
        return queue.rear == queue.front;
    }

    /**
     * Insert an element into an items
     */
    public void enqueue(int element) {
        if (isFull(this)) return;

        this.items[this.rear] = element;

        this.rear += 1;
    }

    /**
     * Remove an element from an items
     */
    public int dequeue() {
        if (isEmpty(this)) return Integer.MIN_VALUE;

        int item = this.items[this.front];
        this.front += 1;
        return item;
    }
}