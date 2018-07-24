package org.milan.Java8Demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sample3 {

	public static void main(String[] args) {
		List<String> values = Arrays.asList("1", "2", "3", "4", "5", "6");
		
		List<Integer> evenValues = values.stream()
										 .map(s -> Integer.valueOf(s))
										 .filter(number -> number%2 == 0)
										 .collect(Collectors.toList());
		
		System.out.println(evenValues);
									

	}

}
