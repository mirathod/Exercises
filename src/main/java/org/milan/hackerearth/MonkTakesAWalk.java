package org.milan.hackerearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Monk Takes a Walk - Linear Search
 * @author rathom1
 *
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
						count++;
						break;
					case 'a':
						count++;
						break;
					case 'E':
						count++;
						break;
					case 'e':
						count++;
						break;
					case 'I':
						count++;
						break;
					case 'i':
						count++;
						break;
					case 'O':
						count++;
						break;
					case 'o':
						count++;
						break;
					case 'U':
						count++;
						break;
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
