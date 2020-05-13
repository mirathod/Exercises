package org.milan.core;

import lombok.Data;

/**
 * Examples of synchronization keyword use cases
 *
 * @author Milan Rathod
 */
@Data
public class SynchronizationDemo {

    private int sum = 0;

    private static int staticSum = 0;

    /**
     * Instance method without synchronization
     */
    public void calculate() {
        setSum(getSum() + 1);
    }

    /**
     * Instance method with synchronization
     */
    public synchronized void calculateV2() {
        setSum(getSum() + 1);
    }

    /**
     * Static method with synchronization
     */
    public static synchronized void calculateV3() {
        staticSum += 1;
    }

    /**
     * Instance method with synchronized block
     */
    public void calculateV4() {
        synchronized (this) {
            setSum(getSum() + 1);
        }
    }

    /**
     * Static method with synchronized block
     */
    public static void calculateV5() {
        synchronized (SynchronizationDemo.class) {
            staticSum += 1;
        }
    }

    /**
     * Return staticSum
     */
    public static int getStaticSum() {
        return staticSum;
    }

    /**
     * Set staticSum to 0
     */
    public static void clearStaticSum() {
        staticSum = 0;
    }
}
