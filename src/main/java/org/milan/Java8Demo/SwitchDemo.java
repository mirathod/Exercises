package org.milan.Java8Demo;

import java.lang.management.ManagementFactory;
import java.lang.Enum;
import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwitchDemo{

	public static void main(String[] args) {
		Map<String,String> map=new HashMap<>();
		map.put("abc", "test");
		map.put("abc", "test1");
		System.out.println(map);
		NumberFormat.getInstance();
		List<String> list=ManagementFactory.getRuntimeMXBean().getInputArguments();
		for(String str:list){
			System.out.println(str);
		}
		
	}
	
}
enum Currency{
	PENNY(1);
	private int value;
	private Currency(int value){
		this.value=value;
	}
};