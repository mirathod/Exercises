package org.milan.core.polymorphism;

// overloading demo
// signature must be different
public class c1 {
	protected int add(int a, int b) {
		return ((a + b));
	}

	public int add(int a, int b, int c) {
		return (a + b + c);
	}

}
