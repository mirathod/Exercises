package org.milan.Java8Demo;

public interface Sample2 {

	default void test2(){
		System.out.println("Default test");
	}
	
	static void test(){
		System.out.println("Test");
	}
}
