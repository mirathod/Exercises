package org.milan.datastructure;

import java.util.Stack;

public class QueueWith1Stack {

    Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        QueueWith1Stack q2s = new QueueWith1Stack();
        q2s.enqueue(1);
        q2s.dequeue();

    }

    public void enqueue(int x) {
        System.out.println("Enqueue " + x);
        stack.push(x);
    }

    public void dequeue() {
        System.out.println(dequeueRec(stack));

    }

    private int dequeueRec(Stack<Integer> st) {
        int x, last;
        if (st.isEmpty()) {
            System.out.println("Stack is underflow");
            return -1;
        }
        if (st.size() == 1) {
            return st.pop();

        } else {
            x = st.pop();

            last = dequeueRec(st);

            enqueue(x);
            return last;
        }

    }

}
