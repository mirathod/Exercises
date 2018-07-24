package org.milan.coreJava.Thread;

import java.util.Scanner;

// asked in KT exam of Java
public class ParrallComputingDemo {

	static int sum = 0;
	static int a[][] = new int[3][3];
	static Scanner s = new Scanner(System.in);

	public static void main(String[] g) {

		for (int j = 0; j < a.length; j++) {
			for (int k = 0; k < a[j].length; k++) {
				a[j][k] = s.nextInt();
			}
		}
		for (int i = 0; i < a.length; i++) {
			PC p = new PC(a[i]);
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

class PC implements Runnable {
	int a[];

	PC(int b[]) {
		a = b;
	}

	public void run() {
		int localsum = 0;
		for (int i = 0; i < a.length; i++) {
			localsum += a[i];
		}

		synchronized (this) {
			System.out.println("  Sum of Thread " + Thread.currentThread().getName() + "=" + localsum);
			ParrallComputingDemo.sum += localsum;
		}
	}
}
