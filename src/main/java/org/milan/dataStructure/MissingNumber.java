package org.milan.dataStructure;

public class MissingNumber {
public static void main(String[] args) {
	int a[] = {1, 2, 4, 5, 6};
    int miss = new MissingNumber().getMissingNo(a,a.length);
    System.out.println(miss);
}
int getMissingNo(int a[], int n)
{
    int i;
    int x1 = a[0]; /* For xor of all the elements in array */
    int x2 = 1; /* For xor of all the elements from 1 to n+1 */
     
    for (i = 1; i< n; i++)
        x1 = x1^a[i];
            
    for ( i = 2; i <= n+1; i++)
        x2 = x2^i;         
    
    return (x1^x2);
}
 
}
