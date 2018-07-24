package org.milan.coreJava.StaticDemo;

public class ABC {
	static int count;
	int j;

	public ABC() {
		count++;
		System.out.println("Inside Constructor");
	}

	// instance block
	{
		System.out.println("Inside Instance Block");
	}
	// static block
	static {
		System.out.println("Static block is executed first and only once.");
	}

	public static void sayHello() {

		System.out.println("Hello LDites");
	}

}
