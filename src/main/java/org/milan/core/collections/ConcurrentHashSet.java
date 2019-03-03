package org.milan.core.collections;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Concurrent version of HashSet backed by ConcurrentHashMap
 *
 * @author Milan Rathod
 */
public class ConcurrentHashSet {

    public static void main(String[] args) {

        String property = System.getProperty("java.class.path");

        System.out.println("test" + property);
        ConcurrentHashMap<String, Integer> stringIntegerConcurrentHashMap = new ConcurrentHashMap<>();

        stringIntegerConcurrentHashMap.put("Test1", 111);
        stringIntegerConcurrentHashMap.put("Test2", 222);
        stringIntegerConcurrentHashMap.put("Test3", 333);
        stringIntegerConcurrentHashMap.put("Test4", 444);

        // using newKeySet method - java 8
        Set<String> concurrentHashSet = stringIntegerConcurrentHashMap.newKeySet();

        concurrentHashSet.add("Test1");
        concurrentHashSet.add("Test2");
        concurrentHashSet.add("Test3");

        // using keySet method
        Set<String> concurrentHashSet1 = stringIntegerConcurrentHashMap.keySet(254);
        concurrentHashSet1.add("Test1");
        concurrentHashSet1.add("Test2");

        // using keySet method
        Set<String> concurrentHashSet2 = stringIntegerConcurrentHashMap.keySet();

        // concurrentHashSet2.add("Test1"); -- will throw UnsupportedOperationExcetpion

    }
}
