package org.milan.datastructure.linkedlist;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/}
 *
 * @author Milan Rathod
 */
public class NthNodeFromEnd {

    public LinkedList.Node find(LinkedList.Node head, int n) {

        // Base Conditions
        if (head == null) {
            System.out.println("Empty Linked List");
            return null;
        }

        LinkedList.Node temp = head;
        LinkedList.Node output = null;

        int counter = 0;

        while (temp != null) {

            counter++;

            if (counter == n) {
                output = head;
            } else if (counter > n) {
                output = output.next;
            }

            temp = temp.next;
        }

        return output;
    }
}
