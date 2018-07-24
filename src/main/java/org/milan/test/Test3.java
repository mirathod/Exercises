package org.milan.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test3 {
	public static void main(String[] a) throws Exception {
		B b1 = new B();
		b1.a = 15;
		b1.b = 20;
		System.out.println("Before" + b1.a + " " + b1.b);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc"));
		oos.writeObject(b1);
		oos.flush();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abc"));
		B z = (B) ois.readObject();
		System.out.println("After" + z.a + " " + z.b);

	}
}

class A {
	int a = 5;

	A() {
		System.out.println("A");
	}
}

class B extends A implements Serializable {
	int b = 10;

	B() {
		System.out.println("B");
	}
}
