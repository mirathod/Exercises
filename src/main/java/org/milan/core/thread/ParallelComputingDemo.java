package org.milan.core.thread;

import java.util.Scanner;

/**
 * @author Milan Rathod
 */
public class ParallelComputingDemo {

    static int sum = 0;
    static int[][] a = new int[3][3];
    static Scanner s = new Scanner(System.in);

    public static void main(String[] g) {

        for (int j = 0; j < a.length; j++) {
            for (int k = 0; k < a[j].length; k++) {
                a[j][k] = s.nextInt();
            }
        }
        for (int i = 0; i < a.length; i++) {
            ParallelComputing p = new ParallelComputing(a[i]);
            Thread t = new Thread(p);
            t.setName(String.valueOf(i));
            t.start(); // starts the thread
            try {
                t.join(); // waits for the thread to finish first
            } catch (InterruptedException ex) {
                System.out.println("Join:- Exception Caught");
            }
        }
        System.out.println(" Final Sum :=" + sum);
    }
}
