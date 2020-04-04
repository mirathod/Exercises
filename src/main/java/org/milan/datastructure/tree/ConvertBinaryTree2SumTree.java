package org.milan.datastructure.tree;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/}
 *
 * @author Milan Rathod
 */
public class ConvertBinaryTree2SumTree {

    /**
     * Convert binary tree to sum tree
     *
     * @param root root of the tree
     */
    public int convert(BinaryTree.Node root) {
        if (root == null) {
            return 0;
        }

        // Store the old value
        int oldValue = root.key;

        // Recursively call for left and right sub tree and store sum as new node value
        root.key = convert(root.left) + convert(root.right);

        // Return sum of left and right subtrees and old value
        return oldValue + root.key;
    }
}
