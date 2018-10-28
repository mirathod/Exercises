package org.milan.datastructure;

public class RadixSort {
    public static void main(String[] args) {
        //int[] a=new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        int[] a = new int[]{64, 8, 216, 512, 27, 729, 0, 1, 343, 125};
        new RadixSort().sort(a);
    }

    public void sort(int[] a) {
        int m = getMax(a);
        System.out.println(m);
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countingSort(a, exp);
        }
        print(a);
    }

    public int getMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }

    public void countingSort(int[] a, int exp) {
        int count[] = new int[10];

        int output[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int z = (a[i] / exp) % 10;
            count[z]++;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + ",");

        }
        System.out.println();
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        System.out.println();
        for (int i = a.length - 1; i >= 0; i--) {
            output[count[(a[i] / exp) % 10] - 1] = a[i];
            --count[(a[i] / exp) % 10];
        }
        for (int i = 0; i < output.length; i++)
            a[i] = output[i];
    }

    public void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }
}
