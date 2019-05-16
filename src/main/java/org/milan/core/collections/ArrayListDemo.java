package org.milan.core.collections;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Milan Rathod
 */
public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<Comparable> comparableArrayList = new ArrayList<>();
        ArrayList<Animal> animalArrayList = new ArrayList<>();
        comparableArrayList.add(new Animal());
        comparableArrayList.add(new Animal());
        comparableArrayList.add("Animal");

        animalArrayList.add(new Animal());
        animalArrayList.add(new Animal());

        Iterator<Comparable> i = comparableArrayList.iterator();

        while (i.hasNext()) {
            System.out.println(i.next().toString());
        }

        // Collections.sort(comparableArrayList);

        // Alternate way
        for (Object o : comparableArrayList) {
            System.out.println(o.toString());
        }

        Object[] arrayFromArrayList = comparableArrayList.toArray(); // obtaining array from ArrayList

        for (Object o : arrayFromArrayList) {
            System.out.println(o.toString());
        }

    }

}

class Animal implements Comparable<Object> {

    private int height;
    private int weight;

    @Override
    public String toString() {
        return ("Height :-" + height + " and weight:-" + weight);
    }

    public int compareTo(Object o) {
        return 1;
    }
}
