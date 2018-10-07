package org.milan.hackerearth;

import java.util.Scanner;

/**
 * Last Occurrence - Linear Search
 *
 * @author Milan Rathod
 */
public class LastOccurrence {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int[] arr = new int[N];
        int count = 0;
        while (N > 0) {
            arr[count] = s.nextInt();
            N--;
            count++;
        }

        System.out.println(calculate(arr, M));

    }

    public static int calculate(int[] arr, int M) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (M == arr[i]) {
                index = i + 1;
            }
        }

        return index;
    }

}
