package org.milan.core.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Milan Rathod
 */
public class HashMapDemo {
    public static void main(String[] a) {
        HashMap<String, Object> h = new HashMap<String, Object>();

        Animal2 a1 = new Animal2();
        a1.weight = 20;

        h.put("Color", "Red");
        h.put("animal instance", a1);
        //h.get("Color");
        Set<?> s = h.entrySet();
        for (Object o : s) {
            Map.Entry e = (Map.Entry) o;
            System.out.print(e.getKey().toString() + " :");
            System.out.println(e.getValue().toString());
        }


        System.out.println(h.get("Color"));
        System.out.println(((Animal2) h.get("animal instance")).weight);
    }

}

class Animal2 {
    int weight;
}