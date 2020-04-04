package org.milan.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Tree with basic operations
 *
 * @author Milan Rathod
 */
public class BinaryTree {

    /**
     * root of the binary tree
     */
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int rootKey) {
        this.root = new Node(rootKey);
    }

    public Node getRoot() {
        return root;
    }

    /**
     * Find Maximum element in given tree
     *
     * @param root root of the tree
     * @return maximum node key
     */
    public int findMaximumElement(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int max = root.key;
        int leftMax = findMaximumElement(root.left);
        int rightMax = findMaximumElement(root.right);

        if (leftMax > max) {
            max = leftMax;
        }

        if (rightMax > max) {
            max = rightMax;
        }

        return max;
    }

    /**
     * Find Maximum element in given tree iterative approach
     *
     * @param root root of the tree
     * @return maximum node key
     */
    public int findMaximumElementIterative(Node root) {
        // Base condition
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        Queue<Node> queue = new LinkedList<>();

        Node temp = root;

        queue.offer(temp);

        int maxElement = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {

            temp = queue.poll();

            if (temp.key > maxElement) {
                maxElement = temp.key;
            }

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
        return maxElement;
    }

    /**
     * Find Minimum element in given tree
     *
     * @param root root of the tree
     * @return minimum node key
     */
    public int findMinimumElement(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int min = root.key;
        int leftMin = findMinimumElement(root.left);
        int rightMin = findMinimumElement(root.right);

        if (leftMin < min) {
            min = leftMin;
        }

        if (rightMin < min) {
            min = rightMin;
        }

        return min;
    }

    /**
     * check if node with given key is present in tree
     *
     * @param root root of the tree
     * @param key  node key
     * @return true if present otherwise false
     */
    public boolean isPresent(Node root, int key) {
        // Base condition
        if (root == null) {
            return false;
        }

        if (root.key == key) {
            return true;
        }
        return isPresent(root.left, key) || isPresent(root.right, key);
    }

    /**
     * check if node with given key is present in tree iterative approach
     *
     * @param root root of the tree
     * @param key  node key
     * @return true if present otherwise false
     */
    public boolean isPresentIterative(Node root, int key) {
        // Base condition
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        Queue<Node> queue = new LinkedList<>();

        Node temp = root;

        queue.offer(temp);

        while (!queue.isEmpty()) {

            temp = queue.poll();

            if (temp.key == key) {
                return true;
            }

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
        return false;
    }

    /**
     * Get Mirror Tree of a tree - Recursive approach
     *
     * @param root root of a tree
     * @return root of a mirror tree
     */
    public Node mirrorTree(Node root) {

        // Base condition
        if (root == null) {
            return null;
        }

        // Mirror of left sub tree
        mirrorTree(root.left);

        // Mirror of right sub tree
        mirrorTree(root.right);

        // Swap left and right children
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    /**
     * Get Mirror Tree of a tree - Iterative approach
     *
     * @param root root of a tree
     * @return root of a mirror tree
     */
    public void mirrorTreeIterative(Node root) {

        // Base condition
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        // Do BFS. While doing BFS, keep swapping left and right children
        while (!queue.isEmpty()) {

            // Pop top node from queue
            Node current = queue.poll();

            Node temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Push left and right children
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    /**
     * @param src    root of source tree
     * @param target root of target tree
     * @return true if identical otherwise false
     */
    public boolean isIdentical(Node src, Node target) {
        // Both the nodes are empty
        if (src == null && target == null) {
            return true;
        }

        // If only one is empty
        if (src == null || target == null) {
            return false;
        }

        // Both the nodes are non-empty
        return (src.key == target.key
                && isIdentical(src.left, target.left)
                && isIdentical(src.right, target.right));
    }

    /**
     * @param src    root of source tree
     * @param target root of target tree
     * @return true if both trees are mirror of each other otherwise false
     */
    public boolean isMirror(Node src, Node target) {
        // Both the nodes are empty
        if (src == null && target == null) {
            return true;
        }

        // If only one is empty
        if (src == null || target == null) {
            return false;
        }

        // Both the nodes are non-empty
        return (src.key == target.key
                && isMirror(src.left, target.right)
                && isMirror(src.right, target.left));
    }

    static class Node {
        int key;

        Node left;

        Node right;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public String toString() {
            return "" + this.key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key;
        }
    }
}
