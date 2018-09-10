package org.milan.datastructure.binarysearchtree;

/**
 * Add Description
 *
 * @author Milan Rathod
 * @since
 */
public class Node implements Comparable<Node> {
    public int key;
    public Node left, right;

    public Node(int key) {
        this.key = key;
        left = right = null;

    }

    public String toString() {
        return "" + this.key;
    }

    @Override
    public int compareTo(Node o) {
        return this.key - o.key;
    }
}
