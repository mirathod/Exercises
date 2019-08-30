package org.milan.datastructure.linkedlist;

/**
 * Problem: Reverse a given linked list in group size
 *
 * @author Milan Rathod
 */
public class ReverseInGroupSize {

    /**
     * @param head head of the linked list
     * @param size group size
     * @return head after reversal
     */
    public LinkedList.Node<Integer> reverseByGroupSize(LinkedList.Node<Integer> head, int size) {
        LinkedList.Node<Integer> current = head;
        LinkedList.Node<Integer> prev = null;
        LinkedList.Node<Integer> next = null;
        int count = 0;
        while (count < size && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null)
            head.next = reverseByGroupSize(next, size);
        return prev;
    }
}
