package org.milan;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Heap pollution is situation that arises when a variable of a parameterized type
 * refers to an Object that is not of that parameterized type.
 * <p>
 * This situation normally detected during compilation and indicated
 * with an unchecked warning. Later during runtime
 * heap pollution will often cause a ClassCastException
 *
 * @author Milan Rathod
 */
public class HeapPollutionDemo {

    public static void main(String[] args) {
        Set s = new HashSet<Integer>();
        Set<String> ss = s; // unchecked warning
        s.add(40); // another unchecked warning
        Iterator<String> it = ss.iterator();
        while (it.hasNext()) {
            String str = it.next(); // ClassCastException thrown
            System.out.println(str);
        }
    }
}
