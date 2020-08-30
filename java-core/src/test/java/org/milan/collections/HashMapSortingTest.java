package org.milan.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link HashMapSorting}
 *
 * @author Milan Rathod
 */
class HashMapSortingTest {

    private Map<String, Integer> map;

    private HashMapSorting hashMapSorting;

    @BeforeEach
    void setUp() {
        hashMapSorting = new HashMapSorting();
        map = new HashMap<>();
        map.put("clothes", 120);
        map.put("grocery", 150);
        map.put("transportation", 100);
        map.put("utility", 130);
        map.put("rent", 1150);
        map.put("miscellaneous", 90);
    }

    @Test
    void testSortByValuesUsingComparator_ASC() {
        Map<String, Integer> sortedMap = hashMapSorting.sortByValuesUsingComparator(map, false);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            assertEquals(90, entry.getValue().intValue());
            break;
        }
    }

    @Test
    void testSortByValuesUsingComparator_DESC() {
        Map<String, Integer> sortedMap = hashMapSorting.sortByValuesUsingComparator(map, true);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            assertEquals(1150, entry.getValue().intValue());
            break;
        }
    }

    @Test
    void testSortByValues() {
        Map<String, Integer> sortedMap = hashMapSorting.sortByValues(map);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            assertEquals(90, entry.getValue().intValue());
            break;
        }
    }
}