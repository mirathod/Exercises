package org.milan.coreJava.CollectionsDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<Comparable> a1 = new ArrayList<Comparable>();
		ArrayList<Animal1> a2 = new ArrayList<Animal1>(); // using generics
		a1.add(new Animal1());
		a1.add(new Animal1());
		a1.add("Animal");
		// a1.add(new Integer(42));

		a2.add(new Animal1());
		a2.add(new Animal1());
		// a2.add("Animal");
		// a2.add(new Integer(42));

		Iterator<Comparable> i = a1.iterator();

		while (i.hasNext()) {
			System.out.println(i.next().toString());
		}

		// Collections.sort(a1);

		// Alternate way
		for (Object o : a1) {
			System.out.println(o.toString());
		}

		Object[] arrayFromArrayList = a1.toArray(); // obtaining array from ArrayList

		for (Object o : arrayFromArrayList) {
			System.out.println(o.toString());
		}

	}

}

class Animal1 implements Comparable<Object> {
	int height;
	int weight;

	@Override
	public String toString() {
		return ("Height :-" + height + " and weight:-" + weight);
	}

	public int compareTo(Object o) {
		return 1;
	}
}
