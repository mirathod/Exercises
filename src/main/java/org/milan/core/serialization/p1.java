package org.milan.core.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class p1 {

	public static void main(String[] f) {

		Person p1 = new Person(10, 10);
		Person p2;
		try {
			FileOutputStream v = new FileOutputStream("Serial");
			ObjectOutputStream out = new ObjectOutputStream(v);
			out.writeObject(p1);
			out.flush();
			out.close();

			FileInputStream w = new FileInputStream("Serial");
			ObjectInputStream in = new ObjectInputStream(w);
			p2 = (Person) in.readObject();
			System.out.println("Height :" + p2.height + "  Weight :" + p2.weight + " Employeee " + p2.e.k);
			in.close();
			w.close();
			v.close();

		} catch (Exception e) {

			System.out.println(e.toString());
		}

	}

}

class Person implements Serializable {
	int height;
	transient int weight;
	Employee e;

	Person(int height, int weight) {
		this.height = height;
		this.weight = weight;
		e = new Employee();
		e.k = 10;
	}
}

class Employee implements Serializable {
	int k = 10;
}