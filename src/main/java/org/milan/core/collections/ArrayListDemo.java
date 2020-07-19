package org.milan.core.collections;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Example for {@link ArrayList}
 *
 * @author Milan Rathod
 */
public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<Comparable> comparableArrayList = new ArrayList<>();

        comparableArrayList.add(new Animal());
        comparableArrayList.add(new Animal());
        comparableArrayList.add("Animal");

        Iterator<Comparable> iterator = comparableArrayList.iterator();

        // Iterate through while loop
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        // Alternate way - for each loop
        for (Object o : comparableArrayList) {
            System.out.println(o.toString());
        }

        // Obtaining array from ArrayList
        Object[] arrayFromArrayList = comparableArrayList.toArray();

        for (Object o : arrayFromArrayList) {
            System.out.println(o.toString());
        }

    }

}

/**
 * Animal Class
 */
@Getter
@Setter
class Animal implements Comparable<Object> {

    private int height;

    private int weight;

    @Override
    public String toString() {
        return ("Height :-" + height + " and weight:-" + weight);
    }

    @Override
    public int compareTo(Object o) {
        return 1;
    }
}
