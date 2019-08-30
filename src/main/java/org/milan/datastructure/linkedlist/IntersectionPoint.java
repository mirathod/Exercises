package org.milan.datastructure.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem: refer {@link @https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/}
 *
 * @author Milan Rathod
 */
public class IntersectionPoint {

    private static final Logger LOG = LoggerFactory.getLogger(IntersectionPoint.class);

    public LinkedList.Node<Integer> find(LinkedList.Node<Integer> head1, LinkedList.Node<Integer> head2) {

        // Base condition
        if (head1 == null || head2 == null) {
            LOG.error("One of the linked list is empty");
            return null;
        }

        // Compute size of both linked lists
        int size1 = computeSize(head1);
        int size2 = computeSize(head2);

        int diff;

        if (size1 > size2) {
            diff = size1 - size2;
            while (diff > 0) {
                head1 = head1.next;
                diff--;
            }
        } else {
            diff = size2 - size1;
            while (diff > 0) {
                head2 = head2.next;
                diff--;
            }
        }

        while (head1 != null && head2 != null) {
            if (head1.equals(head2)) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    /**
     * Calculate size of the linked list
     *
     * @param head head of the linked list
     * @return size of the linked list
     */
    private int computeSize(LinkedList.Node<Integer> head) {
        LinkedList.Node<Integer> temp = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }
}
