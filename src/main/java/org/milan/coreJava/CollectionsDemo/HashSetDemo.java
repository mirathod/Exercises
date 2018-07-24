/*
 * 
 * 
 */

package org.milan.coreJava.CollectionsDemo;

/**
 *
 * @author Aspire
 */
/*
 * 
 * 
 */

import java.util.*;

/**
 *
 * @author Aspire
 */
public class HashSetDemo {
    public static void main(String[] args){
        Animal3 a1=new Animal3();
        a1.weight=40;
        Animal3 a2=new Animal3();
        a2.weight=30;
        Animal3 a3=new Animal3();
        a3.weight=20;
        Animal3 a4=new Animal3();
        a4.weight=10;
        HashSet<Animal3> t=new HashSet<Animal3>();

        t.add(a1);
        t.add(a2);
        t.add(a3);
        t.add(a4);
        t.add(a1);  // set does not allow duplicates
        t.add(a2);



        System.out.println(t.size());
        for(Object o:t){
            System.out.println(((Animal3)o).weight);
        }

    }

}

class Animal3{
    int weight;
}
