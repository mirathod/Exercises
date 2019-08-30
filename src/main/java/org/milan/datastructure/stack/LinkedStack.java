package org.milan.datastructure.stack;

import java.util.EmptyStackException;

/**
 * Implement stack operations with linked list
 *
 * @author Milan Rathod
 */
public class LinkedStack<E> {

    /**
     * indicate size of the linked list
     */
    private int length;

    /**
     * indicate top of the stack/head of the linked list
     */
    private Node<E> top;

    /**
     * Push item into linked list at the beginning of the list
     *
     * @param data item to be inserted
     */
    public void push(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top.next;
            top = newNode;
        }
        length++;
    }

    /**
     * Pop item from linked list at the beginning of the list
     *
     * @return data popped item
     * @throws EmptyStackException if stack is empty
     */
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node<E> outputNode = top;
        top = top.next;
        length--;
        return outputNode.data;
    }

    /**
     * Peek item from linked list at the beginning of the list
     * NOTE: Item is not removed from linked list
     *
     * @return data peeked item
     * @throws EmptyStackException if stack is empty
     */
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    /**
     * Check if linked list is empty or not
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * return size of the linked list
     */
    public int size() {
        return length;
    }

    static class Node<E> {
        E data;

        Node<E> next;

        Node(E data) {
            this(data, null);
        }

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
