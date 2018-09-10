package org.milan.datastructure.binarysearchtree;

import java.util.Collections;
import java.util.LinkedList;

public class BinarySearchTree {

    Node root;
    static int max_level = 0;
    int counter = 0;
    LinkedList<Integer> list;

    BinarySearchTree(int key) {
        this.root = new Node(key);
        this.list = new LinkedList<>();
    }

    public boolean search(Node node, int key) {
        if (node.key == key) {
            return true;
        } else if (node.key < key) {
            return search(node.right, key);
        } else {
            return search(node.left, key);
        }
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, key);
        }

        return root;
    }

    public int minValue(Node right) {
        int min = right.key;
        if (right.left != null) {
            min = right.left.key;
            right = right.left;
        }
        return min;
    }

    public Node inOrderSuccessor(Node root, Node n) {
        // step 1 of the above algorithm
        if (n.right != null)
            return new Node(minValue(n.right));

        Node succ = null;

        // Start from root and search for successor down the tree
        while (root != null) {
            if (n.key < root.key) {
                succ = root;
                root = root.left;
            } else if (n.key > root.key)
                root = root.right;
            else
                break;
        }

        return succ;

    }

    boolean isBSTUtil(Node node, int min, int max) {
        /* an empty tree is BST */
        if (node == null)
            return true;

        /* false if this node violates the min/max constraints */
        if (node.key < min || node.key > max)
            return false;

        /*
         * otherwise check the subtrees recursively tightening the min/max constraints
         */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.key - 1) && isBSTUtil(node.right, node.key + 1, max));
    }

    public void inOrderKth(Node node, int k) {
        if (node != null) {
            inOrderKth(node.left, k);
            if (++counter != k) {
            } else {
                System.out.println(node.key);
                return;
            }

            inOrderKth(node.right, k);
        }
    }

    public Node removeOutsideRange(Node root, int min, int max) {
        if (root == null)
            return null;

        root.left = removeOutsideRange(root.left, min, max);
        root.right = removeOutsideRange(root.right, min, max);

        if (root.key < min) {
            Node rChild = root.right;
            root = null;
            return rChild;
        }

        if (root.key > max) {
            Node lChild = root.left;
            root = null;
            return lChild;
        }
        return root;
    }

    public void inOrderStore(Node node) {
        if (node != null) {
            inOrderStore(node.left);
            list.add(node.key);
            inOrderStore(node.right);
        }
    }

    public void binaryToBST(Node root) {
        inOrderStore(root);
        Collections.sort(list);

        arrayToBST(list, root);

    }

    void arrayToBST(LinkedList<Integer> list, Node root) {
        if (root == null)
            return;

        /* first update the left subtree */
        arrayToBST(list, root.left);

        root.key = list.poll();

        /* finally update the right subtree */
        arrayToBST(list, root.right);
    }

    public void rightViewOfTree(Node node, int level) {
        if (node == null)
            return;
        if (level > max_level) {
            System.out.println(node.key);
            max_level = level;
        }
        rightViewOfTree(node.right, level + 1);
        rightViewOfTree(node.left, level + 1);

    }

}
