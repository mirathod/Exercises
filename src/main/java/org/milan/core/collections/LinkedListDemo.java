/*
 * 
 * 
 */

package org.milan.core.collections;

import java.util.*;

/**
 *
 * @author Aspire
 */
public class LinkedListDemo {

     public static void main(String[] args){
         LinkedList<String> l=new LinkedList<String>();

         l.add("LD");
         l.add("IS");
         l.add("THE");
         l.add("BEST");
         l.add("ENGINEERING");
         l.add("COLLEGE");

         System.out.println(l.getFirst());
         System.out.println(l.getLast());
         l.removeFirst();
         l.removeLast();



         System.out.println(l.offerFirst("Aspire"));
         System.out.println(l.offerLast("Institute"));

         Iterator<String> i=l.descendingIterator();

         while(i.hasNext()){
             System.out.println(i.next());
         }
     }
}
