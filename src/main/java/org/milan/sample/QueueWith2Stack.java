package org.milan.sample;

import java.util.Stack;

public class QueueWith2Stack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        QueueWith2Stack q2s = new QueueWith2Stack();
        q2s.enqueue(1);
        q2s.enqueue(2);
        q2s.enqueue(3);
        q2s.dequeue();
        q2s.dequeue();
        q2s.dequeue();
        q2s.enqueue(4);
        q2s.enqueue(5);
        q2s.dequeue();

    }

    public void enqueue(int x) {
        System.out.println("Enqueue " + x);
        stack1.push(x);
    }

    public int dequeue() {
        int x;
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Stack is underflow");
            return -1;
        }
        if (!stack2.isEmpty()) {
            x = stack2.pop();

        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            x = stack2.pop();
        }
        System.out.println("Dequeue " + x);
        return x;
    }

}
