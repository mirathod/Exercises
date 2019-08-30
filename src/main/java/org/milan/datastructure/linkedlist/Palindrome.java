package org.milan.datastructure.linkedlist;

import java.util.Stack;

/**
 * Problem: Linked list is palindrome or not
 *
 * @author Milan Rathod
 */
public class Palindrome {

    private LinkedList.Node<Integer> left;

    private LinkedList.Node<Integer> head;

    /**
     * Check if linked list is palindrome or not using stack
     *
     * @param head head of the linked list
     */
    public boolean usingStack(LinkedList.Node<Integer> head) {
        LinkedList.Node<Integer> temp = head;

        // Stack being used for storing linked list nodes
        Stack<LinkedList.Node> stack = new Stack<>();

        // Push all nodes from beginning of linked list to stack
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            if (!stack.pop().getData().equals(temp.getData())) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    /**
     * Check if linked list is palindrome or not using recursion
     *
     * @param head head of the linked list
     */
    public boolean usingRecursion(LinkedList.Node<Integer> head) {
        this.head = head;
        return usingRecursionUtil(head);
    }

    private boolean usingRecursionUtil(LinkedList.Node<Integer> right) {
        left = head;

        // Stop recursion when right becomes null
        if (right == null) {
            return true;
        }

        // If sublist is not palindrome return false
        if (!usingRecursionUtil(right.next)) {
            return false;
        }

        boolean isPalindrome = right.getData().equals(left.getData());

        left = left.next;

        return isPalindrome;
    }
}
