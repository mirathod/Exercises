package org.milan.datastructure.tree;

/**
 * Problem: refer {@link @https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/}
 *
 * @author Milan Rathod
 */
public class BinaryTreeFromInOrderAndPreOrder {

    private int preIndex = 0;

    /**
     * Construct binary tree from given in order and pre order traversals
     *
     * @param inOrder  character array of in order traversal
     * @param preOrder character array of pre order traversal
     * @return root of constructed binary tree
     */
    public TreeNode<Character> buildTree(char[] inOrder, char[] preOrder) {
        if (inOrder.length == 0 || inOrder.length != preOrder.length) {
            throw new IllegalArgumentException("Given inorder and preorder traversal is incorrect");
        }
        return buildRecursive(inOrder, preOrder, 0, inOrder.length - 1);
    }

    /**
     * Recursive function to create binary tree from in order and pre order traversals
     *
     * @param inOrder  character array of in order traversal
     * @param inStart  start index of in order traversal array
     * @param inEnd    end index of in order traversal array
     * @param preOrder character array of pre order traversal
     * @return root of constructed binary tree
     */
    private TreeNode<Character> buildRecursive(char[] inOrder, char[] preOrder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        char data = preOrder[preIndex++];

        TreeNode<Character> current = new TreeNode<>(data);

        // If this node has no children then return
        if (inStart == inEnd) return current;

        int inIndex = search(inOrder, inStart, inEnd, data);

        current.left = buildRecursive(inOrder, preOrder, inStart, inIndex - 1);
        current.right = buildRecursive(inOrder, preOrder, inIndex + 1, inEnd);

        return current;
    }

    private int search(char[] arr, int start, int end, int data) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == data) {
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid traversal combination");
    }
}
