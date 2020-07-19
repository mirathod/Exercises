package org.milan.core.collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Test class for {@link HashMapSorting}
 *
 * @author Milan Rathod
 */
public class HashMapSortingTest {

    private Map<String, Integer> map;

    private HashMapSorting hashMapSorting;

    @Before
    public void setUp() {
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
    public void testSortByValuesUsingComparator_ASC() {
        Map<String, Integer> sortedMap = hashMapSorting.sortByValuesUsingComparator(map, false);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            Assert.assertEquals(90, entry.getValue().intValue());
            break;
        }
    }

    @Test
    public void testSortByValuesUsingComparator_DESC() {
        Map<String, Integer> sortedMap = hashMapSorting.sortByValuesUsingComparator(map, true);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            Assert.assertEquals(1150, entry.getValue().intValue());
            break;
        }
    }

    @Test
    public void testSortByValues() {
        Map<String, Integer> sortedMap = hashMapSorting.sortByValues(map);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            Assert.assertEquals(90, entry.getValue().intValue());
            break;
        }
    }
}