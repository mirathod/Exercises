package org.milan.core;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(3, 0.75F);
        map.put("abc", 12);
        map.put("xyz", 12);
        map.put("pqr", 12);
        map.put("dff", 12);
        Set<Entry<String, Integer>> entrySet = map.entrySet();
        for (Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        new HashMapDemo().sortByValues();

    }

    public static <K, V extends Comparable<V>> Map<K, V>
    sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =
                new Comparator<K>() {
                    public int compare(K k1, K k2) {
                        int compare =
                                map.get(k2).compareTo(map.get(k1));
                        if (compare == 0)
                            return 1;
                        else
                            return compare;
                    }
                };

        Map<K, V> sortedByValues =
                new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    public void sortByValues() {
        Map<String, Integer> expenses = new HashMap<>();

        expenses.put("clothes", 120);
        expenses.put("grocery", 150);
        expenses.put("transportation", 100);
        expenses.put("utility", 130);
        expenses.put("rent", 1150);
        expenses.put("miscellneous", 90);

        Map<String, Integer> collect = expenses
                .entrySet()
                .stream()
                .sorted(Entry.comparingByValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        System.out.println(collect);
    }
}
