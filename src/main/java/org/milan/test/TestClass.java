package org.milan.test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TestClass {

	private Date d;
	private List<String> list;
	
	public static void main(String[] args) {
		List<String> l=new TestClass().getDate();
		System.out.println(l);
		l.remove(0);
		System.out.println(l);
		
		

	}
	
	public List<String> getDate(){
		list=new ArrayList<>();
		list.add("abc");
		list.add("xyz");
		return Collections.unmodifiableList(list);
		
	}

}
