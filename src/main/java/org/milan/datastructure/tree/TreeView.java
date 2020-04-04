package org.milan.datastructure.tree;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Different views of binary tree
 * <p>
 * i.e. left view, top view, right view and bottom view
 *
 * @author Milan Rathod
 */
public class TreeView {

    /**
     * Maximum level being used in left view
     */
    private int leftViewMaxLevel = 0;

    /**
     * Maximum level being used in right view
     */
    private int rightViewMaxLevel = 0;

    /**
     * Problem: {@link @https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/}
     * <p>
     * Get all visible nodes when binary tree is visited from top view
     *
     * @param root root of the tree
     * @return list of node keys visible from top view
     */
    public List<Integer> topView(BinaryTree.Node root) {

        // TODO check if we can move this statement to constructor
        VerticalTraversal verticalTraversal = new VerticalTraversal();

        // Store horizontal distance as key and value as list of nodes
        Map<Integer, List<BinaryTree.Node>> map = new TreeMap<>();

        verticalTraversal.traverseUtil(root, map);

        List<Integer> outIntegerList = new ArrayList<>();

        map.forEach((integer, nodes) -> {
            outIntegerList.add(nodes.get(0).key);
        });

        return outIntegerList;
    }

    /**
     * Problem: {@link @https://www.geeksforgeeks.org/iterative-method-to-print-left-view-of-a-binary-tree/}
     * <p>
     * Get all visible nodes when binary tree is visited from left view
     *
     * @param root root of the binary tree
     * @return list of node keys visible from left view
     */
    public List<Integer> leftView(BinaryTree.Node root) {

        // Base condition
        if (root == null) {
            return null;
        }

        List<Integer> outputList = new ArrayList<>();

        Queue<BinaryTree.Node> queue = new LinkedList<>();

        // Add root to the queue
        queue.add(root);

        // Add delimiter
        queue.add(null);

        while (!queue.isEmpty()) {

            // Peek first element in the queue
            BinaryTree.Node current = queue.peek();

            if (current != null) {

                // This is the first node in the level
                outputList.add(current.key);

                while (queue.peek() != null) {

                    // Add left child to the queue if present
                    if (current.left != null) {
                        queue.add(current.left);
                    }

                    // Add right child to the queue if present
                    if (current.right != null) {
                        queue.add(current.right);
                    }

                    // Remove the current node
                    queue.remove();

                    current = queue.peek();
                }

                // Add delimiter for the next level
                queue.add(null);
            }

            // Remove the delimiter of previous level
            queue.remove();
        }

        return outputList;
    }

    /**
     * Problem: {@link @https://www.geeksforgeeks.org/print-left-view-binary-tree/}
     * <p>
     * Get all visible nodes when binary tree is visited from left view - Recursive approach
     *
     * @param root root of the binary tree
     * @return list of node keys visible from right view
     */
    public List<Integer> leftViewRecursive(BinaryTree.Node root) {

        List<Integer> outputList = new ArrayList<>();

        leftViewUtil(root, 1, outputList);

        return outputList;
    }

    /**
     * Recursive function for left view
     *
     * @param root       root of the binary tree
     * @param level      current level of tree
     * @param outputList list of node keys visible from left view
     */
    private void leftViewUtil(BinaryTree.Node root, int level, List<Integer> outputList) {

        // Base case
        if (root == null)
            return;

        // If this is first node of its level
        if (leftViewMaxLevel < level) {
            outputList.add(root.key);
            leftViewMaxLevel = level;
        }

        // Recur for left and right subtree
        leftViewUtil(root.left, level + 1, outputList);
        leftViewUtil(root.right, level + 1, outputList);
    }

    /**
     * Problem: {@link @https://www.geeksforgeeks.org/right-view-binary-tree-using-queue/}
     * <p>
     * Get all visible nodes when binary tree is visited from right view
     *
     * @param root root of the binary tree
     * @return list of node keys visible from right view
     */
    public List<Integer> rightView(BinaryTree.Node root) {

        // Base condition
        if (root == null) {
            return null;
        }

        List<Integer> outputList = new ArrayList<>();

        Queue<BinaryTree.Node> queue = new LinkedList<>();

        // Add root to the queue
        queue.add(root);

        while (!queue.isEmpty()) {

            // Peek first element in the queue
            BinaryTree.Node current = queue.peek();

            // This is the first node in the level
            outputList.add(current.key);

            int size = queue.size();

            for (int i = 1; i <= size; i++) {

                BinaryTree.Node temp = queue.poll();

                // Add right child to the queue if present
                if (temp.right != null) {
                    queue.add(temp.right);
                }

                // Add left child to the queue if present
                if (temp.left != null) {
                    queue.add(temp.left);
                }

            }

        }

        return outputList;
    }

    /**
     * Problem: {@link @https://www.geeksforgeeks.org/print-right-view-binary-tree-2/}
     * <p>
     * Get all visible nodes when binary tree is visited from right view - Recursive approach
     *
     * @param root root of the binary tree
     * @return list of node keys visible from right view
     */
    public List<Integer> rightViewRecursive(BinaryTree.Node root) {

        List<Integer> outputList = new ArrayList<>();

        rightViewUtil(root, 1, outputList);

        return outputList;
    }


    /**
     * Recursive function for right view
     *
     * @param root       root of the binary tree
     * @param level      current level of tree
     * @param outputList list of node keys visible from right view
     */
    private void rightViewUtil(BinaryTree.Node root, int level, List<Integer> outputList) {

        // Base case
        if (root == null)
            return;

        // If this is first node of its level
        if (rightViewMaxLevel < level) {
            outputList.add(root.key);
            rightViewMaxLevel = level;
        }

        // Recur for right and left subtree
        rightViewUtil(root.right, level + 1, outputList);
        rightViewUtil(root.left, level + 1, outputList);
    }

    /**
     * Problem: {@link @https://www.geeksforgeeks.org/bottom-view-binary-tree/}
     * <p>
     * Get all visible nodes when binary tree is visited from bottom view - Recursive approach
     *
     * @param root root of the binary tree
     * @return list of node keys visible from bottom view
     */
    public List<Integer> bottomView(BinaryTree.Node root) {

        Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();

        bottomViewUtil(root, 0, 0, map);

        return map.values().stream().map(Pair::getLeft).collect(Collectors.toList());
    }


    /**
     * Recursive function for bottom view
     *
     * @param root  root of the binary tree
     * @param level level of the node
     * @param hd    horizontal distance
     * @param map   map of key as horizontal distance and value as pair of node key and it's level
     */
    private void bottomViewUtil(BinaryTree.Node root, int level, int hd, Map<Integer, Pair<Integer, Integer>> map) {

        // Base case
        if (root == null)
            return;

        // If node of a particular horizontal distance is not present add it to map
        if (!map.containsKey(hd)) {
            map.put(hd, ImmutablePair.of(root.key, level));
        } else {
            // Compare height for already present node at similar horizontal distance
            Pair<Integer, Integer> pair = map.get(hd);
            if (pair.getRight() <= level) {
                map.put(hd, ImmutablePair.of(root.key, level));
            }
        }

        // Recur for left subtree
        bottomViewUtil(root.left, level + 1, hd - 1, map);

        // Recur for right subtree
        bottomViewUtil(root.right, level + 1, hd + 1, map);
    }

}
