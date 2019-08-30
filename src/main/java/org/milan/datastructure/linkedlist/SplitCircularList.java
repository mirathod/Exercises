package org.milan.datastructure.linkedlist;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Problem: Split circular linked list into two circular linked lists
 *
 * @author Milan Rathod
 */
public class SplitCircularList {

    public List<CircularLinkedList.Node<Integer>> split(CircularLinkedList.Node<Integer> head) {
        CircularLinkedList.Node<Integer> slowPtr = head;
        CircularLinkedList.Node<Integer> fastPtr = head;

        while (fastPtr.next != head && fastPtr.next.next != head) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        // If even number of nodes in list then move fastPtr
        if (fastPtr.next.next == head) {
            fastPtr = fastPtr.next;
        }

        // Set the head pointer of first half
        CircularLinkedList.Node<Integer> head1 = head;

        // Set the head pointer of second half
        CircularLinkedList.Node<Integer> head2 = null;
        if (head.next != head) {
            head2 = slowPtr.next;
        }

        // Make second half circular
        fastPtr.next = slowPtr.next;

        // Make first half circular
        slowPtr.next = head;

        return List.of(head1, head2);
    }
}
