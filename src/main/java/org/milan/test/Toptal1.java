package org.milan.test;

public class Toptal1 {
	public static void main(String[] args) {
		int[] a = new int[] { 5, 5, 2, 3, 3, 5, 5 };
		int m = new Toptal1().solution(5, a);
		System.out.println(m);
	}

	public int solution(int X, int[] a) {

		int count = 0;
		int result = 0, n = a.length, size = a.length;
		if (n == 0)
			return -1;
		for (int i = 0; i < a.length; i++) {
			if (X == a[i])
				count++;
		}
		for (int i = 0; i < a.length; i++) {
			if (X == a[i]) {
				result++;
				count--;
			}

			if ((size - count) == result)
				return i;
			size--;

		}
		return -1;
	}
}
