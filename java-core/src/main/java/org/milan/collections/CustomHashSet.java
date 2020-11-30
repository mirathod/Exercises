package org.milan.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * More advanced implementation than {@link MyHashSet}
 *
 * @author Milan Rathod
 */
public class CustomHashSet {

    /**
     * Total number of buckets
     */
    private static final int ARRAY_SIZE = 100;

    /**
     * Data structure used for storing set values
     */
    private final List<List<Integer>> parentList;

    public CustomHashSet() {
        parentList = new ArrayList<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            parentList.add(null);
        }
    }

    /**
     * @param key key to be inserted
     */
    public void add(int key) {

        // Finding correct bucket
        int index = key % ARRAY_SIZE;

        // Get list of all children from that bucket
        List<Integer> childList = parentList.get(index);

        if (childList == null) {
            childList = new LinkedList<>();
            childList.add(key);
            parentList.set(index, childList);
        } else if (!childList.contains(key)) {
            childList.add(key);
        }
    }

    public void remove(int key) {
        // Finding correct bucket
        int index = key % ARRAY_SIZE;

        // Get list of all children from that bucket
        List<Integer> childList = parentList.get(index);
        if (childList != null) {
            childList.remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        // Finding correct bucket
        int index = key % ARRAY_SIZE;

        // Get list of all children from that bucket
        List<Integer> childList = parentList.get(index);
        return childList != null && childList.contains(key);
    }
}
