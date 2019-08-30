package org.milan.datastructure.linkedlist;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/partitioning-a-linked-list-around-a-given-value-and-keeping-the-original-order/}
 *
 * @author Milan Rathod
 */
public class PartitionList {

    public LinkedList.Node<Integer> partition(LinkedList.Node<Integer> head, int K) {
        LinkedList.Node<Integer> root = new LinkedList.Node<>(0);
        LinkedList.Node<Integer> pivot = new LinkedList.Node<>(K);

        LinkedList.Node<Integer> rootNext = root;
        LinkedList.Node<Integer> pivotNext = pivot;

        LinkedList.Node<Integer> current = head;
        while (current != null) {
            LinkedList.Node<Integer> next = current.next;

            if (current.getData() >= K) {
                pivotNext.next = current;
                pivotNext = current;
                pivotNext.next = null;
            } else {
                rootNext.next = current;
                rootNext = current;
                rootNext.next = null;
            }
            current = next;
        }

        rootNext.next = pivot.next;
        return root.next;
    }
}
