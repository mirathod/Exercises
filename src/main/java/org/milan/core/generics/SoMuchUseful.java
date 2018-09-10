package org.milan.core.generics;

import java.util.ArrayList;
import java.util.Collection;

class ABCD {
	static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
		for (T o : a) {
			c.add(o); // Correct
		}

	}

}

public class SoMuchUseful {
	public static void main(String[] a) {
		String s[] = { "Shailesh", "Mohan", "Rohan" };
		ArrayList<String> Stringlist = new ArrayList<String>();
		ABCD.fromArrayToCollection(s, Stringlist);

		Integer i[] = { 12, 23, 34, 45 };
		ArrayList<Integer> IntegerList = new ArrayList<Integer>();
		ABCD.fromArrayToCollection(i, IntegerList);

		Float f[] = { 2.3f, 4.5f, 5.4f };
		ArrayList<Float> FloatList = new ArrayList<Float>();
		ABCD.fromArrayToCollection(f, FloatList);

	}
}
