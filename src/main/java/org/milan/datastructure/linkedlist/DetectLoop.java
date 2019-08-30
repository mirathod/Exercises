package org.milan.datastructure.linkedlist;

/**
 * Problem: refer {@link @https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/}
 *
 * @author Milan Rathod
 */
public class DetectLoop {

    /**
     * Check if loop exists in linked list and return starting point of the loop
     *
     * @param head head of the linked list
     * @return starting node of the loop
     */
    public LinkedList.Node<Integer> detect(LinkedList.Node<Integer> head) {
        LinkedList.Node<Integer> fastPointer = head;
        LinkedList.Node<Integer> slowPointer = head;

        boolean loopExists = false;

        // Check if loop exists or not
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                loopExists = true;
                break;
            }
        }

        if (loopExists) {
            slowPointer = head;
            while (slowPointer != fastPointer) {
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
            return fastPointer;
        }
        return null;
    }

}
