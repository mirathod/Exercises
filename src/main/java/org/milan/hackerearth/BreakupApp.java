package org.milan.hackerearth;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Breakup App - Linear Search
 *
 * @author Milan Rathod
 */
public class BreakupApp {
    private int date = 0, noDate = 0;

    public String getDate(List<String> list) {

        list.forEach(str -> {
            Scanner sn = new Scanner(str).useDelimiter("[^\\d]+");
            if (str.startsWith("G")) {
                while (sn.hasNext()) {
                    String num = sn.next();
                    if (num.equals(String.valueOf(19)) || num.equals(String.valueOf(20))) {
                        date += 2;
                    } else {
                        noDate += 2;
                    }
                }
            } else {

                while (sn.hasNext()) {
                    String num = sn.next();
                    if (num.equals(String.valueOf(19)) || num.equals(String.valueOf(20))) {
                        date += 1;
                    } else {
                        noDate += 1;
                    }
                }

            }

        });
        if (date > noDate) {
            return "Date";
        }
        return "No Date";
    }
}
