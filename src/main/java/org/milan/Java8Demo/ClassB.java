package org.milan.Java8Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

class Foo<X>{
	Foo(X x){}
	Foo<X> get(X x){
		return this;
	}
}


public class ClassB {
	
	public static void test(){
		print();
	}
	public static void print(){
		List<String> list=new ArrayList<>();
		
		
	}
	
}
class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}