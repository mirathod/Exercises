package org.milan.datastructure.tree;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/}
 *
 * @author Milan Rathod
 */
public class SumTree {

    /**
     * Check if given tree is sum tree - recursive approach
     * <p>
     * Time complexity: O(n*n)
     *
     * @param root root of the tree
     * @return true if given tree is sub tree otherwise false
     */
    public boolean isSumTree(BinaryTree.Node root) {

        // If node is null or it's leaf node then return true
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        // Calculate sum of left and right subtrees
        int leftSubTree = sum(root.left);
        int rightSubTree = sum(root.right);

        return (root.key == leftSubTree + rightSubTree) && isSumTree(root.left) && isSumTree(root.right);
    }

    /**
     * Check if given tree is sum tree - recursive optimized approach
     * <p>
     * Time complexity: O(n)
     *
     * @param root root of the tree
     * @return true if given tree is sub tree otherwise false
     */
    public boolean isSumTreeV2(BinaryTree.Node root) {
        return isSumTreeUtil(root) != 0;
    }

    /**
     * Check if given tree is sum tree - recursive optimized approach
     * <p>
     * Time complexity: O(n)
     *
     * @param root root of the tree
     * @return non-zero sum if sum tree otherwise zero
     */
    private int isSumTreeUtil(BinaryTree.Node root) {

        // If node's leaf node then return true
        if (root.left == null && root.right == null) {
            return root.key;
        }

        // Calculate sum of left and right subtrees
        int leftSum = root.left != null ? isSumTreeUtil(root.left) : 0;
        int rightSum = root.right != null ? isSumTreeUtil(root.right) : 0;

        return root.key == leftSum + rightSum ? leftSum + rightSum + root.key : 0;
    }

    /**
     * @param node node for which sum to be calculated
     * @return sum of node, left and right children
     */
    private int sum(BinaryTree.Node node) {
        if (node == null)
            return 0;
        return sum(node.left) + node.key + sum(node.right);
    }
}
