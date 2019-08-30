package org.milan.datastructure.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

/**
 * Problem: Swap two nodes of linked list
 *
 * @author Milan Rathod
 */
public class SwapNodes {

    private static final Logger LOG = LoggerFactory.getLogger(SwapNodes.class);

    /**
     * Swap two nodes of linked list
     *
     * @param head head of the linked list
     * @param x    first node to be swapped
     * @param y    second node to be swapped
     * @return head after swapping
     */
    public LinkedList.Node<Integer> swap(LinkedList.Node<Integer> head, Integer x, Integer y) {
        if (x.equals(y)) {
            LOG.warn("both nodes are same, no changes required");
            return head;
        }

        LinkedList.Node<Integer> currentX = head;

        LinkedList.Node<Integer> previousX = null;

        LinkedList.Node<Integer> currentY = head;

        LinkedList.Node<Integer> previousY = null;

        while (currentX != null && !currentX.getData().equals(x)) {
            previousX = currentX;
            currentX = currentX.next;
        }

        while (currentY != null && !currentY.getData().equals(y)) {
            previousY = currentY;
            currentY = currentY.next;
        }

        // Check to ensure that both nodes are present in linked list
        if (currentX == null || currentY == null) {
            LOG.warn("one of the nodes are not present in linked list");
            throw new NoSuchElementException("one of the nodes are not present in linked list");
        }

        if (previousX != null)
            previousX.next = currentY;
        else
            head = currentY;

        if (previousY != null)
            previousY.next = currentX;
        else
            head = currentX;

        // Do the swapping
        LinkedList.Node<Integer> temp = currentX.next;
        currentX.next = currentY.next;
        currentY.next = temp;
        return head;
    }

}
