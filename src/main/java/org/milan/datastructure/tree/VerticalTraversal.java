package org.milan.datastructure.tree;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/print-binary-tree-vertical-order/}
 * <p>
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 *
 * @author Milan Rathod
 */
public class VerticalTraversal {

    /**
     * Vertical traversal of given tree using level order traversal
     *
     * @param root root of the binary tree
     * @return list of strings of vertical traversal
     */
    public List<String> traverse(BinaryTree.Node root) {

        // Store horizontal distance as key and value as list of nodes
        Map<Integer, List<BinaryTree.Node>> map = new TreeMap<>();

        traverseUtil(root, map);

        List<String> outIntegerList = new ArrayList<>();

        map.forEach((integer, nodes) -> outIntegerList.add(nodes.toString()));

        return outIntegerList;
    }

    /**
     * Utility function to perform actual vertical traversal and store the results in map
     */
    public void traverseUtil(BinaryTree.Node root, Map<Integer, List<BinaryTree.Node>> map) {
        // Base case
        if (root == null) {
            return;
        }

        int hd = 0;

        Queue<Pair<BinaryTree.Node, Integer>> queue = new ArrayDeque<>();

        queue.add(ImmutablePair.of(root, hd));

        while (!queue.isEmpty()) {
            Pair<BinaryTree.Node, Integer> current = queue.poll();

            hd = current.getValue();

            root = current.getKey();

            List<BinaryTree.Node> nodeList = map.get(hd);

            if (nodeList == null) {
                nodeList = new ArrayList<>();
            }
            nodeList.add(root);

            map.put(hd, nodeList);

            if (root.left != null) {
                queue.add(ImmutablePair.of(root.left, hd - 1));
            }

            if (root.right != null) {
                queue.add(ImmutablePair.of(root.right, hd + 1));
            }
        }
    }

}
