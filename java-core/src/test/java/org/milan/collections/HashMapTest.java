package org.milan.collections;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link java.util.HashMap}
 *
 * @author Milan Rathod
 */
public class HashMapTest {

    @Test
    public void givenExistingKey_whenPutReturnsPrevValue() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "val1");

        String rtnVal = map.put("key1", "val2");

        assertEquals("val1", rtnVal);
    }

    @Test
    public void givenNewKey_whenPutReturnsNull() {
        Map<String, String> map = new HashMap<>();

        String rtnVal = map.put("key1", "val1");

        assertNull(rtnVal);
    }

    @Test
    public void givenNullVal_whenPutReturnsNull() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", null);

        String rtnVal = map.put("key1", "val1");

        assertNull(rtnVal);
    }

    @Test
    public void whenContainsDistinguishesNullValues() {
        Map<String, String> map = new HashMap<>();

        String val1 = map.get("key");
        boolean valPresent = map.containsKey("key");

        assertNull(val1);
        assertFalse(valPresent);

        map.put("key", null);
        String val = map.get("key");
        valPresent = map.containsKey("key");

        assertNull(val);
        assertTrue(valPresent);
    }

    @Test
    public void givenKeySet_whenChangeReflectsInMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "test");
        map.put("type", "blog");

        assertEquals(2, map.size());

        Set<String> keys = map.keySet();
        keys.remove("name");

        assertEquals(1, map.size());
        assertFalse(map.containsKey("name"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void givenIterator_whenFailsFastOnModification() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "test");
        map.put("type", "blog");

        // If any structural modification is made on the map, after the iterator has been created
        // a concurrent modification exception will be thrown
        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();
        map.remove("type");
        while (it.hasNext()) {
            String key = it.next();
        }
    }

    @Test
    public void givenIterator_whenRemoveWorks() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "test");
        map.put("type", "blog");

        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();

        while (it.hasNext()) {
            it.next();

            // Structural modification via remove method of iterator is allowed
            it.remove();
        }

        assertEquals(0, map.size());
    }

    @Test
    public void whenCallsEqualsOnCollision() {
        Map<MyKey, String> map = new HashMap<>();
        MyKey k1 = new MyKey(1, "firstKey");
        MyKey k2 = new MyKey(2, "secondKey");
        MyKey k3 = new MyKey(2, "thirdKey");

        System.out.println("storing value for k1");
        map.put(k1, "firstValue");
        System.out.println("storing value for k2");
        map.put(k2, "secondValue");
        System.out.println("storing value for k3");
        map.put(k3, "thirdValue");

        System.out.println("retrieving value for k1");
        String v1 = map.get(k1);
        System.out.println("retrieving value for k2");
        String v2 = map.get(k2);
        System.out.println("retrieving value for k3");
        String v3 = map.get(k3);

        assertEquals(2, map.size());
        assertEquals("firstValue", v1);
        assertEquals("thirdValue", v2);
        assertEquals("thirdValue", v3);
    }
}
