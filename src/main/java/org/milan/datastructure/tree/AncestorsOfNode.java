package org.milan.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/print-ancestors-of-a-given-binary-tree-node-without-recursion/}
 *
 * @author Milan Rathod
 */
public class AncestorsOfNode {

    private static List<BinaryTree.Node> output;

    /**
     * Find all ancestors of a given node in binary tree
     * Recursive approach
     *
     * @param root    root of the tree
     * @param nodeKey node for which ancestors to be found
     * @return list of ancestors
     */
    public List<BinaryTree.Node> findAll(BinaryTree.Node root, int nodeKey) {

        output = new ArrayList<>();

        findAllUtil(root, nodeKey);

        return output;
    }

    private boolean findAllUtil(BinaryTree.Node root, int nodeKey) {
        // Base conditions
        if (root == null) {
            return false;
        }

        if (root.getKey() == nodeKey) {
            return true;
        }

        if (findAllUtil(root.getLeft(), nodeKey) || findAllUtil(root.getRight(), nodeKey)) {
            output.add(root);
            return true;
        }

        return false;
    }

    /**
     * Find all ancestors of a given node in binary tree
     * Iterative approach
     *
     * @param root    root of the tree
     * @param nodeKey node for which ancestors to be found
     * @return list of ancestors
     */
    public List<BinaryTree.Node> findAllIterative(BinaryTree.Node root, int nodeKey) {

        // Base condition
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        Stack<BinaryTree.Node> stack = new Stack<>();

        List<BinaryTree.Node> outputList = new ArrayList<>();

        // Traverse the complete tree in postorder way till we find the key
        while (true) {

            // Traverse the left side. While traversing push the nodes into stack
            // So that their right subtrees can traverse later
            while (root != null && root.key != nodeKey) {
                stack.push(root);
                root = root.getLeft();
            }

            // If node found, break the loop
            if (root != null && root.key == nodeKey) {
                break;
            }

            // Check if right subtree exist for the node at top
            // If not then pop the node cause we don't need it
            if (stack.peek().right == null) {
                root = stack.pop();

                // If popped node is right child of top, the remove top as well.
                // Left child must processed earlier
                while (!stack.isEmpty() && stack.peek().right == root) {
                    root = stack.pop();
                }
            }

            root = stack.empty() ? null : stack.peek().right;
        }

        while (!stack.isEmpty()) {
            outputList.add(stack.pop());
        }

        return outputList;
    }
}
