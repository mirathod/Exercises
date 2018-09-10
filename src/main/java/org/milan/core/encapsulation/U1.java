package org.milan.core.encapsulation;

public class U1 {

	public static void main(String[] s) {
		Person p = new Person();
		p.SetName("Yash");
		p.SetWeight(-60);
		System.out.println("Name: " + p.GetName());
		System.out.println("Weight: " + p.GetWeight());
	}

}
