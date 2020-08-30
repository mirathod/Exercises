package org.milan.thread;

import org.junit.jupiter.api.Test;

/**
 * Test Class for {@link CalculatorThread}
 *
 * @author Milan Rathod
 */
class CalculatorThreadTest {

    @Test
    void testCalculatorOperations() {

        CalculatorThread calculatorThread = new CalculatorThread(10, 20, '+');

        Thread thread = new Thread(calculatorThread, "CalculatorThread");

        thread.start();
    }

}