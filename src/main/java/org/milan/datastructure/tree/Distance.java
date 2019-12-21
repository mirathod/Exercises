package org.milan.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/}
 *
 * @author Milan Rathod
 */
public class Distance {

    private List<Integer> output = new ArrayList<>();

    public List<Integer> findDistance(BinaryTree.Node root, BinaryTree.Node target, int k) {

        distanceUtil(root, target, k);

        return output;
    }

    /**
     * Utility function to store all nodes at distance k from given nodes
     * <p>
     * The k distance nodes may be upward or downward.
     * This function return -1 if target node is not present in tree rooted with root otherwise
     * returns distance of root from target node
     *
     * @param root   root of the tree
     * @param target target node
     * @param k      distance
     */
    private int distanceUtil(BinaryTree.Node root, BinaryTree.Node target, int k) {

        // Base case
        if (root == null) {
            return -1;
        }

        // If target is same as root, use downward method to print all nodes at distance k
        // in subtree rooted with target or root
        if (root == target) {
            downDistance(root, k);
            return 0;
        }

        // Recur for left subtree
        int leftDistance = distanceUtil(root.left, target, k);

        // Check if target node was found in left subtree
        if (leftDistance != -1) {

            // If root is at distance k from target store root
            // leftDistance is distance of root's left child from target
            if (leftDistance + 1 == k) {
                output.add(root.key);
            } else {
                // Go to right subtree and print all k - leftDistance - 2 distance nodes
                // right child is 2 edges away from left child
                downDistance(root.right, k - leftDistance - 2);
            }

            // Add 1 to the distance and return value for parent calls
            return 1 + leftDistance;
        }

        // Recur for right subtree
        int rightDistance = distanceUtil(root.right, target, k);

        // Check if target node was found in right subtree
        if (rightDistance != -1) {
            if (rightDistance + 1 == k) {
                output.add(root.key);
            } else {
                downDistance(root.left, k - rightDistance - 2);
            }

            return 1 + rightDistance;
        }

        // If target is neither present in left nor in right subtree
        return -1;
    }

    /**
     * Recursive function to store all the nodes at distance k in tree (or subtree)
     * rooted with given root
     *
     * @param root root of the tree
     * @param k    distance
     */
    private void downDistance(BinaryTree.Node root, int k) {
        // Base case
        if (root == null || k < 0) {
            return;
        }

        // If we reach k distance node, add it to result
        if (k == 0) {
            output.add(root.key);
            return;
        }

        // Recur left and right subtree
        downDistance(root.left, k - 1);
        downDistance(root.right, k - 1);
    }

}
