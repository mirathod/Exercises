package org.milan.datastructure;



public class ProbabilityPrime {
	public static void main(String[] args) {
		Euclid e=new Euclid();
		int rel=0,total=0;
		for(int i=1;i<=5;i++)
			for(int j=i+1;j<=5;j++){
				total++;
				if(e.Gcd(i,j)==1)
					rel++;
			}
		System.out.println("Percentage of relatively prime pairs is "+(double)rel/total);
	}

}
