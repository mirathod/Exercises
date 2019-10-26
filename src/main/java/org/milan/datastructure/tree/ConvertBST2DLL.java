package org.milan.datastructure.tree;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/}
 *
 * @author Milan Rathod
 */
public class ConvertBST2DLL {

    /**
     * Previous node pointer to point to previous visited nodel
     */
    private static BinarySearchTree.Node prev = null;

    private BinarySearchTree.Node head;

    /**
     * Convert binary search tree to doubly linked list
     *
     * @param root root of the tree
     * @return head node of doubly linked list
     */
    public BinarySearchTree.Node convert(BinarySearchTree.Node root) {
        convertUtil(root);
        return head;
    }

    /**
     * Utility function to convert binary search tree to doubly linked list
     *
     * @param root root of the tree
     */
    private void convertUtil(BinarySearchTree.Node root) {

        // Base condition
        if (root == null) {
            return;
        }

        // Visit left subtree
        convertUtil(root.left);

        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;

        // Visit right subtree
        convertUtil(root.right);
    }
}
