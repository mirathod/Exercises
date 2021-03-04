package org.milan.thread;

/**
 * Thread to perform various calculator operations
 *
 * @author Milan Rathod
 */
public class CalculatorThread implements Runnable {

    private final double firstOperand;

    private final double secondOperand;

    private final char operation;

    public CalculatorThread(double firstOperand, double secondOperand, char operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
    }

    public void run() {
        double result;
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