package org.milan.core.thread;

import java.util.Scanner;

public class StringLength {
	public static void main(String[] a) throws InterruptedException {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a String To find its length :-");
		String s1 = s.nextLine();
		Thread t = new Thread(new LengthFinder(s1), "Mythread");
		t.start();
		t.join();
	}

}

class LengthFinder implements Runnable {

	String str;

	LengthFinder(String str) {
		this.str = str;
	}

	public void run() {
		System.out.println("Length of String is : " + str.length());
	}

}
