package org.milan.datastructure.tree;

/**
 * Generic Tree node class
 *
 * @author Milan Rathod
 */
public class TreeNode<T> {

    T key;

    TreeNode<T> left;

    TreeNode<T> right;

    TreeNode(T key) {
        this.key = key;
        left = null;
        right = null;
    }
}
