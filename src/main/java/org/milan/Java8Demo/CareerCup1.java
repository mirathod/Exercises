package org.milan.Java8Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CareerCup1 {

	public static void main(String[] args) {
		int[] A={126,110,130};
		int[] B={125};
		int[] C={105,115};
		Arrays.sort(A);Arrays.sort(B);Arrays.sort(C);
		int max=(B[B.length-1]>C[C.length-1])?B[B.length-1]:C[C.length-1];
		System.out.println(max);
		for(int min:A){
			if(min>max){
				max=min;
				break;
			}
		}
		ArrayList<Integer> a=new ArrayList<>();
		a.add(45);
		Iterator<Integer> it=a.iterator();
		a.add(3);
		while(it.hasNext()){
			System.out.println(it.next());
		}
	
	}

}
