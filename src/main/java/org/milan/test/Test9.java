package org.milan.test;

import java.util.Scanner;

public class Test9 {
	static int count = 1;

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int testCase = sn.nextInt();

		while ((testCase) > 0) {
			int i = 0;
			int n = sn.nextInt();
			int a[] = new int[n];
			while (i < n) {
				a[i] = sn.nextInt();
				i++;
			}
			String[] str = new Test9().match(a);
			new Test9().pattern(str);
			System.out.println();
			testCase--;
		}
	}

	public String[] match(int[] arr) {
		String a[] = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case 0:
				break;
			case 1:
				break;
			case 2:
				a[i] = "abc";
				break;
			case 3:
				a[i] = "def";
				break;
			case 4:
				a[i] = "ghi";
				break;
			case 5:
				a[i] = "jkl";
				break;
			case 6:
				a[i] = "mno";
				break;
			case 7:
				a[i] = "pqrs";
				break;
			case 8:
				a[i] = "tuv";
				break;
			case 9:
				a[i] = "wxyz";
				break;
			default:
				break;
			}
		}
		return a;
	}

	public void pattern(String[] str) {
		for (int i = 0; i < str[i].length(); i++) {

		}
	}

}
