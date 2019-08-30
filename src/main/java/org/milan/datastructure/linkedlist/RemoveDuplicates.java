package org.milan.datastructure.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Remove duplicate nodes in linked list
 *
 * @author Milan Rathod
 */
public class RemoveDuplicates {

    /**
     * Remove duplicates in ascending sorted linked list
     *
     * @param head head of the linked list
     */
    public LinkedList.Node<Integer> removeDuplicatesSorted(LinkedList.Node<Integer> head) {
        LinkedList.Node<Integer> current = head;

        // Empty linked list
        if (current == null) return null;

        LinkedList.Node<Integer> next = current.next;

        while (next != null) {
            if (current.getData().equals(next.getData())) {
                current.next = next.next;
            } else {
                current = current.next;
            }
            next = next.next;
        }
        return head;
    }

    /**
     * Remove duplicate nodes in unsorted linked list
     *
     * @param head head of the linked list
     */
    public LinkedList.Node<Integer> removeDuplicatesUnsorted(LinkedList.Node<Integer> head) {

        if (head == null) return null;

        Set<Integer> store = new HashSet<>();

        LinkedList.Node<Integer> current = head;
        LinkedList.Node<Integer> previous = head;

        while (current != null) {
            if (!store.contains(current.data)) {
                store.add(current.data);
                previous = current;
            } else {
                previous.next = current.next;
            }
            current = current.next;
        }
        return head;
    }
}
