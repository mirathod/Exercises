package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test Class for {@link Palindrome}
 *
 * @author Milan Rathod
 */
public class PalindromeTest {

    private LinkedList<Integer> linkedList;

    private Palindrome palindrome;

    @Before
    public void setup() {
        linkedList = new LinkedList<>(new LinkedList.Node<>(5));

        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(15);
        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(5);

        palindrome = new Palindrome();
    }

    @Test
    public void testUsingStack() {
        Assert.assertTrue(palindrome.usingStack(linkedList.getHead()));
    }

    @Test
    public void testUsingRecursion() {
        Assert.assertTrue(palindrome.usingRecursion(linkedList.getHead()));
    }
}