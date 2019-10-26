package org.milan.hackerearth;

import org.milan.datastructure.tree.BinarySearchTree;

/**
 * Monk Watching Fight - Binary Search Tree
 *
 * @author Milan Rathod
 */
public class MonkWatchingFight {

    public int heightOfBST(int size, int[] arr) {

        BinarySearchTree binarySearchTree = new BinarySearchTree(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            binarySearchTree.insert(arr[i]);
        }

        return binarySearchTree.height(binarySearchTree.getRoot());

    }

}
