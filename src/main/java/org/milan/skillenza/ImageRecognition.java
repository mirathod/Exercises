package org.milan.skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem: Image Recognition
 * Challenge: Amazon Interview Arrays Tutorial
 *
 * @author Milan Rathod
 */
public class ImageRecognition {

    private static List<String> store = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bufferedReader.readLine());

        while (testCase-- > 0) {

            // Total number of 1's in matrix
            int totalCount = 4;

            String shape = "";

            int number = Integer.parseInt(bufferedReader.readLine());

            for (int i = 0; i < number; i++) {

                String line = bufferedReader.readLine();

                if (line.contains("1")) {
                    long count = line.chars().filter(value -> value == 49).count();

                    // if three 1's in one row then triangle for sure
                    if (count == 3 || count == 1) {
                        shape = "triangle";
                        break;
                    }

                    storePosition(i, line);
                    totalCount -= count;
                }

                if (totalCount == 0) {
                    break;
                }

            }

            if ("triangle".equals(shape)) {
                System.out.println(shape);
            } else {
                Collections.sort(store);

                int columnDiff = Integer.parseInt(store.get(1)) - Integer.parseInt(store.get(0));

                int rowDiff = store.get(2).charAt(0) - store.get(0).charAt(0);

                if (columnDiff == rowDiff) {
                    System.out.println("square");
                } else {
                    System.out.println("rectangle");
                }

            }

            store.clear();

        }
    }

    private static void storePosition(int row, String line) {
        for (int j = 0; j < line.length(); j++) {
            if (line.charAt(j) == 49) {
                store.add(row + "" + j);
            }
        }
    }

}
