package org.milan.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class GiftVouchers {

    private static Map<Integer, List<Integer>> passengerList = new HashMap<>();

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int totalPassangers = Integer.parseInt(firstLine[0]);
        int connections = Integer.parseInt(firstLine[1]);
        int selectedPassangers = Integer.parseInt(firstLine[2]);

        List<Integer> output = new ArrayList<>();

        while (connections-- > 0) {
            String[] secondLine = br.readLine().split(" ");
            int p1 = Integer.parseInt(secondLine[0]);
            int p2 = Integer.parseInt(secondLine[1]);
            arrangePassangers(p1, p2);

        }

        passengerList.forEach((integer, integers) -> {
            Collections.sort(integers);
            Object[] values = integers.toArray();
            for (int i = selectedPassangers - 1; i< values.length;) {
                output.add((Integer) values[i]);
                i += selectedPassangers;
            }
        });
        System.out.println(output.size());
        Collections.sort(output);
        output.stream().forEach(integer -> {
            System.out.print(integer + " ");
        });
    }

    private static void arrangePassangers(int p1, int p2) {

        List<Integer> newEntry = new ArrayList<>();

        if (count == 0) {
            newEntry.add(p1);
            newEntry.add(p2);
            passengerList.put(count, newEntry);
            count++;
            return;
        }

        passengerList.forEach((integer, integers) -> {
            if (integers.contains(p1)) {
                integers.add(p2);
            } else if (integers.contains(p2)) {
                integers.add(p1);
            } else {
                newEntry.add(p1);
                newEntry.add(p2);
            }
        });

        if (newEntry.isEmpty()) {
            passengerList.put(count, newEntry);
            count++;
        }

    }
}
