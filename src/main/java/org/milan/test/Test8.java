package org.milan.test;

import java.util.Scanner;

public class Test8 {
	static int count = 1;

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int testCase = sn.nextInt();
		while ((testCase) > 0) {
			int n = sn.nextInt();
			new Test8().pattern(n);
			System.out.println();
			testCase--;
		}
	}

	public void pattern(int n) {

		if (n > 0) {
			System.out.print(count + " ");
			count++;
			pattern(n - 1);
		}

	}
}
