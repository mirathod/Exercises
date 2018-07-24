package org.milan.coreJava.InstanceDemo;

interface ABC {

}

class A implements ABC {

}

class B extends A {
}

public class P1 {
	public static void main(String[] a) {
		A a1 = new A();
		B b1 = new B();

		ABC a2 = new A();

		if (b1 instanceof B) {
			System.out.println("b1 instance of B");
		}
		if (b1 instanceof A) {
			System.out.println("b1 instance of A");
		}

		if (b1 instanceof ABC) {
			System.out.println("b1 instance of  ABC");
		}

		if (a1 instanceof A) {
			System.out.println("a1 instance of  A");
		}
		if (a1 instanceof B) {
			System.out.println("a1 instance of B");
		}
		if (a1 instanceof ABC) {
			System.out.println("a1 instance of ABC");
		}

		if (a2 instanceof A) {

			System.out.println("a2 instance of A"); // it depends on which object it is called and not on which
													// reference
		}
	}
}
