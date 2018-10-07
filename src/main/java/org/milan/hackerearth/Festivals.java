package org.milan.hackerearth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Festivals - Basic of Hash Tables
 *
 * @author Milan Rathod
 */
public class Festivals {

    public static void main(String[] args) {
        // Scanner
        Scanner s = new Scanner(System.in);
        int testCases = Integer.parseInt(s.nextLine());

        while (testCases > 0) {
            int elements = Integer.parseInt(s.nextLine());
            Map<String, Integer> festivalSpendingMap = new HashMap<>();
            for (int i = 0; i < elements; i++) {
                String festival = s.nextLine();

                String[] tokens = festival.split(" ");

                String festivalName = tokens[0];

                int festivalAmount = Integer.parseInt(tokens[1]);

                if (festivalSpendingMap.containsKey(festivalName)) {
                    festivalSpendingMap.put(festivalName, festivalSpendingMap.get(festivalName) + festivalAmount);
                } else {
                    festivalSpendingMap.put(festivalName, festivalAmount);
                }
            }

            Map.Entry<String, Integer> maxEntry = null;

            for (Map.Entry<String, Integer> entry : festivalSpendingMap.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                    maxEntry = entry;
                } else if (entry.getValue().compareTo(maxEntry.getValue()) == 0) {
                    maxEntry = entry.getKey().compareTo(maxEntry.getKey()) > 0 ? maxEntry : entry;
                }
            }
            System.out.println(maxEntry.getKey() + " " + maxEntry.getValue());

            testCases--;
        }

    }

}
