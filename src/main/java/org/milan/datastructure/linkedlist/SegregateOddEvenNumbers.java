package org.milan.datastructure.linkedlist;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/}
 *
 * @author Milan Rathod
 */
public class SegregateOddEvenNumbers {

    /**
     * Traverse the linked list and append even and odd nodes to even and odd temp
     * lists respectively. point next pointer of last node of even list to head of
     * odd list and point last node of odd list to null
     * <p>
     * Time complexity: O(n)
     *
     * @param head head pointer of linked list
     * @return new head after segregation
     */
    public LinkedList.Node<Integer> segregate(LinkedList.Node<Integer> head) {
        // Base condition
        if (head == null) {
            throw new IllegalStateException("linked list is empty");
        }

        LinkedList.Node<Integer> evenStart = null;
        LinkedList.Node<Integer> evenEnd = null;
        LinkedList.Node<Integer> oddStart = null;
        LinkedList.Node<Integer> oddEnd = null;
        LinkedList.Node<Integer> current = head;

        while (current != null) {
            int data = current.data;

            if (data % 2 == 0) {

                // If even list is empty, set evenStart
                if (evenStart == null) {
                    evenStart = current;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } else {

                // If odd list is empty, set oddStart
                if (oddStart == null) {
                    oddStart = current;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }

            current = current.next;
        }

        // Merge two lists only when both have some elements otherwise no merging is required
        if (oddStart != null && evenStart != null) {
            evenEnd.next = oddStart;
            oddEnd.next = null;
            head = evenStart;
        }

        return head;
    }
}
