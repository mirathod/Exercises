package org.milan.datastructure.tree;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/construct-a-special-tree-from-given-preorder-traversal/}
 *
 * @author Milan Rathod
 */
public class SpecialPreOrderTraversal {

    /**
     * Construct binary tree from given preorder traversal and special preorder traversal
     *
     * @param pre   preorder traversal of tree
     * @param preLN special preorder traversal of tree with L denotes leaf node and N denotes non-leaf node
     * @param root  root of the tree
     * @return root of the newly constructed tree
     */
    public BinaryTree.Node constructTree(int[] pre, char[] preLN, BinaryTree.Node root) {
        return constructTreeUtil(pre, preLN, new Index(), pre.length, root);
    }

    /**
     * Utility function to construct binary tree from given set of parameters
     */
    private BinaryTree.Node constructTreeUtil(int[] pre, char[] preLN, Index index, int size, BinaryTree.Node temp) {
        int pre_index = index.pre_index;

        // If pre_index is equal to size return
        if (pre_index == size) {
            return null;
        }

        // Create new node from array of preorder traversal
        temp = new BinaryTree.Node(pre[pre_index]);

        // Increment pre_index of given Index object
        (index.pre_index)++;

        // If current node is not leaf node then recursively find left and right children of it
        if (preLN[pre_index] == 'N') {
            temp.left = constructTreeUtil(pre, preLN, index, size, temp.left);
            temp.right = constructTreeUtil(pre, preLN, index, size, temp.right);
        }
        return temp;
    }
}

class Index {
    int pre_index = 0;
}
