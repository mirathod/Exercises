package org.milan.datastructure.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

/**
 * circular linked list with all basic operations
 *
 * @author Milan Rathod
 */
public class CircularLinkedList<E> {
    /**
     * Logger for logging circular linked list related logs
     */
    private static final Logger LOG = LoggerFactory.getLogger(CircularLinkedList.class);

    /**
     * Head node
     */
    private Node<E> head;

    /**
     * Size of the list
     */
    private int size;

    /**
     * Constructs an empty list
     */
    public CircularLinkedList() {
        head = null;
    }

    /**
     * Constructs an list with head
     */
    public CircularLinkedList(Node<E> head) {
        this.head = head;
        head.next = head;
        adjustSize(head);
    }

    /**
     * return head of the list
     *
     * @return head of the list
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
            head.next = head;
        } else {
            Node<E> newHead = new Node<>(data, head);
            Node<E> temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newHead;
            head = newHead;
        }
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
        Node<E> newNode = new Node<>(data);
        if (temp.next == head) {
            newNode.next = head;
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
            while (last.next != null && last.next != head) {
                last = last.next;
            }
            last.next = newNode;
            newNode.next = head;
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
            Node<E> lastNode = temp;
            while (lastNode.next != temp) {
                lastNode = lastNode.next;
            }
            lastNode.next = temp.next;
            head = temp.next;
            size--;
            return;
        }

        // Identify the deletion node
        while (temp != null && temp.data != data && temp.next != head) {
            previous = temp;
            temp = temp.next;
        }

        if (temp == null) {
            throw new NoSuchElementException("Requested node for deletion with key " + data + " not found");
        } else {
            previous.next = temp.next;
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
            Node<E> lastNode = head;
            while (lastNode.next != head) {
                lastNode = lastNode.next;
            }
            lastNode.next = head.next;
            head = head.next;
            size--;
        } else {
            Node<E> previous = temp;

            for (int i = 0; i < position; i++) {
                previous = temp;
                temp = temp.next;
            }

            previous.next = temp.next;
            size--;
        }
    }

    /**
     * return size of the list
     *
     * @return list size
     */
    public int getSize() {
        return size;
    }

    /**
     * check if list is empty or not
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Check if node is present in list or not
     */
    public boolean contains(E key) {
        Node<E> current = head;
        do {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }

    /**
     * Adjust size of the circular linked list based on passed head node
     *
     * @param head head of the linked list
     */
    private void adjustSize(Node<E> head) {
        Node<E> current = head;

        if (current != null && current.next == head) {
            size++;
        } else {
            while (current != null && current.next != head) {
                current = current.next;
                size++;
            }
        }
    }

    static class Node<E> {
        E data;

        Node<E> next;

        Node(E data) {
            this(data, null);
        }

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
