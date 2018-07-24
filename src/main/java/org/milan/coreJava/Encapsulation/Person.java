package org.milan.coreJava.Encapsulation;

import javax.swing.JOptionPane;

public class Person {
	private String name;
	private int weight;

	public String GetName() {
		return this.name;
	}

	public int GetWeight() {
		return this.weight;
	}

	public void SetName(String name) {
		this.name = name;

	}

	public void SetWeight(int weight) {
		if (weight > 0) {
			this.weight = weight;
		} else {
			JOptionPane.showMessageDialog(null, "Sorry U cannot set negative weight !!!");
		}

	}
}
