package org.milan.coreJava.StringDemo;

public class DiffEqualDemo {
	public static void main(String[] s) {
		Animal a1 = new Animal();
		a1.weight = 10;
		Animal a2 = new Animal();
		a2.weight = 10;

		if (a1 == a2) {
			System.out.println("objects cannot be compared through ==");
		}

		if (a1.equals(a2)) {
			System.out.println("can be compared if equal method is overridden");
		}

		String s1 = "Hello";
		String s2 = new String("Hello");
		if (s1.equals(s2)) {
			System.out.println("Are Equal using equals"); // for String equal method is already overridden
		}
		if (s1 == s2) {
			System.out.println("Are Equal using ==");
		}
	}

}

class Animal {
	int weight;

	@Override
	public boolean equals(Object o) {
		boolean flag = false;
		if (this.weight == ((Animal) o).weight) {
			flag = true;
		}
		return flag;

	}
}
