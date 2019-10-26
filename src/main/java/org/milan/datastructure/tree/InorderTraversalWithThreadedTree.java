package org.milan.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/}
 *
 * @author Milan Rathod
 */
public class InorderTraversalWithThreadedTree {

    private List<Integer> store = new ArrayList<>();

    /**
     * Inorder traversal using morris method using threaded binary tree
     *
     * @param root root of the tree
     * @return list of inorder traversals
     */
    public List<Integer> traverse(BinaryTree.Node root) {
        BinaryTree.Node current, previous;

        // Base condition
        if (root == null) {
            throw new IllegalStateException("Binary tree is empty");
        }

        current = root;

        while (current != null) {

            if (current.left == null) {
                store.add(current.key);
                current = current.right;
            } else {

                // Find the inorder predecessor of the current
                previous = current.left;

                while (previous.right != null && previous.right != current) {
                    previous = previous.right;
                }

                // Make current as right child of its inorder predecessor
                if (previous.right == null) {
                    previous.right = current;
                    current = current.left;
                } else {
                    // Revert the changes made in if condition to restore original tree
                    // i.e. fix the right child of predecessor
                    previous.right = null;
                    store.add(current.key);
                    current = current.right;
                }
            }
        }

        return store;
    }
}
