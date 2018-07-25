package org.milan.sample;

import java.util.ArrayList;

public class ArrayListToArray {
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("one");
		a.add("two");
		a.add("three");
		a.add("four");
		String[] arr = new String[a.size()];
		a.toArray(arr);
		for (String s : arr) {
			System.out.println(s);
		}
	}
}
