package org.milan.datastructure.tree;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/}
 *
 * @author Milan Rathod
 */
public class LowestCommonAncestor {

    /**
     * Find LCA of two given nodes
     *
     * @param root  root of the binary tree
     * @param node1 first node
     * @param node2 second node
     * @return LCA
     */
    public BinaryTree.Node findLCA(BinaryTree.Node root, int node1, int node2) {
        // Base condition
        if (root == null) {
            return null;
        }

        if (root.key == node1 || root.key == node2) {
            return root;
        }

        BinaryTree.Node left_LCA = findLCA(root.left, node1, node2);
        BinaryTree.Node right_LCA = findLCA(root.right, node1, node2);

        // If both left and right lca returns non-null then one key
        // is present in left subtree and one key is present in right subtree
        // so current node is LCA
        if (left_LCA != null && right_LCA != null) {
            return root;
        }

        // Otherwise check if left subtree or right subtree is LCA
        return left_LCA != null ? left_LCA : right_LCA;
    }
}
