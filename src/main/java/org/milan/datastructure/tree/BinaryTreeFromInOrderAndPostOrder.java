package org.milan.datastructure.tree;

/**
 * Problem: refer {@link @https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/}
 *
 * @author Milan Rathod
 */
public class BinaryTreeFromInOrderAndPostOrder {

    private int postIndex;

    /**
     * Construct binary tree from given in order and post order traversals
     *
     * @param inOrder   character array of in order traversal
     * @param postOrder character array of post order traversal
     * @return root of constructed binary tree
     */
    public TreeNode<Character> buildTree(char[] inOrder, char[] postOrder) {
        if (inOrder.length == 0 || inOrder.length != postOrder.length) {
            throw new IllegalArgumentException("Given inorder and postorder traversal is incorrect");
        }
        postIndex = postOrder.length - 1;
        return buildRecursive(inOrder, postOrder, 0, inOrder.length - 1);
    }

    /**
     * Recursive function to create binary tree from in order and post order traversals
     *
     * @param inOrder   character array of in order traversal
     * @param inStart   start index of in order traversal array
     * @param inEnd     end index of in order traversal array
     * @param postOrder character array of post order traversal
     * @return root of constructed binary tree
     */
    private TreeNode<Character> buildRecursive(char[] inOrder, char[] postOrder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        char data = postOrder[postIndex--];

        TreeNode<Character> current = new TreeNode<>(data);

        // If this node has no children then return
        if (inStart == inEnd) return current;

        int inIndex = search(inOrder, inStart, inEnd, data);

        current.right = buildRecursive(inOrder, postOrder, inIndex + 1, inEnd);
        current.left = buildRecursive(inOrder, postOrder, inStart, inIndex - 1);

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
