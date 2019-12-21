package org.milan.misc;

import java.util.HashMap;

/**
 * Implementation of Least Recently Used (LRU) Cache
 *
 * @author Milan Rathod
 */
public class LRUCache {

    private HashMap<Integer, Entry> map;

    private Entry start, end;

    private int LRU_SIZE;

    /**
     * When referenced page is not available in cache to refer it is called page fault
     */
    private int pageFault;

    /**
     * When referenced page is available in cache to refer it is called page fault
     */
    private int pageHit;

    public LRUCache(int size) {
        if (size < 0) {
            throw new IllegalStateException("Size should be greater than 0");
        }

        LRU_SIZE = size;

        map = new HashMap<>();
    }

    public int getPageFault() {
        return pageFault;
    }

    public int getPageHit() {
        return pageHit;
    }

    /**
     * Method first check if key exists in map then move the key to top of the DLL
     * if not exists in map then we have two scenarios
     * 1. Cache is not full, add the key to top of the DLL
     * 2. Cache is full, remove least recently used i.e. last node of the DLL and add the key to top of the DLL
     * <p>
     * Time complexity: O(1)
     *
     * @param key key to be referenced in memory
     */
    public void refer(int key) {
        // Key Already Exist, just update the value and move it to top
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            removeNode(entry);
            addAtTop(entry);
            pageHit++;
        } else {
            Entry newnode = new Entry();
            newnode.left = null;
            newnode.right = null;
            newnode.key = key;
            // We have reached maximum size so need to make room for new element
            if (map.size() > LRU_SIZE) {
                map.remove(end.key);
                removeNode(end);
            }
            addAtTop(newnode);

            map.put(key, newnode);
            pageFault++;
        }
    }

    /**
     * Add the node to the top of the DLL
     *
     * @param node node to be added
     */
    private void addAtTop(Entry node) {
        node.right = start;
        node.left = null;
        if (start != null)
            start.left = node;
        start = node;
        if (end == null)
            end = start;
    }

    /**
     * Remove the node from the DLL
     *
     * @param node node to be removed
     */
    private void removeNode(Entry node) {

        if (node.left != null) {
            node.left.right = node.right;
        } else {
            start = node.right;
        }

        if (node.right != null) {
            node.right.left = node.left;
        } else {
            end = node.left;
        }
    }
}

class Entry {
    int key;
    Entry left;
    Entry right;
}
