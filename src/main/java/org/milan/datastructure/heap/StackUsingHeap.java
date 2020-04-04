package org.milan.datastructure.heap;

import org.milan.exception.StackUnderflowError;

import java.util.PriorityQueue;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/implement-stack-using-priority-queue-or-heap/}
 *
 * @author Milan Rathod
 */
public class StackUsingHeap {

    /**
     * Variable used for maintaining priority
     */
    private int count;

    private PriorityQueue<StackElement> priorityQueue;

    public StackUsingHeap() {
        priorityQueue = new PriorityQueue<>((o1, o2) -> o2.getPriority() - o1.getPriority());
    }

    /**
     * Stack push operation
     *
     * @param item item to be inserted
     */
    public void push(int item) {
        priorityQueue.add(new StackElement(count++, item));
    }

    /**
     * Stack pop operation
     *
     * @return popped item
     */
    public int pop() {
        if (isEmpty()) {
            throw new StackUnderflowError("Stack is empty");
        }
        return priorityQueue.poll().getElement();
    }

    /**
     * Check if stack is empty or not
     */
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }
}

/**
 * Class responsible for storing element and its priority in priority queue
 */
class StackElement {

    private int priority;

    private int element;

    public StackElement(int priority, int element) {
        this.priority = priority;
        this.element = element;
    }

    public int getPriority() {
        return priority;
    }

    public int getElement() {
        return element;
    }
}