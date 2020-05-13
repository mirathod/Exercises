package org.milan.core.thread;

/**
 * Example to create Deadlock
 *
 * @author Milan Rathod
 */
public class DeadLockDemo implements Runnable {

    TestA testA = new TestA();
    TestB testB = new TestB();

    private DeadLockDemo() {
        Thread.currentThread().setName("MainThread");
        Thread t = new Thread(this, "RacingThread");
        t.start();
        testA.foo(testB); // get lock on a in this thread.
        System.out.println("Back in main thread");
    }

    public void run() {
        testB.bar(testA); // get lock on b in other thread.
        System.out.println("Back in other thread");
    }

    public static void main(String[] args) {
        new DeadLockDemo();
    }
}

class TestA {

    synchronized void foo(TestB testB) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered foo method");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("TestA Interrupted");
        }
        System.out.println(name + " trying to call TestA.last()");
        testB.last();
    }

    synchronized void last() {
        System.out.println("Inside TestA.last()");
    }
}

class TestB {

    synchronized void bar(TestA testA) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered bar method");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("TestB Interrupted");
        }
        System.out.println(name + " trying to call TestB.last()");
        testA.last();
    }

    synchronized void last() {
        System.out.println("Inside TestB.last()");
    }
}
