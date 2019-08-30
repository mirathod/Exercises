package org.milan.datastructure.linkedlist;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/}
 *
 * @author Milan Rathod
 */
public class AddTwoLists {

    /**
     * Add numbers represented by two linked lists
     *
     * @param head1 head of first linked list
     * @param head2 head of second linked list
     * @return head node after addition
     */
    public LinkedList.Node<Integer> add(LinkedList.Node<Integer> head1, LinkedList.Node<Integer> head2) {
        return add(head1, head2, 0);
    }

    /**
     * Add numbers represented by two linked lists recursively by considering carry from previous calculation
     *
     * @param head1 head of first linked list
     * @param head2 head of second linked list
     * @param carry carry from previous calculation
     * @return head node after addition
     */
    private LinkedList.Node<Integer> add(LinkedList.Node<Integer> head1, LinkedList.Node<Integer> head2, int carry) {

        // Base condition
        if (head1 == null && head2 == null) {

            // If carry is still available after both the linked list are null then create new node with carry
            if (carry > 0) {
                return new LinkedList.Node<>(carry);
            }
            return null;
        }

        // Data value of first linked list nodes
        int x = 0;

        // Data value of second linked list nodes
        int y = 0;

        if (head1 != null) {
            x = head1.data;
            head1 = head1.next;
        }
        if (head2 != null) {
            y = head2.data;
            head2 = head2.next;
        }

        // Do the actual summation here with
        int sum = x + y + carry;

        if (sum > 9) {
            carry = sum / 10;
            sum %= 10;
        } else {
            carry = 0;
        }

        // Create new node with sum value
        LinkedList.Node<Integer> temp = new LinkedList.Node<>(sum);
        temp.next = add(head1, head2, carry);
        return temp;
    }
}
