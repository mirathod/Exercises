package org.milan.hackerearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Monk Takes a Walk - Linear Search
 *
 * @author Milan Rathod
 */
class MonkTakesAWalk {
    public static void main(String args[]) throws Exception {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            list.add(s.next());
        }
        list.forEach(new Consumer<String>() {

            @Override
            public void accept(String str) {
                char[] arr = str.toCharArray();
                int count = 0;
                for (int i = 0; i < arr.length; i++) {
                    switch (arr[i]) {
                        case 'A':
                        case 'a':
                        case 'E':
                        case 'e':
                        case 'I':
                        case 'i':
                        case 'O':
                        case 'o':
                        case 'U':
                        case 'u':
                            count++;
                            break;

                    }
                }
                System.out.println(count);
            }

        });

    }
}
