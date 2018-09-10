package org.milan.core.generics;

class ABC<T, U> {
	private T t;

	public void setValue(T t) {
		this.t = t;
	}

	public T getValue() {
		return t;
	}

}

public class Demo1 {
	public static void main(String[] a) {
		ABC<Integer, String> c = new ABC<Integer, String>();
		c.setValue(5);
		System.out.println(c.getValue());

	}
}
