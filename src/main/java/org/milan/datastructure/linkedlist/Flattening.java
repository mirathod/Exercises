package org.milan.datastructure.linkedlist;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/flattening-a-linked-list/}
 *
 * @author Milan Rathod
 */
public class Flattening {

    public Node<Integer> flatten(Node<Integer> head) {

        // Base case
        if (head == null || head.right == null) {
            return head;
        }

        // Recur for list on right
        head.right = flatten(head.right);

        // Now Merge
        head = merge(head, head.right);

        // Return the head and it will be in turn merged with its left
        return head;
    }

    /**
     * Merge two linked list
     *
     * @param head1 head of the first linked list
     * @param head2 head of the second linked list
     * @return head of merged linked list
     */
    private Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {

        // If either of linked list is null return other linked list
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node<Integer> current;

        if (head1.data < head2.data) {
            current = head1;
            current.down = merge(head1.down, head2);
        } else {
            current = head2;
            current.down = merge(head1, head2.down);
        }

        return current;
    }

    static class Node<T> {
        T data;
        Node<T> right;
        Node<T> down;

        Node(T data) {
            this.data = data;
            right = null;
            down = null;
        }
    }
}


