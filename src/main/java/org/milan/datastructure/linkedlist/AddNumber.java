package org.milan.datastructure.linkedlist;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/add-1-number-represented-linked-list/}
 *
 * @author Milan Rathod
 */
public class AddNumber {

    private ReverseLinkedList reverseLinkedList;

    public AddNumber() {
        reverseLinkedList = new ReverseLinkedList();
    }

    public LinkedList.Node<Integer> add(LinkedList.Node<Integer> head, int number) {

        LinkedList.Node<Integer> reversedHead = reverseLinkedList.reverseByRecursive(head);

        LinkedList.Node<Integer> newHead = addNumber(reversedHead, number);

        return reverseLinkedList.reverseByRecursive(newHead);
    }

    private LinkedList.Node<Integer> addNumber(LinkedList.Node<Integer> head, int number) {

        int sum;

        LinkedList.Node<Integer> prev = null;

        int carry = number;

        LinkedList.Node<Integer> temp = head;

        while (head != null) {
            sum = carry + head.data;

            carry = (sum >= 10) ? 1 : 0;

            sum %= 10;

            head.data = sum;

            prev = head;

            head = head.next;
        }

        if (carry > 0) {
            LinkedList.Node<Integer> newNode = new LinkedList.Node<>(carry);
            prev.next = newNode;
        }

        return temp;
    }
}
