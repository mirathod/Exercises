package org.milan.core.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class HashMapDemo {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(3, 0.75F);
        map.put("abc", 12);
        map.put("xyz", 18);
        map.put("pqr", 16);
        map.put("dff", 9);
        Set<Entry<String, Integer>> entrySet = map.entrySet();
        for (Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        HashMapDemo hashMapDemo = new HashMapDemo();

        // System.out.println(hashMapDemo.sortByComparator(map, true));

        hashMapDemo.sortByValues();

    }

    private Map<String, Integer> sortByComparator(Map<String, Integer> unsortedMap, final boolean order) {
        List<Entry<String, Integer>> list = new LinkedList<>(unsortedMap.entrySet());

        list.sort((o1, o2) -> {
            if (order) return o1.getValue().compareTo(o2.getValue());
            return o2.getValue().compareTo(o1.getValue());
        });

        return list.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a, b) -> b, LinkedHashMap::new));
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
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(collect);
    }
}
