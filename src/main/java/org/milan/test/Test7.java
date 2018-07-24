package org.milan.test;

import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int testCase = sn.nextInt();
		while ((testCase) > 0) {
			int n = sn.nextInt();
			new Test7().pattern(n);
			System.out.println();
			testCase--;
		}
	}

	public void pattern(int n) {
		if (n > 0) {
			System.out.print(n + " ");
			pattern(n - 5);
			System.out.print(n + " ");
		} else if (n <= 0) {
			System.out.print(n + " ");
		}

	}
}
