package org.milan.datastructure.linkedlist;

/**
 * Problem: Merge two sorted linked lists
 *
 * @author Milan Rathod
 */
public class MergeLinkedLists {

    /**
     * Iterative approach
     *
     * @param head1 head of the first linked list
     * @param head2 head of the second linked list
     * @return head of merged linked list
     */
    public LinkedList.Node<Integer> mergeByIterative(LinkedList.Node<Integer> head1, LinkedList.Node<Integer> head2) {

        LinkedList.Node<Integer> current1 = head1;
        LinkedList.Node<Integer> current2 = head2;

        LinkedList.Node<Integer> temp;
        LinkedList.Node<Integer> tail;
        if (current1.data < current2.data) {
            temp = current1;
            current1 = current1.next;
        } else {
            temp = current2;
            current2 = current2.next;
        }

        tail = temp;
        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                temp.next = current1;
                current1 = current1.next;
            } else {
                temp.next = current2;
                current2 = current2.next;
            }
            temp = temp.next;
        }
        if (null == current1) {
            temp.next = current2;
        } else {
            temp.next = current1;
        }
        return tail;
    }

    /**
     * Recursive approach
     *
     * @param head1 head of the first linked list
     * @param head2 head of the second linked list
     * @return head of merged linked list
     */
    public LinkedList.Node<Integer> mergeByRecursive(LinkedList.Node<Integer> head1, LinkedList.Node<Integer> head2) {

        // If either of linked list is null return other linked list
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        LinkedList.Node<Integer> current;

        if (head1.data < head2.data) {
            current = head1;
            current.next = mergeByRecursive(head1.next, head2);
        } else {
            current = head2;
            current.next = mergeByRecursive(head1, head2.next);
        }

        return current;
    }
}
