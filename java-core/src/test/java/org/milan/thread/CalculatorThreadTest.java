package org.milan.thread;

import org.junit.Test;

/**
 * Test Class for {@link CalculatorThread}
 *
 * @author Milan Rathod
 */
public class CalculatorThreadTest {

    @Test
    public void testCalculatorOpertions() {

        CalculatorThread calculatorThread = new CalculatorThread(10, 20, '+');

        Thread thread = new Thread(calculatorThread, "CalculatorThread");

        thread.start();

    }

}