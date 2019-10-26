package org.milan.datastructure.tree;

/**
 * Problem: {@link @https://algorithms.tutorialhorizon.com/provide-the-next-siblings-pointers-in-a-given-binary-tree/}
 *
 * @author Milan Rathod
 */
public class NextSiblings {

    /**
     * Update next sibling link of all nodes in tree
     *
     * @param root root of the tree
     * @return updated root of the tree
     */
    public CustomNode updateSiblings(CustomNode root) {
        if (root != null) {

            // Left child of root is not null, update its sibling to point to right child
            if (root.left != null) {
                root.left.nextSibling = root.right;
            }

            // If root has any sibling and it's right child is non-empty
            // Point it to next sibling's left/right child (if left is null then point it to right child)
            if (root.right != null && root.nextSibling != null) {
                root.right.nextSibling = root.nextSibling.left != null ? root.nextSibling.left : root.nextSibling.right;
            }

            updateSiblings(root.left);
            updateSiblings(root.right);
            return root;
        }
        return null;
    }
}

class CustomNode {
    CustomNode left;

    CustomNode right;

    CustomNode nextSibling;

    int data;

    public CustomNode(int data) {
        this.data = data;
    }
}
