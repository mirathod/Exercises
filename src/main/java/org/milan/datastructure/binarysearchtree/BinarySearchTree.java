package org.milan.datastructure.binarysearchtree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Binary Search Tree Implementation
 *
 * @author Milan Rathod
 */
public class BinarySearchTree {

    Node root;

    private static int MAX_LEVEL = 0;

    private int counter = 0;

    private LinkedList<Integer> list;

    public BinarySearchTree(int key) {
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
        if (level > MAX_LEVEL) {
            System.out.println(node.key);
            MAX_LEVEL = level;
        }
        rightViewOfTree(node.right, level + 1);
        rightViewOfTree(node.left, level + 1);

    }

    public int height() {
        return height(this.root);
    }

    private int height(Node root) {
        if (root == null) return 0;
        else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if (leftHeight > rightHeight) return (leftHeight + 1);
            else return (rightHeight + 1);
        }
    }

    public int size(Node root) {
        if (root == null) return 0;
        else {
            return size(root.left) + size(root.right) + 1;
        }
    }

    public void printLevelOrder() {
        int height = height(root);
        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
        }
    }

    private void printGivenLevel(Node root, int level) {
        if (root == null) return;
        if (level == 1) System.out.println(root.key + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    public void postOrderWithTwoStacks(Node node) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(node);
        while (!stack1.isEmpty()) {
            Node temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null) stack1.push(temp.left);
            if (temp.right != null) stack1.push(temp.right);
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().key + " ");
        }
    }

    public void postOrderWithOneStack(Node node) {
        Stack<Node> stack = new Stack<>();
        do {
            while (node != null) {
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right != null && (stack.isEmpty() == false && node.right == stack.peek())) {
                Node temp = stack.pop();
                stack.push(node);
                node = temp;
            } else {
                System.out.println(node.key);
                node = null;
            }
        } while (!stack.isEmpty());
    }

    public void printLevelOrderV2() {
        Queue<Node> queue = new LinkedList<>();
        Node temp = root;
        while (temp != null) {
            System.out.println(temp.key);
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
            temp = queue.poll();
        }
    }

    public void preOrder(Node N) {
        if (N == null) return;
        System.out.print(N.key + "  ");
        preOrder(N.left);
        preOrder(N.right);
    }

    public void inOrder(Node N) {
        if (N == null) return;
        inOrder(N.left);
        System.out.print(N.key + "  ");
        inOrder(N.right);
    }

    public void postOrder(Node N) {
        if (N == null) return;
        postOrder(N.left);
        postOrder(N.right);
        System.out.print(N.key + "  ");
    }

    public int getLeafNode(Node node) {
        if (node == null) return 0;
        else if (node.left == null && node.right == null) return 1;
        else {
            return getLeafNode(node.left) + getLeafNode(node.right);
        }
    }

    public boolean checkSum(Node node) {
        if (node == null) return false;
        else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);

            while (!queue.isEmpty()) {
                int ld = 0, rd = 0;
                Node temp = queue.poll();
                if (temp.left == null && temp.right == null) continue;
                if (temp.left != null) {
                    ld = temp.left.key;
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    rd = temp.right.key;
                    queue.add(temp.right);
                }
                if (temp.key == ld + rd) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public void arbitaryTree(Node node) {
        if (node == null) return;
        else {
            int ld = 0, rd = 0;
            if (node.left != null) ld = node.left.key;
            if (node.right != null) rd = node.right.key;
            int diff = node.key - (ld + rd);
            if (diff > 0) {
                if (node.left != null) {
                    node.left.key += diff;
                } else if (node.right != null) {
                    node.right.key += diff;
                } else {
                    System.out.println(node.key);
                    return;
                }
            } else {
                node.key -= diff;
            }
            System.out.println(node.key);
            arbitaryTree(node.left);
            arbitaryTree(node.right);
        }
    }

    public int sumTree(Node node) {
        if (node == null || (node.left == null && node.right == null)) return 1;
        else {
            int leftSubTree = sum(node.left);
            int rightSubTree = sum(node.right);
            if ((node.key == leftSubTree + rightSubTree) && sumTree(node.left) != 0 && sumTree(node.right) != 0) {
                return 1;
            }
        }
        return 0;
    }

    public int sum(Node node) {
        if (node == null)
            return 0;
        return sum(node.left) + node.key + sum(node.right);
    }


}
