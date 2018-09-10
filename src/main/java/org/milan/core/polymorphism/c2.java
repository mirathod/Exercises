package org.milan.core.polymorphism;

public class c2 extends c1 {
	@Override // u can change return type of overridded method only if it is a subclass
	public int add(int a, int b) throws IndexOutOfBoundsException { // u can make protected method of superclass public
																	// while overriding
		return ((2 * (a + b)));
	}
}
// levels private , Default , Protected ,public
