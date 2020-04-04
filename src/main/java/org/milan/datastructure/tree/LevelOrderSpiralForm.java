package org.milan.datastructure.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Problem: Level order traversal using spiral form
 *
 * @author Milan Rathod
 */
public class LevelOrderSpiralForm {

    /**
     * Two stacks are being used here
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param root root of the binary tree
     * @return list of node keys visited during level order traversal using spiral form
     */
    public List<Integer> usingTwoStacks(BinaryTree.Node root) {

        // Base case
        if (root == null) {
            return null;
        }

        // First stack being used for level order of right to left
        Stack<BinaryTree.Node> stack1 = new Stack<>();

        // Second stack being used for level order of left to right
        Stack<BinaryTree.Node> stack2 = new Stack<>();

        // Push first level to first stack
        stack1.push(root);

        List<Integer> outputList = new ArrayList<>();

        // Keep iterating until any of the stacks have some nodes
        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            // Add nodes of current level to output from stack 1 and push nodes of next level to stack 2
            while (!stack1.isEmpty()) {
                BinaryTree.Node current = stack1.pop();

                outputList.add(current.key);

                // Right child is pushed before left child
                if (current.right != null) {
                    stack2.push(current.right);
                }

                if (current.left != null) {
                    stack2.push(current.left);
                }
            }

            // Add nodes of current level to output from stack 2 and push nodes of next level to stack 1
            while (!stack2.isEmpty()) {
                BinaryTree.Node current = stack2.pop();

                outputList.add(current.key);

                // Left child is pushed before right child
                if (current.left != null) {
                    stack2.push(current.left);
                }

                if (current.right != null) {
                    stack2.push(current.right);
                }
            }
        }

        return outputList;
    }

    /**
     * One queue and one stack is being used here
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param root root of the binary tree
     * @return list of node keys visited during level order traversal using spiral form
     */
    public List<Integer> usingQueueAndStack(BinaryTree.Node root) {

        // Base case
        if (root == null)
            return null;

        Stack<Integer> stack = new Stack<>();
        Queue<BinaryTree.Node> queue = new LinkedList<>();

        List<Integer> outputList = new ArrayList<>();

        boolean reverse = true;

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                BinaryTree.Node current = queue.poll();

                // If reverse is true, push node's key onto the stack else add it to output list
                if (reverse) {
                    stack.add(current.key);
                } else {
                    outputList.add(current.key);
                }

                // Add left and right child to queue
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
                size--;
            }

            // Add nodes to output list if reverse is true
            if (reverse) {
                while (!stack.empty()) {
                    outputList.add(stack.pop());
                }
            }

            // Toggle value of reverse
            reverse = !reverse;
        }
        return outputList;
    }

    /**
     * Deque is being used here
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param root root of the binary tree
     * @return list of node keys visited during level order traversal using spiral form
     */
    public List<Integer> usingDeque(BinaryTree.Node root) {

        // Base case
        if (root == null) {
            return null;
        }

        Deque<BinaryTree.Node> deque = new LinkedList<>();

        List<Integer> outputList = new ArrayList<>();

        // Push root
        deque.addLast(root);

        // Direction 0 shows print right to left and for Direction 1 left to right
        int direction = 0;

        while (deque.size() > 0) {

            int size = deque.size();

            while (size-- > 0) {

                if (direction == 0) {
                    BinaryTree.Node temp = deque.pollLast();
                    if (temp.right != null)
                        deque.addFirst(temp.right);
                    if (temp.left != null)
                        deque.addFirst(temp.left);
                    outputList.add(temp.key);
                } else {
                    BinaryTree.Node temp = deque.pollFirst();
                    if (temp.left != null)
                        deque.addLast(temp.left);
                    if (temp.right != null)
                        deque.addLast(temp.right);
                    outputList.add(temp.key);
                }
            }
            // Direction change
            direction = 1 - direction;
        }
        return outputList;
    }

}
