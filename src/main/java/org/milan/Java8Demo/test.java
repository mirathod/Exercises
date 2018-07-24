package org.milan.Java8Demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;
public class test implements Sample,Sample2{
	@Override
	public void test1() {
		Map<String,List<String>> map=new HashMap<>();
		List<String> ans=new ArrayList<>();
		ans.add("test 1");ans.add("test 2");
		map.put("ques 1", ans);
		List<String> ans2=new ArrayList<>();
		ans2.add("test 3");ans2.add("test 4");
		map.put("ques 2", ans2);
		System.out.println(map);
		map.forEach(new BiConsumer<String,List<String>>() {
			@Override
			public void accept(String str, List<String> list) {
				System.out.println(str);
				System.out.println(list);
			}
		});
	}
	@Override
	public void test2() {
		String str="sdfvsdf68fsdfsf8999fsdf09";
		Scanner sn=new Scanner(str).useDelimiter("[^\\d]+");
		while(sn.hasNext()){
		}
		System.out.println(sn.next()); 
		System.out.println(sn.next()); 
		   String numberOnly= str.replaceAll("[^0-9]", "");
		   System.out.println(numberOnly);   
	}
	public static void main(String[] args) {
		new test().test1();
		//new test().test2();
		//Sample2.test();
	}
}
