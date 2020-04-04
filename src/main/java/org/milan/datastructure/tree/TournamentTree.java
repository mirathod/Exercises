package org.milan.datastructure.tree;

/**
 * Problem: {@link @https://leetcode.com/discuss/interview-question/algorithms/125110/tournament-tree-problem}
 *
 * @author Milan Rathod
 */
public class TournamentTree {

    /**
     * Time complexity: O(logn)
     * Space complexity: O(logn) for recursive call stack
     *
     * @param root root of the tree
     * @return second minimum value in the tree
     */
    public int secondMin(BinaryTree.Node root) {

        // Base condition
        if (root.left == null || root.right == null) {
            return Integer.MAX_VALUE;
        }

        return root.left.key == root.key ? Math.min(root.right.key, secondMin(root.left)) :
                Math.min(root.left.key, secondMin(root.right));
    }
}
