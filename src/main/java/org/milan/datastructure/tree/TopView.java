package org.milan.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/}
 *
 * @author Milan Rathod
 */
public class TopView {

    private VerticalTraversal verticalTraversal;

    public TopView() {
        verticalTraversal = new VerticalTraversal();
    }

    /**
     * Find top view of binary tree using vertical traversal
     *
     * @param root root of the tree
     * @return list of integers of top view
     */
    public List<Integer> find(BinaryTree.Node root) {

        // Store horizontal distance as key and value as list of nodes
        Map<Integer, List<BinaryTree.Node>> map = new TreeMap<>();

        verticalTraversal.traverseUtil(root, map);

        List<Integer> outIntegerList = new ArrayList<>();

        map.forEach((integer, nodes) -> {
            outIntegerList.add(nodes.get(0).key);
        });

        return outIntegerList;
    }
}
