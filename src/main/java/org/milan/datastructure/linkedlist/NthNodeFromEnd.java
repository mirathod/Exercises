package org.milan.datastructure.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/}
 *
 * @author Milan Rathod
 */
public class NthNodeFromEnd {

    private static final Logger LOG = LoggerFactory.getLogger(NthNodeFromEnd.class);

    /**
     * Find Nth Element from the end by maintaining two pointers
     *
     * @param head head of the linked list
     * @param n    nth position
     * @return Node at Nth position if exists or null
     */
    public LinkedList.Node<Integer> find(LinkedList.Node<Integer> head, int n) {
        // Base Condition
        if (head == null) {
            LOG.error("Empty Linked List");
            return null;
        }

        LinkedList.Node<Integer> mainPointer = head;
        LinkedList.Node<Integer> refPointer = null;

        // Increment mainPointer till counter reaches n
        for (int counter = 1; counter < n; counter++) {
            if (mainPointer != null) mainPointer = mainPointer.next;
        }

        while (mainPointer != null) {
            if (refPointer == null) {
                refPointer = head;
            } else {
                refPointer = refPointer.next;
            }
            mainPointer = mainPointer.next;
        }

        if (refPointer != null) {
            return refPointer;
        }
        return null;
    }

    /**
     * Find Nth Element from the end by first computing size of the linked list and then get Nth element based on Size - n + 1
     *
     * @param head head of the linked list
     * @param n    nth position
     * @return Node at Nth position if exists or null
     */
    public LinkedList.Node<Integer> findV2(LinkedList.Node<Integer> head, int n) {
        // Base Condition
        if (head == null) {
            LOG.error("Empty Linked List");
            return null;
        }

        // Calculate size of the linked list
        LinkedList.Node<Integer> temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        if (size < n) {
            LOG.error("Invalid node position requested");
            return null;
        } else {
            int counter = 0;
            temp = head;
            while (temp != null && counter < n) {
                temp = temp.next;
                counter++;
            }
            return temp;
        }
    }

}
