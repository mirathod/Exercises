/*
 * 
 * 
 */

package org.milan.core.collections;

/**
 *
 * @author Aspire
 */
import java.util.Hashtable;
public class HashTableDemo {

    public static void main(String[] a)
    {
        Hashtable<String, Object> h=new Hashtable<String, Object>();
        h.put("one", (new Animal()));
        h.put("Two", new Animal().weight=20);

       System.out.println(h.get("Two"));
       System.out.println(h.get("one"));

    }


}
class Animal{
    int weight;
}