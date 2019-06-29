package org.milan.datastructure.linkedlist;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/}
 *
 * @author Milan Rathod
 */
public class MiddleElement {

    public LinkedList.Node find(LinkedList.Node head) {

        // Base condition
        if (head == null) {
            System.out.println("Empty LinkedList");
            return null;
        }

        LinkedList.Node slow = head;
        LinkedList.Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public LinkedList.Node findV2(LinkedList.Node head) {

        // Base condition
        if (head == null) {
            System.out.println("Empty LinkedList");
            return null;
        }

        LinkedList.Node mid = head;

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
