package org.milan.datastructure.queue;

/**
 * Implementation of Deque
 *
 * @author Milan Rathod
 */
public class Deque {

    private int front;

    private int rear;

    private int size;

    private int[] items;

    public Deque(int size) {
        this.size = size;
        front = -1;
        rear = 0;
        items = new int[size];
    }

    /**
     * Insert an element at front end of queue
     */
    public void insertFront(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else if (front == -1) {
            front = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front -= 1;
        }
        items[front] = element;
    }

    /**
     * Insert an element at rear end of queue
     */
    public void insertRear(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else if (front == -1) {
            front = 0;
        } else if (rear == size - 1) {
            rear = 0;
        } else {
            rear += 1;
        }
        items[rear] = element;
    }

    /**
     * Remove an element from front end of queue
     */
    public int removeFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int element = items[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front += 1;
        }
        return element;

    }

    /**
     * Remove an element from rear end of queue
     */
    public int removeRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int element = items[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear -= 1;
        }
        return element;
    }

    private boolean isEmpty() {
        return front == -1;
    }

    private boolean isFull() {
        return ((rear == front - 1) || (rear == size - 1 && front == 0));
    }
}
