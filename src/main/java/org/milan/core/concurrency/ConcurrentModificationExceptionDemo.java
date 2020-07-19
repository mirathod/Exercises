package org.milan.core.concurrency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ArrayList, Iterator and ConcurrentModificationException Demo
 *
 * @author Milan Rathod
 */
public class ConcurrentModificationExceptionDemo {

    /**
     * Eventually will move this to test case
     *
     * @param args
     */
    public static void main(String... args) {
        List<String> listOfBooks = new ArrayList<>();

        listOfBooks.add("Programming Pearls");
        listOfBooks.add("Clean Code");
        listOfBooks.add("Effective Java");
        listOfBooks.add("Code Complete");


        new ConcurrentModificationExceptionDemo().usingIteratorV2(listOfBooks);
    }

    /**
     * Using For Each Loop
     *
     * @param listOfBooks
     * @throws java.util.ConcurrentModificationException
     */
    public void usingForEachLoop(List<String> listOfBooks) {
        for (String book : listOfBooks) {
            if (book.contains("Code")) {
                listOfBooks.remove(book);
            }
        }
    }

    /**
     * Using For Loop
     *
     * @param listOfBooks
     */
    public void usingForLoop(List<String> listOfBooks) {
        for (int i = 0; i < listOfBooks.size(); i++) {
            String book = listOfBooks.get(i);
            if (book.contains("Programming")) {
                listOfBooks.remove(i);
            }
        }
    }

    /**
     * Using Iterator with array list's remove method
     *
     * @param listOfBooks
     * @throws java.util.ConcurrentModificationException
     */
    public void usingIterator(List<String> listOfBooks) {
        Iterator<String> iterator = listOfBooks.iterator();
        while (iterator.hasNext()) {
            String book = iterator.next();
            listOfBooks.remove(book);
        }
    }

    /**
     * Using Iterator with it's remove method
     *
     * @param listOfBooks
     */
    public void usingIteratorV2(List<String> listOfBooks) {
        Iterator<String> iterator = listOfBooks.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }
}