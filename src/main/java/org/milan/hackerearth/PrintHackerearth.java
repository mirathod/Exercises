package org.milan.hackerearth;

/**
 * {@link @https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/print-hackerearth/}
 *
 * @author Milan Rathod
 */
public class PrintHackerearth {

    public int printHackerearth(String inputString) {
        int a = 0;
        int h = 0;
        int c = 0;
        int k = 0;
        int e = 0;
        int r = 0;
        int t = 0;
        int count = 0;

        for (Character ch : inputString.toCharArray()) {
            switch (ch) {
                case 'a': {
                    a++;
                    break;
                }
                case 'h': {
                    h++;
                    break;
                }
                case 'c': {
                    c++;
                    break;
                }
                case 'k': {
                    k++;
                    break;
                }
                case 'e': {
                    e++;
                    break;
                }
                case 'r': {
                    r++;
                    break;
                }
                case 't': {
                    t++;
                    break;
                }
                default:
                    break;
            }
        }

        while (h >= 2 && a >= 2 && r >= 2 && e >= 2 && c >= 1 && k >= 1 && t >= 1) {
            h -= 2;
            a -= 2;
            r -= 2;
            e -= 2;
            c -= 1;
            k -= 1;
            t -= 1;
            count++;
        }
        return count;
    }
}
