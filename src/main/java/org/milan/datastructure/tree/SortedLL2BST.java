package org.milan.datastructure.tree;

import org.milan.datastructure.linkedlist.LinkedList;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/}
 *
 * @author Milan Rathod
 */
public class SortedLL2BST {

    private LinkedList.Node<Integer> head;

    /**
     * Convert sorted singly linked list to balanced binary search tree
     *
     * @param count total nodes in linked list
     * @param head  head of the linked list
     * @return root of the tree
     */
    public BinarySearchTree.Node convert(LinkedList.Node<Integer> head, int count) {

        // Base condition
        if (head == null) {
            throw new IllegalStateException("Linked list is empty");
        }

        this.head = head;

        return convertUtil(count);
    }

    /**
     * Utility function to convert sorted singly linked list to balanced binary search tree
     *
     * @param count total nodes in linked list
     * @return root of the tree
     */
    private BinarySearchTree.Node convertUtil(int count) {

        // Base condition
        if (count <= 0) {
            return null;
        }

        //
        BinarySearchTree.Node left = convertUtil(count / 2);

        BinarySearchTree.Node root = new BinarySearchTree.Node(head.getData());

        root.left = left;

        head = head.getNext();

        root.right = convertUtil(count - count / 2 - 1);

        return root;
    }
}
