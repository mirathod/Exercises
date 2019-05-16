package org.milan.datastructure.binarysearchtree;

/**
 * Class containing left and right child of current node and key value
 *
 * @author Milan Rathod
 */
public class Node implements Comparable<Node> {

    public int key;

    public Node left;

    public Node right;

    Node(int key) {
        this.key = key;
        left = null;
        right = null;
    }

    public String toString() {
        return "" + this.key;
    }

    @Override
    public int compareTo(Node o) {
        return this.key - o.key;
    }
}
