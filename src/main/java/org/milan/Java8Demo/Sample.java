package org.milan.Java8Demo;

public interface Sample {

	void test1();
	
	default void test2(){
		System.out.println("Default test");
	}
}
