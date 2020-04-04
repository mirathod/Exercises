package org.milan.datastructure.tree;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Implementation of binary search tree with all use cases
 *
 * @author Milan Rathod
 */
public class BinarySearchTree {

    /**
     * Root of the binary search tree
     */
    private Node root;

    private LinkedList<Integer> list;

    public BinarySearchTree(int key) {
        this.root = new Node(key);
        this.list = new LinkedList<>();
    }

    /**
     * Get Root of the binary search tree
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Insert a node to binary search tree
     *
     * @param key node key
     */
    public void insert(int key) {
        root = insertRec(root, key);
    }

    /**
     * Recursively insert node key into binary search tree
     *
     * @param root root of the tree
     * @param key  node key
     * @return root
     */
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

    /**
     * Delete a node from binary search tree
     *
     * @param key node key to be deleted
     */
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    /**
     * Delete a node from binary search tree recursively
     *
     * @param root root of the tree
     * @param key  node key
     * @return root
     */
    private Node deleteRec(Node root, int key) {

        // Base condition
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children
            // Find in order predecessor of node to be deleted
            root = findMax(root.left);

            // Delete the in order predecessor
            root.left = deleteRec(root.left, key);
        }

        return root;
    }

    /**
     * check if node with given key is present in tree
     *
     * @param root root of the tree
     * @param key  node key
     * @return true if present otherwise false
     */
    public boolean isPresent(Node root, int key) {
        if (root.key == key) {
            return true;
        } else if (root.key < key) {
            return isPresent(root.right, key);
        } else {
            return isPresent(root.left, key);
        }
    }

    /**
     * Pre order traversal of a tree using recursion
     *
     * @param root root of a tree
     */
    public String preOrder(Node root) {
        StringBuilder stringBuilder = new StringBuilder();
        preOrderUtil(root, stringBuilder);
        return stringBuilder.toString();
    }

    /**
     * Utility function which will actually do pre order
     *
     * @param root          root of a tree
     * @param stringBuilder string builder to return pre order result
     */
    private void preOrderUtil(Node root, StringBuilder stringBuilder) {
        if (root != null) {
            // Visit the root and append it to string builder
            stringBuilder.append(root.key);

            // Traverse left subtree
            preOrderUtil(root.left, stringBuilder);

            // Traverse right subtree
            preOrderUtil(root.right, stringBuilder);
        }
    }

    /**
     * Pre order traversal of a tree using iterative approach
     *
     * @param root root of a tree
     */
    public String preOrderIterative(Node root) {
        StringBuilder stringBuilder = new StringBuilder();

        Deque<Node> stack = new ArrayDeque<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            Node temp = stack.pop();

            // add it to output
            stringBuilder.append(temp.key);

            // First push right and then left child of current popped item
            if (temp.right != null) {
                stack.push(temp.right);
            }

            if (temp.left != null) {
                stack.push(temp.left);
            }
        }

        return stringBuilder.toString();
    }

    /**
     * In order traversal of a tree using recursion
     *
     * @param root root of a tree
     */
    public String inOrder(Node root) {
        StringBuilder stringBuilder = new StringBuilder();
        inOrderUtil(root, stringBuilder);
        return stringBuilder.toString();
    }

    /**
     * Utility function which will actually do in order
     *
     * @param root          root of a tree
     * @param stringBuilder string builder to return in order result
     */
    private void inOrderUtil(Node root, StringBuilder stringBuilder) {
        if (root != null) {
            // Traverse left subtree
            inOrderUtil(root.left, stringBuilder);

            // Visit the root and append it to string builder
            stringBuilder.append(root.key);

            // Traverse right subtree
            inOrderUtil(root.right, stringBuilder);
        }
    }

    /**
     * In order traversal of a tree using iterative approach
     *
     * @param root root of a tree
     */
    public String inOrderIterative(Node root) {
        StringBuilder stringBuilder = new StringBuilder();

        Deque<Node> stack = new ArrayDeque<>();

        // Boolean flag to indicate when to exit while loop i.e. tree traversal is complete
        boolean done = false;

        Node current = root;

        while (!done) {

            if (current != null) {
                stack.push(current);

                current = current.left;
            } else {
                if (stack.isEmpty()) {
                    done = true;
                } else {
                    Node temp = stack.pop();

                    // add it to output
                    stringBuilder.append(temp.key);

                    current = temp.right;
                }

            }
        }
        return stringBuilder.toString();
    }

    /**
     * Post order traversal of a tree using recursion
     *
     * @param root root of a tree
     */
    public String postOrder(Node root) {
        StringBuilder stringBuilder = new StringBuilder();
        postOrderUtil(root, stringBuilder);
        return stringBuilder.toString();
    }

    /**
     * Utility function which will actually do post order
     *
     * @param root          root of a tree
     * @param stringBuilder string builder to return post order result
     */
    private void postOrderUtil(Node root, StringBuilder stringBuilder) {
        if (root != null) {
            // Traverse left subtree
            postOrderUtil(root.left, stringBuilder);

            // Traverse right subtree
            postOrderUtil(root.right, stringBuilder);

            // Visit the root and append it to string builder
            stringBuilder.append(root.key);
        }
    }

    /**
     * Post order traversal of a tree using iterative approach
     *
     * @param root root of a tree
     */
    public String postOrderIterative(Node root) {
        StringBuilder stringBuilder = new StringBuilder();

        Deque<Node> stack = new ArrayDeque<>();

        stack.push(root);

        Node prev = null;

        while (!stack.isEmpty()) {

            Node curr = stack.peek();

            // Traverse from top to bottom and if current has left/right child add it to stack
            if (prev == null || prev.left == curr || prev.right == curr) {

                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }

            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                stringBuilder.append(stack.pop().key);
            }
            prev = curr;
        }
        return stringBuilder.toString();
    }

    /**
     * Level order traversal of a tree using iterative approach
     *
     * @param root root of the tree
     */
    public String levelOrder(Node root) {

        // Base condition
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        StringBuilder stringBuilder = new StringBuilder();

        Queue<Node> queue = new LinkedList<>();

        Node temp = root;

        queue.offer(temp);

        while (!queue.isEmpty()) {

            temp = queue.poll();

            stringBuilder.append(temp.key);

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
        return stringBuilder.toString();
    }

    /**
     * Level order traversal of a tree in reverse
     *
     * @param root root of the tree
     */
    public String levelOrderReverse(Node root) {

        // Base condition
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        StringBuilder stringBuilder = new StringBuilder();

        Queue<Node> queue = new LinkedList<>();

        Deque<Node> stack = new ArrayDeque<>();

        Node temp = root;

        queue.offer(temp);

        while (!queue.isEmpty()) {
            temp = queue.poll();
            stack.push(temp);

            if (temp.right != null) {
                queue.add(temp.right);
            }

            if (temp.left != null) {
                queue.add(temp.left);
            }
        }

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop().key);
        }
        return stringBuilder.toString();
    }

    /**
     * Least common ancestor (LCA) of two nodes
     * NOTES: assumption is both the nodes are present in tree
     *
     * @param root  root of the tree
     * @param node1 first node
     * @param node2 second node
     * @return LCA of two nodes
     */
    public Node lca(Node root, int node1, int node2) {
        // Base condition
        if (root == null) {
            return null;
        }

        // If value of both the nodes are less than current node value traverse left
        if (root.key > node1 && root.key > node2) {
            return lca(root.left, node1, node2);
        }

        // If value of both the nodes are greater than current node value traverse right
        if (root.key < node1 && root.key < node2) {
            return lca(root.right, node1, node2);
        }
        return root;
    }

    /**
     * Find minimum value of binary search tree
     *
     * @param root root of the tree
     * @return minimum node
     */
    public Node findMin(Node root) {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        if (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * Find maximum value of binary search tree
     *
     * @param root root of the tree
     * @return maximum node
     */
    public Node findMax(Node root) {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        if (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public Node inOrderSuccessor(Node root, Node n) {
        // step 1 of the above algorithm
        if (n.right != null)
            return findMin(n.right);

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

    /**
     * Check if given binary tree is BST or not
     *
     * @param root root of the tree
     * @return true if BST otherwise false
     */
    public boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Utility function to recursively check if given binary tree is BST or not
     */
    private boolean isBSTUtil(Node root, int min, int max) {
        // Empty tree is BST
        if (root == null)
            return true;

        // If current node violates the min/max constraints
        if (root.key < min || root.key > max)
            return false;

        // Check the left and right subtree recursively tightening the min/max constraints
        return (isBSTUtil(root.left, min, root.key - 1) && isBSTUtil(root.right, root.key + 1, max));
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

    public void arrayToBST(LinkedList<Integer> list, Node root) {
        if (root == null)
            return;

        /* first update the left subtree */
        arrayToBST(list, root.left);

        root.key = list.poll();

        /* finally update the right subtree */
        arrayToBST(list, root.right);
    }

    /**
     * Find height/depth of the binary tree
     *
     * @param root root of the tree
     * @return height of the tree
     */
    public int height(Node root) {
        if (root == null) return 0;

        // Compute height of each sub tree
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    /**
     * Find height/depth of the binary tree
     *
     * @param root root of the tree
     * @return height of the tree
     */
    public int heightIterative(Node root) {

        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        int maxHeight = 0;

        Deque<Node> stack = new ArrayDeque<>();

        stack.push(root);

        Node prev = null;

        while (!stack.isEmpty()) {

            Node curr = stack.peek();

            // Traverse from top to bottom and if current has left/right child add it to stack
            if (prev == null || prev.left == curr || prev.right == curr) {

                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }

            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                stack.pop();
            }
            prev = curr;
            if (stack.size() > maxHeight) {
                maxHeight = stack.size();
            }
        }
        return maxHeight;
    }

    /**
     * Find minimum depth of the binary tree
     *
     * @param root root of the tree
     * @return height of the tree
     */
    public int minimumDepth(Node root) {

        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        int minDepth = 1;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        // Used for separating elements in level order
        queue.offer(null);

        while (!queue.isEmpty()) {

            Node curr = queue.poll();

            if (curr != null) {
                if (curr.left == null && curr.right == null) {
                    return minDepth;
                }

                if (curr.left != null) queue.offer(curr.left);

                if (curr.right != null) queue.offer(curr.right);
            } else {
                if (!queue.isEmpty()) {
                    minDepth++;
                    queue.offer(null);
                }
            }
        }
        return minDepth;
    }

    /**
     * Find deepest node binary tree
     *
     * @param root root of the tree
     * @return deepest node
     */
    public Node findDeepestNode(Node root) {

        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        Node curr = null;

        while (!queue.isEmpty()) {

            curr = queue.poll();

            if (curr.left != null) {
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return curr;
    }

    /**
     * Calculate size of tree
     *
     * @param root root of the tree
     * @return total size
     */
    public int size(Node root) {
        if (root == null) return 0;

        return size(root.left) + size(root.right) + 1;
    }

    /**
     * Calculate size of tree
     * Iterative approach
     *
     * @param root root of the tree
     * @return total size
     */
    public int sizeIterative(Node root) {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        Queue<Node> queue = new LinkedList<>();

        Node temp = root;

        queue.offer(temp);

        int size = 0;

        while (!queue.isEmpty()) {

            temp = queue.poll();

            size++;

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
        return size;
    }

    /**
     * Find maximum width of the binary tree
     *
     * @param root root of the tree
     * @return maximum width of the tree
     */
    public int maximumWidth(Node root) {

        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        int currentWidth = 0;

        int maxWidth = 1;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        // Used for separating elements in level order
        queue.offer(null);

        while (!queue.isEmpty()) {

            Node curr = queue.poll();

            if (curr != null) {
                if (curr.left != null) {
                    queue.offer(curr.left);
                    currentWidth++;
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                    currentWidth++;
                }
            } else {
                if (!queue.isEmpty()) {
                    currentWidth = 0;
                    queue.offer(null);
                }
            }

            if (currentWidth > maxWidth) {
                maxWidth = currentWidth;
            }
        }
        return maxWidth;
    }

    /**
     * Find maximum level sum of the binary tree
     *
     * @param root root of the tree
     * @return maximum level sum of the tree
     */
    public int findMaximumLevelSum(Node root) {

        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        int maxSum = 0;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int count = queue.size();

            int currentSum = 0;

            while (count-- > 0) {
                Node curr = queue.poll();

                currentSum += curr.key;

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }

            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
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
            if (node.right != null && (!stack.isEmpty() && node.right == stack.peek())) {
                Node temp = stack.pop();
                stack.push(node);
                node = temp;
            } else {
                System.out.println(node.key);
                node = null;
            }
        } while (!stack.isEmpty());
    }

    /**
     * Get number of leaves in given binary tree
     * Recursive approach
     *
     * @param root root of the tree
     * @return total leaves in tree
     */
    public int getTotalLeafNodes(Node root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return getTotalLeafNodes(root.left) + getTotalLeafNodes(root.right);
        }
    }

    /**
     * Get number of leaves in given binary tree
     * Iterative approach
     *
     * @param root root of the tree
     * @return total leaves in tree
     */
    public int getTotalLeafNodesIterative(Node root) {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        int totalLeafNodes = 0;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            Node curr = queue.poll();

            if (curr.left == null && curr.right == null) {
                totalLeafNodes++;
            }

            if (curr.left != null) queue.offer(curr.left);

            if (curr.right != null) queue.offer(curr.right);
        }
        return totalLeafNodes;
    }

    public void arbitraryTree(Node node) {
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
            arbitraryTree(node.left);
            arbitraryTree(node.right);
        }
    }

    static class Node {
        int key;

        Node left;

        Node right;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public String toString() {
            return "" + this.key;
        }
    }

}
