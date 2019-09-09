package org.milan.datastructure.stack;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/efficiently-implement-k-stacks-single-array/}
 *
 * @author Milan Rathod
 */
public class KStacksWithOneArray {

    /**
     * integer array used for storing all stacks elements
     */
    private int[] array;

    /**
     * integer array used for storing tops of all stacks
     */
    private int[] tops;

    /**
     * integer array used for storing next entry in all stacks and free list
     */
    private int[] nexts;

    /**
     * size of the array
     */
    private int size;

    /**
     * total number of stacks
     */
    private int k;

    /**
     * store beginning index of free list
     */
    private int free;

    public KStacksWithOneArray(int size, int k) {
        this.size = size;

        this.k = k;

        array = new int[size];

        tops = new int[k];

        nexts = new int[size];

        // Initialize all stacks as empty
        for (int i = 0; i < k; i++) {
            tops[i] = -1;
        }

        // Initialize all spaces as free
        free = 0;

        for (int i = 0; i < size; i++) {
            nexts[i] = i + 1;
        }
        nexts[size - 1] = -1; // -1 used to indicate end of free list
    }

    /**
     * push an item to specific stack specified by stack number
     *
     * @param stackNumber stack in which item to be pushed
     * @param item        data
     */
    public void push(int stackNumber, int item) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }

        // Store index of first free slot in free list
        int i = free;

        // Update index of free slot to index of next slot in free list
        free = nexts[i];

        // Update next of top and then top of stack specified in input parameter
        nexts[i] = tops[stackNumber];
        tops[stackNumber] = i;

        // Put an item to the array
        array[i] = item;
    }

    /**
     * pop an item from the specific stack specified by stack number
     *
     * @param stackNumber stack from which item to be popped
     * @return item
     */
    public int pop(int stackNumber) {

        if (isEmpty(stackNumber)) {
            throw new StackOverflowError("Stack " + stackNumber + " is empty");
        }

        // Find index of top item in stack
        int i = tops[stackNumber];

        // Change top to store next of previous top
        tops[stackNumber] = nexts[i];

        // Attach the previous top to the beginning of free list
        nexts[i] = free;
        free = i;

        return array[i];
    }

    /**
     * Check if stack is full or not
     */
    public boolean isFull() {
        return free == -1;
    }

    /**
     * Check if stack specified by stack number is empty or not
     */
    public boolean isEmpty(int stackNumber) {
        return tops[stackNumber] == -1;
    }

}
