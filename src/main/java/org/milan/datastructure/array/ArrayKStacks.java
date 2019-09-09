package org.milan.datastructure.array;

/**
 * Implement stack with k arrays
 *
 * @author Milan Rathod
 */
public class ArrayKStacks {

    int free;

    int k;

    int n;

    int[] arr;

    int[] next;

    int[] top;

    public static void main(String[] args) {
        ArrayKStacks aks = new ArrayKStacks(3, 10);
        aks.push(15, 2);
        aks.push(30, 1);
        aks.push(20, 0);
        aks.push(13, 1);
        aks.push(25, 0);
        aks.pop(2);
        aks.pop(1);
        aks.pop(1);
        aks.pop(0);
        aks.pop(0);
        aks.pop(0);

    }

    public ArrayKStacks(int k, int n) {
        this.k = k;
        this.n = n;
        arr = new int[n];
        next = new int[n];
        top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = -1;
        }
        free = 0;
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
    }

    private boolean isOverflow() {
        return free == -1;
    }

    private boolean isUnderflow(int sn) {
        return top[sn] == -1;
    }

    private void push(int value, int sn) {
        if (isOverflow()) {
            System.out.println("Stack is overflow");
        }
        int i = free;
        free = next[i];
        next[i] = top[sn];
        top[sn] = i;
        arr[i] = value;
        System.out.println("Stack " + sn + " = " + arr[i]);

    }

    private int pop(int sn) {
        if (isUnderflow(sn)) {
            System.out.println("Stack is underflow");
        }
        int i = top[sn];
        top[sn] = next[i];
        next[i] = free;
        free = i;
        System.out.println("Stack " + sn + " = " + arr[i]);
        return arr[i];
    }
}
