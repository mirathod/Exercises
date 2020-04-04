package org.milan.datastructure.linkedlist;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/delete-a-node-from-linked-list-without-head-pointer/}
 *
 * @author Milan Rathod
 */
public class DeleteNodeWithoutHead {

    /**
     * NOTE: When node to be deleted is last node this method can't handle it
     * <p>
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @param node node to be deleted
     */
    public void delete(LinkedList.Node<Integer> node) {

        if (node.next == null) {
            throw new IllegalArgumentException("Last node can't be deleted with this method. Required head node access!");
        }

        LinkedList.Node<Integer> temp = node.next;
        node.data = temp.data;
        node.next = temp.next;

        // This step might not be needed
        // Run the garbage collector to collect dereference node.
        System.gc();
    }
}

