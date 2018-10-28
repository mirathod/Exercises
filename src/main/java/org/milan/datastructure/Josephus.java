package org.milan.datastructure;

public class Josephus {
    public static void main(String[] args) {
        Josephus j = new Josephus();
        int lucky = j.luckyPerson(7, 3);
        System.out.println("Lucky Person is at no. " + lucky + " in circle");
    }

    public int luckyPerson(int n, int k) {
        if (n == 1) {
            return 1;
        } else {
            return (luckyPerson(n - 1, k) + k - 1) % n + 1;
        }
    }
}
