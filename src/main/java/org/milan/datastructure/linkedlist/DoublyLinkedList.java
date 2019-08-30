package org.milan.datastructure.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

/**
 * Doubly linked list with all basic operations
 *
 * @author Milan Rathod
 */
public class DoublyLinkedList<E> {

    /**
     * Logger for logging doubly linked list related logs
     */
    private static final Logger LOG = LoggerFactory.getLogger(DoublyLinkedList.class);

    private Node<E> head;

    private int size;

    /**
     * Constructs an empty list.
     */
    public DoublyLinkedList() {
        head = null;
    }

    /**
     * Constructs an list with head
     */
    public DoublyLinkedList(Node<E> head) {
        this.head = head;
        adjustSize(head);
    }

    /**
     * return head of the doubly list
     *
     * @return head of the doubly list
     */
    public Node<E> getHead() {
        return head;
    }

    /**
     * Insert new node before head node
     *
     * @param data data of the new node to be inserted
     */
    public void insertBeforeHead(E data) {
        if (isEmpty()) {
            head = new Node<>(data);
        } else {
            Node<E> newHead = new Node<>(data, null, head);
            head = newHead;
            head.next.prev = newHead;
        }
        size++;
    }

    /**
     * Insert new node after specified node
     *
     * @param previousNodeKey node after which new node to be inserted
     * @param newNodeKey      data of the new node to be inserted
     */
    public void insertAfterSpecifiedNode(E previousNodeKey, E newNodeKey) {

        // Check if list is empty
        if (isEmpty()) {
            throw new NoSuchElementException("Node with key " + previousNodeKey.toString() + " not found");
        }

        Node<E> current = head;

        // Loop through list until previous node found
        while (current != null && !current.data.equals(previousNodeKey)) {
            current = current.next;
        }

        // If null, previous node not found
        if (current == null) {
            throw new NoSuchElementException("Node with key " + previousNodeKey.toString() + " not found");
        }

        // previous node is found
        Node<E> newNode = new Node<>(newNodeKey, current, current.next);
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        size++;
    }

    /**
     * Insert new node after specified position
     *
     * @param data     data of the new node to be inserted
     * @param position position after which new node to be inserted
     */
    public void insertAfterSpecifiedPosition(E data, int position) {

        if (position < 0 || position > size - 1) {
            throw new IllegalArgumentException("Position is Invalid");
        }

        Node<E> temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        Node<E> newNode = new Node<>(data, temp, temp.next);
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;

        size++;
    }

    /**
     * Insert new node at the end of list
     *
     * @param data data of the new node to be inserted
     */
    public void insertAtEnd(E data) {
        Node<E> newNode = new Node<>(data);
        // Check if list is empty
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<E> last = head;
            while (last.next != null) {
                last = last.next;
            }
            newNode.prev = last;
            last.next = newNode;
        }
        size++;
    }

    /**
     * Delete a node by data key
     *
     * @param data data of the new node to be deleted
     */
    public void deleteNodeByKey(E data) {

        Node<E> temp = head;
        Node<E> previous = null;

        // To be deleted node is a head node
        if (temp != null && temp.data == data) {
            head = temp.next;
            if (temp.next != null) {
                temp.next.prev = null;
            }
            size--;
            return;
        }

        // Identify the deletion node
        while (temp != null && temp.data != data) {
            previous = temp;
            temp = temp.next;
        }

        if (temp == null) {
            throw new NoSuchElementException("Requested node for deletion with key " + data + " not found");
        } else {
            previous.next = temp.next;

            if (temp.next != null) {
                temp.next.prev = previous;
            }
            size--;
        }
    }

    /**
     * Delete a node by its position
     *
     * @param position position of the node to be deleted
     */
    public void deleteNodeByPosition(int position) {

        if (position < 0 || position > size - 1) {
            throw new IllegalArgumentException("Position is Invalid");
        }

        Node<E> temp = head;

        // To be deleted node is a head node
        if (position == 0) {
            if (head.next != null) {
                head.next.prev = null;
            }
            head = head.next;

        } else {
            Node<E> previous = temp;

            for (int i = 0; i < position; i++) {
                previous = temp;
                temp = temp.next;
            }

            previous.next = temp.next;

            if (temp.next != null) {
                temp.next.prev = previous;
            }
        }
        size--;
    }

    /**
     * Check if node is present in list or not
     */
    public boolean contains(E key) {
        Node<E> current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * Adjust size of the linked list based on passed head node
     *
     * @param head head of the linked list
     */
    private void adjustSize(Node<E> head) {
        Node<E> current = head;
        while (current != null) {
            current = current.next;
            size++;
        }
    }

    static class Node<E> {
        E data;

        Node<E> prev;

        Node<E> next;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
