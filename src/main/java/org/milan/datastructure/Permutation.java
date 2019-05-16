package org.milan.datastructure;

import java.util.Random;

/**
 * @author Milan Rathod
 */
public class Permutation {
    public static void main(String[] args) {

        int a[] = new Permutation().RandomGeneartor3(10);

        for (int i = 0; i < a.length; i++) {
            if (i != a.length - 1) {
                System.out.print(a[i] + ",");
            } else {
                System.out.print(a[i]);
            }
        }
    }

    //Algorithm 3 --O(n)
    int[] RandomGeneartor3(int n) {

        Random r = new Random();
        /**
         *
         * Second Way to Generate Random Number
         int i=(int)(Math.random()*10+1);
         System.out.println(i);*/

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i + 1;
        for (int i = n; i >= 1; ) {
            int k = r.nextInt(n);
            int temp = a[--i];
            a[i] = a[k];
            a[k] = temp;
        }
        return a;
    }

    //Algorithm 2 --O(n2)
    int[] RandomGeneartor2(int n) {

        Random r = new Random();
        /**
         *
         * Second Way to Generate Random Number
         int i=(int)(Math.random()*10+1);
         System.out.println(i);*/

        int[] a = new int[n];

        for (int i = 0; i < n; i++) a[i] = i + 1;

        int[] used = new int[n];

        for (int i = n; i >= 1; ) {
            int k;
            do {
                k = r.nextInt(n);
            } while (used[k] == 1);

            int temp = a[--i];
            a[i] = a[k];
            a[k] = temp;
            used[k] = 1;
        }
        return a;
    }

    //Algorithm 1 --O(n2)
    int[] RandomGeneartor1(int n) {

        Random r = new Random();
        /**
         *
         * Second Way to Generate Random Number
         int i=(int)(Math.random()*10+1);
         System.out.println(i);*/

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            int k;
            do {
                k = r.nextInt(n);
            } while (a[k] == 0);
            a[i] = a[k] + 1;

        }
        return a;
    }


}
