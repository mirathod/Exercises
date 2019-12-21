package org.milan.datastructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/}
 *
 * @author Milan Rathod
 */
public class VerticalSum {

    /**
     * Find vertical sum using in order recursive traversal
     *
     * @param root root of the tree
     * @return List of sums for each vertical level
     */
    public List<Integer> computeSum(BinaryTree.Node root) {
        // Base condition
        if (root == null) {
            throw new IllegalStateException("binary tree is empty");
        }

        Map<Integer, Integer> map = new HashMap<>();

        sumUtil(root, 0, map);

        return new ArrayList<>(map.values());
    }

    /**
     * Utility function to calculate vertical sum of each vertical lines
     *
     * @param root root of the tree
     * @param hd   horizontal distance
     * @param map  map to store key as horizontal distance and value as sum of vertical line
     */
    private void sumUtil(BinaryTree.Node root, int hd, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        // Traverse left subtree with horizontal distance as hd - 1
        sumUtil(root.getLeft(), hd - 1, map);

        // Update vertical sum for this horizontal distance
        int previousSum = map.get(hd) == null ? 0 : map.get(hd);
        map.put(hd, previousSum + root.getKey());

        // Traverse right subtree with horizontal distance as hd + 1
        sumUtil(root.getRight(), hd + 1, map);
    }
}
