package org.milan.datastructure.linkedlist;

/**
 * Problem: Rotate a given singly linked list by k places
 * i.e. input = 1 -> 2 -> 3 -> 4 -> 5 -> null and k = 2
 * output = 4 -> 5 -> 1 -> 2 -> 3 -> null
 *
 * @author Milan Rathod
 */
public class RotateList {

    /**
     * rotate right by k places
     *
     * @param head head of the linked list
     * @param k    number of places
     * @return new head after rotation
     */
    public LinkedList.Node<Integer> rotate(LinkedList.Node<Integer> head, int k) {

        // Base condition
        if (head == null || head.next == null) {
            return head;
        }

        LinkedList.Node<Integer> rotateStart = head;
        LinkedList.Node<Integer> rotateEnd = head;

        // Adjust rotateEnd to point to node after k places
        while (k-- > 0) {
            rotateEnd = rotateEnd.next;
            if (rotateEnd == null) {
                rotateEnd = head;
            }
        }

        // Return head if rotation places are same as number of nodes
        if (rotateStart == rotateEnd) {
            return head;
        }

        // Adjust rotateStart to point to node from which rotation will start
        while (rotateEnd.next != null) {
            rotateStart = rotateStart.next;
            rotateEnd = rotateEnd.next;
        }

        LinkedList.Node<Integer> temp = rotateStart.next;
        rotateEnd.next = head;
        rotateStart.next = null;
        return temp;
    }
}
