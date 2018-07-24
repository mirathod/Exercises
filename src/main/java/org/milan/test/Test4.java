package org.milan.test;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int testCase = sn.nextInt();
		while ((testCase * 2) > 0) {
			int n = sn.nextInt();
			int k = sn.nextInt();
			System.out.println(new Test4().luckyPerson(n, k));
			testCase--;
		}
	}

	public int luckyPerson(int n, int k) {
		if (n == 1) {
			return 1;
		} else {
			return (luckyPerson(n - 1, k) + k - 1) % n + 1;
		}
	}
}
