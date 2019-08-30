package org.milan.datastructure.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/clone-linked-list-next-random-pointer-o1-space/}
 *
 * @author Milan Rathod
 */
public class CloneList {

    /**
     * Clone linked list with the help of hash map
     *
     * @param originalHead head of an original linked list
     * @return cloned linked list
     */
    public DoublyLinkedList<Integer> clone(DoublyLinkedList.Node<Integer> originalHead) {
        Map<DoublyLinkedList.Node<Integer>, DoublyLinkedList.Node<Integer>> mapping = new HashMap<>();

        DoublyLinkedList.Node<Integer> originalCurrent = originalHead;

        DoublyLinkedList.Node<Integer> cloneCurrent = null;

        // Traverse original list and make a copy of that and store both in map
        while (originalCurrent != null) {
            cloneCurrent = new DoublyLinkedList.Node<>(originalCurrent.data);
            mapping.put(originalCurrent, cloneCurrent);
            originalCurrent = originalCurrent.next;
        }

        originalCurrent = originalHead;

        // Traverse the original list again and adjust clone list's next and random(i.e. prev) pointer
        while (originalCurrent != null) {
            cloneCurrent = mapping.get(originalCurrent);
            cloneCurrent.next = mapping.get(originalCurrent.next);
            cloneCurrent.prev = mapping.get(originalCurrent.prev);
            originalCurrent = originalCurrent.next;
        }

        return new DoublyLinkedList<>(mapping.get(originalHead));
    }

    /**
     * Create copy of first node and put it between first and second node and do this for remaining nodes
     * After this remove adjust random & next pointers of copied nodes and then separate copied and original nodes
     *
     * @param originalHead head of an original linked list
     * @return cloned linked list
     */
    public DoublyLinkedList<Integer> cloneV2(DoublyLinkedList.Node<Integer> originalHead) {
        DoublyLinkedList.Node<Integer> originalCurrent = originalHead;

        DoublyLinkedList.Node<Integer> temp = null;

        while (originalCurrent != null) {

            temp = originalCurrent.next;

            // Inserting new node
            originalCurrent.next = new DoublyLinkedList.Node<>(originalCurrent.data);
            originalCurrent.next.next = temp;
            originalCurrent = temp;
        }

        originalCurrent = originalHead;

        // Traverse the original list again and adjust random pointer of newly added nodes
        while (originalCurrent != null) {
            if (originalCurrent.next != null) {
                originalCurrent.next.prev = originalCurrent.prev != null ? originalCurrent.prev.next : originalCurrent.prev;
            }
            originalCurrent = (originalCurrent.next != null) ? originalCurrent.next.next : originalCurrent.next;
        }

        originalCurrent = originalHead;

        DoublyLinkedList.Node<Integer> clonedCurrent = originalHead.next;

        DoublyLinkedList.Node<Integer> clonedHead = clonedCurrent;

        // Separate original and clone lists
        while (originalCurrent != null && clonedCurrent != null) {
            originalCurrent.next = (originalCurrent.next != null) ? originalCurrent.next.next : originalCurrent.next;
            clonedCurrent.next = (clonedCurrent.next != null) ? clonedCurrent.next.next : clonedCurrent.next;
            originalCurrent = originalCurrent.next;
            clonedCurrent = clonedCurrent.next;
        }

        return new DoublyLinkedList<>(clonedHead);
    }
}
