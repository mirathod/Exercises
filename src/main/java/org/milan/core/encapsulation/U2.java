package org.milan.core.encapsulation;

public class U2 {
	public static void main(String[] s) {
		Person p = new Person();
		p.SetName("Manish");
		p.SetWeight(-40);

		System.out.println("Name: " + p.GetName());
		System.out.println("Weight: " + p.GetWeight());
	}
}
