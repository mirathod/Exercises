package org.milan.datastructure.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/}
 *
 * @author Milan Rathod
 */
public class MiddleElement {

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(MiddleElement.class);

    /**
     * Find Middle element in linked list using two pointers with
     * one pointer moving twice fast to other pointer
     *
     * @param head head of the linked list
     * @return middle element or null if linked list is empty
     */
    public LinkedList.Node<Integer> find(LinkedList.Node<Integer> head) {

        // Base condition
        if (head == null) {
            LOG.error("Linkedlist is empty");
            return null;
        }

        LinkedList.Node<Integer> slow = head;
        LinkedList.Node<Integer> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * Find Middle element in linked list using mid pointer moving based on counter value
     *
     * @param head head of the linked list
     * @return middle element or null if linked list is empty
     */
    public LinkedList.Node<Integer> findV2(LinkedList.Node<Integer> head) {

        // Base condition
        if (head == null) {
            LOG.error("Linkedlist is empty");
            return null;
        }

        LinkedList.Node<Integer> mid = head;

        int counter = 0;

        while (head != null) {

            if (counter % 2 != 0) {
                mid = mid.next;
            }

            counter++;
            head = head.next;
        }
        return mid;
    }

}
