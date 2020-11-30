package org.milan.collections;

/**
 * Use this implementation if input range and number of operations are given
 * <p>
 * Time complexity: O(1)
 * Space complexity: O(N)
 * <p>
 * Assumptions: range of input here is 1 to 1000000
 *
 * @author Milan Rathod
 */
public class MyHashSet {

    private final boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }
}
