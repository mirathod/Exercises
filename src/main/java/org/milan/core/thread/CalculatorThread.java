package org.milan.core.thread;

/**
 * Thread to perform various calculator operations
 *
 * @author Milan Rathod
 */
public class CalculatorThread implements Runnable {

    private double firstOperand;

    private double secondOperand;

    private char operation;

    private double result;

    public CalculatorThread(double firstOperand, double secondOperand, char operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
    }

    public void run() {

        if (operation == '+') {
            result = firstOperand + secondOperand;
        } else if (operation == '-') {
            result = firstOperand - secondOperand;
        } else if (operation == '*') {
            result = firstOperand * secondOperand;
        } else {
            result = firstOperand / secondOperand;
        }
        System.out.println("Result :- " + result);

    }

}