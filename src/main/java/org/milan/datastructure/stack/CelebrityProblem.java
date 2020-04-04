package org.milan.datastructure.stack;

import java.util.Stack;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/the-celebrity-problem/?ref=rp}
 *
 * @author Milan Rathod
 */
public class CelebrityProblem {

    private int[][] matrix;

    public CelebrityProblem(int[][] matrix) {
        this.matrix = matrix;
    }

    public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();

        // Push all members to stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            // Pop two elements from stack and discard one element based on status of matrix
            int a = stack.pop();
            int b = stack.pop();

            if (matrix[a][b] == 1) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        int c = stack.pop();

        for (int i = 0; i < n; i++) {
            // If any person doesn't know 'c' and 'c' doesn't know any person return -1
            if (i != c && (matrix[c][i] == 1 || matrix[i][c] == 0)) {
                return -1;
            }
        }
        return c;
    }

    public int findCelebrityV2(int n) {
        int a = 0;
        int b = n - 1;

        while (a < b) {
            if (matrix[a][b] == 1) {
                a++;
            } else {
                b--;
            }
        }

        for (int i = 0; i < n; i++) {
            // If any person doesn't know 'a' and 'a' doesn't know any person return -1
            if (i != a && (matrix[a][i] == 1 || matrix[i][a] == 0)) {
                return -1;
            }
        }
        return a;
    }

}
