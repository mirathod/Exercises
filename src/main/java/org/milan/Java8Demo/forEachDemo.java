package org.milan.Java8Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class forEachDemo {

	public static void main(String[] args) {
		
		
		List<Integer> myList=new ArrayList<Integer>();
		Objects.requireNonNull(null);
		for(int i=0; i<10; i++) myList.add(i);
		myList.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println("For each"+t);
				
			}
			
		});
		
		MyConsumer myConsumer=new MyConsumer();
		myList.forEach(myConsumer);
	}
}

class MyConsumer implements Consumer<Integer>{

	@Override
	public void accept(Integer t) {
		System.out.println("For each via class implemenatation"+t);
		
	}
	
}
