package org.milan.datastructure.linkedlist;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/reverse-stack-without-using-extra-space/}
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 * @author Milan Rathod
 */
public class ReverseStack {

    private LinkedList.Node<Integer> top;

    private ReverseLinkedList reverseLinkedList;

    public ReverseStack() {
        reverseLinkedList = new ReverseLinkedList();
    }

    /**
     * Push data to linked list
     *
     * @param data data to be pushed
     */
    public void push(int data) {
        LinkedList.Node<Integer> stackNode = new LinkedList.Node<>(data);
        if (this.top != null) {
            stackNode.next = top;
        }
        top = stackNode;
    }

    /**
     * Pop item from linked list
     */
    public int pop() {
        LinkedList.Node<Integer> s = top;
        top = top.next;
        return s.data;
    }

    /**
     * Reverse given stack using linked list
     */
    public void reverse() {
        top = reverseLinkedList.reverseByIterative(top);
    }

}