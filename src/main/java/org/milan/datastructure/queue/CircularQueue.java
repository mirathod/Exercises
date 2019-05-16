package org.milan.datastructure.queue;

/**
 * Implementation of Circular Queue
 *
 * @author Milan Rathod
 */
public class CircularQueue {

    private int front;

    private int rear;

    private int size;

    private int[] items;

    public CircularQueue(int size) {
        this.size = size;
        front = -1;
        rear = -1;
        items = new int[size];
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else if (front == -1) {
            front = 0;
            rear = 0;
            items[rear] = element;
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            items[rear] = element;
        } else {
            rear += 1;
            items[rear] = element;
        }
    }

    public int dequeue() {
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

    private boolean isFull() {
        return ((rear == front - 1) || (rear == size - 1 && front == 0));
    }

    private boolean isEmpty() {
        return front == -1;

    }
}
