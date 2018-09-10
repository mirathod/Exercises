package org.milan.core.string;

public class CompareToDemo {
	static String[] a = { "Mango", "Apple", "Banana", "Chickoo", "Orange", "Grapes" };

	public static void main(String[] s) {
		// Bubble sort
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i].compareTo(a[j]) > 0) {
					String t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
			System.out.println(a[i]);
		}

	}

}
