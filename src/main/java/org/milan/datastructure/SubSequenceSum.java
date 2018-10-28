package org.milan.datastructure;

/**
 * @author Milan Rathod
 */
public class SubSequenceSum {
    public static void main(String[] args) {
        int[] a = new int[]{-2, 11, -4, 13, -5, -2};
        int[] a1 = new int[]{4, -3, 5, -2, -1, 2, 6, -2};
        long sum1 = new SubSequenceSum().MaxSubSequenceSum1(a, a.length);
        long sum2 = new SubSequenceSum().MaxSubSequenceSum2(a, a.length);
        long sum3 = new SubSequenceSum().MaxSubSequenceSum2(a1, a1.length);
        long sum4 = new SubSequenceSum().MaxSubSequenceSum4(a, a.length);
        System.out.println("Maximun Sub Sequence Sum is : " + sum1);
        System.out.println("Maximun Sub Sequence Sum is : " + sum2);
        System.out.println("Maximun Sub Sequence Sum is : " + sum3);
        System.out.println("Maximun Sub Sequence Sum is : " + sum4);

    }

    // Algorithm 1 -- O(N3)
    long MaxSubSequenceSum1(int[] a, int n) {
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += a[k];
                }
                if (sum > maxSum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }

    // Algorithm 2 --O(N2)
    long MaxSubSequenceSum2(int[] a, int n) {
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];

                if (sum > maxSum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }

    // Algorithm 3 --O(NLogN)
    long MaxSubSequenceSum3(int[] a, int b) {
        return MaxSubSequnceSum(a, 0, b - 1);
    }

    // Algorithm 4 --O(N)
    long MaxSubSequenceSum4(int[] a, int b) {
        int sum = 0, maxSum = 0;
        for (int i = 0; i < b; i++) {
            sum += a[i];
            if (sum > maxSum)
                maxSum = sum;
            else if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }

    static int MaxSubSequnceSum(int a[], int left, int right) {
        int MaxLeftSum, MaxRightSum;
        int MaxLeftBorderSum, MaxRightBorderSum;
        int LeftBorderSum, RightBorderSum;
        int Center, i;
        if (left == right) {
            if (a[left] > 0)
                return a[left];
            else
                return 0;
        }
        Center = (left + right) / 2;
        MaxLeftSum = MaxSubSequnceSum(a, left, Center);
        MaxRightSum = MaxSubSequnceSum(a, Center + 1, right);

        MaxLeftBorderSum = 0;
        LeftBorderSum = 0;
        for (i = Center; i >= left; i--) {
            LeftBorderSum += a[i];
            if (LeftBorderSum > MaxLeftBorderSum)
                MaxLeftBorderSum = LeftBorderSum;
        }

        MaxRightBorderSum = 0;
        RightBorderSum = 0;
        for (i = Center + 1; i <= right; i++) {
            RightBorderSum += a[i];
            if (RightBorderSum > MaxRightBorderSum)
                MaxRightBorderSum = RightBorderSum;
        }
        return max3(MaxLeftSum, MaxRightSum, MaxLeftBorderSum
                + MaxRightBorderSum);
    }

    static int max3(int a, int b, int c) {
        if (a >= b) {
            if (a >= c) {
                return a;
            }
        } else {
            if (b >= c) {
                return b;
            }
        }
        return c;
    }
}
