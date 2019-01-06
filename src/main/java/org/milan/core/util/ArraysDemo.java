package org.milan.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility method of Arrays class
 *
 * @author Milan Rathod
 */
public class ArraysDemo {

    public static void main(String[] args) {

        // Print an array as string
        int[] intArray = {1, 2, 3, 4, 5};

        String intArrayString = Arrays.toString(intArray);

        System.out.println(intArrayString);

        // Create an arraylist from an array

        String[] stringArray = {"a", "b", "c", "d", "e"};

        List<String> arrayList = new ArrayList<>(Arrays.asList(stringArray));

        System.out.println(arrayList);

        // convert to array from an arraylist

        stringArray = new String[arrayList.size()];

        arrayList.toArray(stringArray);
    }
}
