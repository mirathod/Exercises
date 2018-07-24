package org.milan.Java8Demo;

import java.util.List;

public class ClassA {

	private String name;
	protected List<String> list=null;
	
	public List<String> getAsList(){
		return null;
	}

	public ClassA(String name) {
		super();
		this.name = name;
	}
	public ClassA(){
		
	}
	private String test(){
		return "test method";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
