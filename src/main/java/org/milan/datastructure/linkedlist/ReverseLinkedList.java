package org.milan.datastructure.linkedlist;

/**
 * Problem: Reverse a given singly linked list
 *
 * @author Milan Rathod
 */
public class ReverseLinkedList {

    /**
     * Reverse a given linked list - iterative approach
     */
    public LinkedList.Node<Integer> reverseByIterative(LinkedList.Node<Integer> head) {
        LinkedList.Node<Integer> current = head;
        LinkedList.Node<Integer> prev = null;
        LinkedList.Node<Integer> next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    /**
     * Reverse a given linked list - recursive approach
     */
    public LinkedList.Node<Integer> reverseByRecursive(LinkedList.Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedList.Node<Integer> first = reverseByRecursive(head.next);
        head.next.next = head;

        head.next = null;

        return first;
    }
}
