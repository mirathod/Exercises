package org.milan.coreJava.Polymorphism;

// overriding demo
// signature must be same
public class PolyDemo {

	public static void main(String[] a) {
		c1 c = new c1();
		System.out.println(c.add(10, 20)); // static binding == overloading
		c = new c2(); // parent class reference can refer to its Children
		System.out.println(c.add(10, 20)); // Dynamic binding == overriding
	}
}
