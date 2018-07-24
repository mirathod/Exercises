package org.milan.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//Hacker Earth - Problem : Sheldon and Array
class HackerEarth7 {
      public static void main(String args[]) throws Exception {
 
 
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int buf = s.nextInt();
            int index_value = -1;
            int gcd = 0;
            for (int j = 1; j <= Math.sqrt(buf); j++) {
                if (buf % j == 0) {
                    //System.out.println( j);
                    int divj = buf / j;
                    if (map.containsKey(j)) {
                        if (j >= gcd) {
                            gcd = j;
                            index_value = map.get(j);
                            //System.out.println(index_value +"--- index cval \n");
 
                        }
                    }
                    if (map.containsKey(divj)) {
                        if (divj >= gcd) {
                            gcd = divj;
                            index_value = map.get(divj);
                            //System.out.println(index_value +"--- index cval \n");
 
                        }
                    }
                    map.put(j, i + 1);
                    map.put(divj, i + 1);
                }
            }
            System.out.print(""+index_value + " ");
        }
    }
    
}