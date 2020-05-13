package org.milan.skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * Problem: Trick or Treat
 * Challenge: Thoughtworks Coding challenge
 *
 * @author Milan Rathod
 */
public class TrickOrTreat {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Total number of test cases
        int testCases = Integer.parseInt(bufferedReader.readLine());

        while (testCases-- > 0) {
            String[] input = bufferedReader.readLine().split(" ");

            // total boxes
            int totalBoxes = Integer.parseInt(input[0]);

            // number of orphanage children
            int numberOfChildren = Integer.parseInt(bufferedReader.readLine());

            Integer[] arr = new Integer[totalBoxes];

            for (int i = 1; i <= totalBoxes; i++) {
                arr[i - 1] = Integer.valueOf(input[i]);
            }

            Arrays.sort(arr, Collections.reverseOrder());

            for (int i = 0; i < totalBoxes; i++) {
                numberOfChildren -= arr[i];

                if (numberOfChildren == 0) {
                    System.out.println("YES");
                    break;
                } else if (numberOfChildren < 0) {
                    numberOfChildren += Integer.parseInt(input[i]);
                }
            }

            if (numberOfChildren != 0) {
                System.out.println("NO");
            }

        }
    }
}
