package org.milan.datastructure.tree;

import java.util.Stack;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/expression-tree/}
 *
 * @author Milan Rathod
 */
public class ExpressionTree {

    /**
     * Construct expression tree from given postfix expression
     *
     * @param postfix postfix expression
     * @return root of constructed expression tree
     */
    public TreeNode<Character> constructTree(char[] postfix) {
        Stack<TreeNode<Character>> stack = new Stack<>();

        for (int i = 0; i < postfix.length; i++) {
            if (!isOperator(postfix[i])) {
                TreeNode<Character> node = new TreeNode<>(postfix[i]);
                stack.push(node);
            } else {
                TreeNode<Character> node = new TreeNode<>(postfix[i]);

                TreeNode<Character> operand1 = stack.pop();
                TreeNode<Character> operand2 = stack.pop();

                node.right = operand1;
                node.left = operand2;

                stack.push(node);
            }
        }

        return stack.pop();
    }

    /**
     * Check if input character is operator or not
     *
     * @param c input character
     * @return true if operator otherwise false
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
}


