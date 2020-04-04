package org.milan.core.concurrency;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Sample for {@link java.util.concurrent.CopyOnWriteArrayList}
 *
 * @author Milan Rathod
 */
public class CopyOnWriteArrayListDemo {

    public void synchronizedApproach() {
        List<Integer> integerList = Lists.newArrayList(1, 2, 3);

        // Synchronized collection lock whole collection, multiple has to read/write one by one
        Collections.synchronizedList(integerList);

    }

    /**
     * Multiple threads can read from collection and but only one can write to collection
     * write operation is performed on copy of collection and after write newer collection is replaced with older one
     * use this when more read operations and less write operations are required.
     */
    public void concurrentApproach() {

        CopyOnWriteArrayList<Integer> integers = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});

        Iterator<Integer> iterator = integers.iterator();

        integers.add(10);

        iterator.forEachRemaining(integer -> {
            if (integer.equals(10)) {
                System.out.println("iterator should not contain element 10. THIS statement should not be executed");
            }
        });

        Iterator<Integer> iterator1 = integers.iterator();

        iterator1.forEachRemaining(integer -> {
            if (integer.equals(10)) {
                System.out.println("iterator should contain element 10. THIS statement should be executed");
            }
        });

        // Remove operation not supported for iterator while iterating over CopyOnWriteArrayList
        Iterator<Integer> iterator2 = integers.iterator();

        while (iterator2.hasNext()) {
            iterator2.remove();
        }

    }
}
