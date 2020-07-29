package org.milan.collections;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Comparator Example
 *
 * @author Milan Rathod
 */
public class ComparatorDemo {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>(new CustomComparator());

        treeSet.add("C");
        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("E");
        treeSet.add("F");
        treeSet.add("D");

        for (String item : treeSet) {
            System.out.println(item + " ");
        }
    }
}

/**
 * A custom comparator which prints string in reverse/descending order
 */
class CustomComparator implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        return ((String) o2).compareTo((String) o1);
    }
}