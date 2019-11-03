package org.milan.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/next-greater-element/}
 *
 * @author Milan Rathod
 */
public class NextGreaterElement {

    /**
     * Find next greater elements for each array elements
     *
     * @param input array of integers
     * @return array consists of next greater elements
     */
    public int[] findAll(int[] input) {
        Stack<Integer> stack = new Stack<>();

        List<Integer> outList = new ArrayList<>();

        stack.push(input[0]);

        for (int i = 1; i < input.length; i++) {
            int next = input[i];

            if (!stack.isEmpty()) {

                int element = stack.pop();

                // If the popped element is smaller than next
                // add it to output, keep popping while elements are smaller until stack is empty
                while (element < next) {
                    outList.add(next);
                    if (stack.isEmpty()) break;
                    element = stack.pop();
                }

                // If the element is greater than next push the element back
                if (element > next) {
                    stack.push(element);
                }

            }

            // Push next to stack so that we can find next greater for it
            stack.push(next);
        }

        while (!stack.isEmpty()) {
            stack.pop();
            outList.add(-1);
        }
        return outList.stream().mapToInt(value -> value).toArray();
    }
}
