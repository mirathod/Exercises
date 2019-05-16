package org.milan.core.generics;

import java.util.ArrayList;

/**
 * Generics Use case
 *
 * @author Milan Rathod
 */
public class SoMuchUseful {

    public static void main(String[] a) {

        // String Array to List of Strings
        String[] namesArray = {"Shailesh", "Mohan", "Rohan"};

        ArrayList<String> namesList = new ArrayList<>();

        ArrayToCollection.fromArrayToCollection(namesArray, namesList);

        // Integer Array to List of Integers
        Integer[] integersArray = {12, 23, 34, 45};

        ArrayList<Integer> integersList = new ArrayList<>();

        ArrayToCollection.fromArrayToCollection(integersArray, integersList);

        // Float Array to List of Floats
        Float[] floatsArray = {2.3f, 4.5f, 5.4f};

        ArrayList<Float> floatsList = new ArrayList<>();

        ArrayToCollection.fromArrayToCollection(floatsArray, floatsList);
    }
}
