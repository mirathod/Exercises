package org.milan.datastructure.tree;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/}
 *
 * @author Milan Rathod
 */
public class Cousins {

    /**
     * This approach first find level of first and second nodes and check if both are same
     * After that check if both are not siblings
     *
     * @param root   root of the binary tree
     * @param first  first node
     * @param second second node
     * @return true if first and second nodes are cousins otherwise false
     */
    public boolean isCousins(BinaryTree.Node root, BinaryTree.Node first, BinaryTree.Node second) {
        return level(root, first, 1) == level(root, second, 1) && !isSiblings(root, first, second);
    }

    private int level(BinaryTree.Node root, BinaryTree.Node node, int level) {

        // Base case
        if (root == null) {
            return 0;
        }

        if (root.equals(node)) {
            return level;
        }

        int l = level(root.left, node, level + 1);
        if (l != 0) {
            return l;
        }
        return level(root.right, node, level + 1);
    }

    private boolean isSiblings(BinaryTree.Node root, BinaryTree.Node first, BinaryTree.Node second) {

        // Base case
        if (root == null) {
            return false;
        }

        return (root.left != null && root.left.equals(first) && root.right != null && root.right.equals(second)) ||
                (root.left != null && root.left.equals(second) && root.right != null && root.right.equals(first)) ||
                isSiblings(root.left, first, second) || isSiblings(root.right, first, second);
    }

    /**
     * This approach uses level order traversal
     *
     * @param root   root of the binary tree
     * @param first  first node
     * @param second second node
     * @return true if first and second nodes are cousins otherwise false
     */
    public boolean isCousinsV2(BinaryTree.Node root, BinaryTree.Node first, BinaryTree.Node second) {

        // Parent of first node
        BinaryTree.Node firstParent = null;

        // Parent of second node
        BinaryTree.Node secondParent = null;

        // Queue used for performing level order traversal
        // Each element of queue is pair of node and parent node
        Queue<Pair<BinaryTree.Node, BinaryTree.Node>> queue = new LinkedList<>();

        // Add root and some dummy node as its parent to queue
        queue.add(ImmutablePair.of(root, new BinaryTree.Node(-1)));

        while (!queue.isEmpty()) {

            int level = queue.size();

            while (level != 0) {
                Pair<BinaryTree.Node, BinaryTree.Node> node = queue.poll();

                // Check if current node is first/second node
                if (node.getKey().key == first.key) {
                    firstParent = node.getValue();
                }

                if (node.getKey().key == second.key) {
                    secondParent = node.getValue();
                }

                if (node.getKey().left != null) {
                    queue.add(ImmutablePair.of(node.getKey().left, node.getKey()));
                }

                if (node.getKey().right != null) {
                    queue.add(ImmutablePair.of(node.getKey().right, node.getKey()));
                }

                level--;

                // If both nodes are found in current level then no need to traverse further
                if (firstParent != null && secondParent != null) {
                    break;
                }
            }

            // Check if both nodes are not siblings
            if (firstParent != null && secondParent != null) {
                return firstParent != secondParent;
            }

            if (firstParent != null || secondParent != null) {
                return false;
            }

        }

        return false;
    }
}
