package org.milan.core.thread;

import java.util.Scanner;

public class CalcThread {
    public static void main(String[] a) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter 1st Number :-");
        int n1 = s.nextInt();
        System.out.println("Enter 2nd Number :-");
        int n2 = s.nextInt();

        System.out.println("Enter Operation to be performed :-");
        String d = s.next();
        char op = d.charAt(0);
        if (op == '+' || op == '-' || op == '*' || op == '/') {
            Calculator c = new Calculator(n1, n2, op);
            Thread t = new Thread(c, "CalciThread");
            t.start();
            t.join();
        } else {
            System.out.println("Invalid Character !!!");
        }
    }
}

class Calculator implements Runnable {

    int n1;
    int n2;
    char op;
    int result;

    public Calculator(int n1, int n2, char op) {
        this.n1 = n1;
        this.n2 = n2;
        this.op = op;
    }

    public void run() {

        if (op == '+') {
            result = n1 + n2;
        } else if (op == '-') {
            result = n1 - n2;
        } else if (op == '*') {
            result = n1 * n2;
        } else {
            result = n1 / n2;
        }
        System.out.println("Result :- " + result);

    }

}