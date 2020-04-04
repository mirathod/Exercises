package org.milan.datastructure.heap;

import org.milan.util.ArrayUtil;

import java.util.stream.IntStream;

/**
 * Binary heap with all basic operations
 *
 * @author Milan Rathod
 */
public class BinaryHeap {

    /**
     * Store binary heap elements in array of integers
     */
    private int[] store;

    /**
     * Size of the heap
     */
    private int capacity;

    /**
     * Number of elements in heap
     */
    private int count;

    /**
     * type of the heap i.e. max heap or min heap
     */
    private HeapType heapType;

    public BinaryHeap(int capacity) {
        this(capacity, HeapType.MAX);
    }

    public BinaryHeap(int capacity, HeapType heapType) {
        this.capacity = capacity;
        this.heapType = heapType;
        this.count = 0;
        this.store = new int[capacity];
    }

    /**
     * Get Index of parent of node at index i
     *
     * @param i index
     * @return index of parent
     */
    public int getParent(int i) {
        return (i <= 0 || i >= this.count) ? -1 : (i - 1) / 2;
    }

    /**
     * Get Index of left child of node at index i
     *
     * @param i index
     * @return index of left child
     */
    public int getLeft(int i) {
        return (2 * i + 1 >= this.count) ? -1 : 2 * i + 1;
    }

    /**
     * Get Index of right child of node at index i
     *
     * @param i index
     * @return index of right child
     */
    public int getRight(int i) {
        return (2 * i + 2 >= this.count) ? -1 : 2 * i + 2;
    }

    /**
     * Heapify the given binary tree
     *
     * @param index index
     */
    public void heapify(int index) {
        if (heapType == HeapType.MAX) {
            maxHeapify(index);
        } else {
            minHeapify(index);
        }
    }

    /**
     * Heapify process in min heap
     *
     * @param index index of current node
     */
    private void minHeapify(int index) {
        int left;
        int right;
        int min;

        left = getLeft(index);
        right = getRight(index);

        min = index;

        // Update min based on comparison with left and right children
        if (left != -1 && store[left] < store[min]) {
            min = left;
        }

        if (right != -1 && store[right] < store[min]) {
            min = right;
        }

        // Swap the element if either left or right children is less than current node
        if (min != index) {
            ArrayUtil.swap(store, index, min);
            minHeapify(min);
        }
    }

    /**
     * Heapify process in max heap
     *
     * @param index index of current node
     */
    private void maxHeapify(int index) {
        int left;
        int right;
        int max;

        left = getLeft(index);
        right = getRight(index);

        max = index;

        // Update max based on comparison with left and right children
        if (left != -1 && store[left] > store[max]) {
            max = left;
        }

        if (right != -1 && store[right] > store[max]) {
            max = right;
        }

        // Swap the element if either left or right children is greater than current node
        if (max != index) {
            ArrayUtil.swap(store, index, max);
            maxHeapify(max);
        }
    }

    /**
     * Deleting element from binary heap
     *
     * @return maximum element for max heap and minimum element for min heap
     */
    public int delete() {
        if (this.count == 0) {
            throw new IllegalStateException("binary heap is empty");
        }

        // Returning root element of the heap
        int data = store[0];

        // Copying last element of the heap
        store[0] = store[this.count - 1];

        // Reducing the heap size
        this.count--;

        heapify(0);

        return data;
    }

    public void insert(int data) {

        if (this.count == capacity) {
            throw new IllegalStateException("binary heap is full");
        }

        // Increasing the heap size
        this.count++;

        int index = this.count - 1;

        store[index] = data;

        if (this.heapType == HeapType.MAX) {
            while (index > 0 && store[index] > store[getParent(index)]) {
                ArrayUtil.swap(store, index, getParent(index));
                index = getParent(index);
            }
        } else {
            while (index > 0 && store[index] < store[getParent(index)]) {
                ArrayUtil.swap(store, index, getParent(index));
                index = getParent(index);
            }
        }
    }

    /**
     * Build heap from given array
     * NOTE: Heap should be empty before calling this method
     *
     * @param array array of integers
     */
    public void buildHeap(int[] array) {
        if (array.length == 0 || array.length > capacity) {
            throw new IllegalStateException("Input array is empty or greater than heap capacity");
        }

        for (int i = 0; i < array.length; i++) {
            store[i] = array[i];
        }

        this.count = array.length;

        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    /**
     * Heap sort
     *
     * @param array array of integers
     */
    public void sort(int[] array) {

        // Build heap first
        buildHeap(array);

        for (int i = array.length - 1; i >= 0; i--) {
            ArrayUtil.swap(store, 0, i);
            this.count--;
            heapify(0);
        }
    }

    /**
     * Get element at provided index
     *
     * @param index index
     * @return element at index
     */
    public int getElement(int index) {

        // Base condition
        if (index < 0 || index >= this.count) {
            throw new IllegalStateException("Incorrect index provided");
        }

        return this.store[index];
    }

    /**
     * Find index of element present in heap
     *
     * @param data element
     * @return -1 if element is not present otherwise index
     */
    public int indexOf(int data) {
        return IntStream.range(0, store.length)
                .filter(i -> data == store[i])
                .findFirst()
                .orElse(-1);
    }

    /**
     * Get heap elements into array
     * NOTE: for testing purpose only
     *
     * @return array of stored elements
     */
    public int[] getStore() {
        return this.store;
    }

    /**
     * Get size of binary heap
     *
     * @return size
     */
    public int size() {
        return this.store.length;
    }

}

/**
 * Enum for heap type
 */
enum HeapType {
    MAX, MIN
}