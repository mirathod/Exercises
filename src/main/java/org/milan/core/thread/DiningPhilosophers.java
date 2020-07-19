package org.milan.core.thread;

/**
 * Dining Philosophers problem
 * <p>
 * Problem: {@link @https://www.baeldung.com/java-dining-philoshophers}
 *
 * @author Milan Rathod
 */
public class DiningPhilosophers {

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            // There might be a scenario where every philosopher
            // picked up left fork and trying to pick right fork
            // but right fork is available to pick
            // To avoid circular wait condition
            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }

            new Thread(philosophers[i], "Philosopher " + (i + 1)).start();
        }
    }
}

class Philosopher implements Runnable {

    private Object leftFork;

    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public static void main(String[] args) {
        System.out.println();
    }

    @Override
    public void run() {
        try {
            while (true) {
                doAction(System.nanoTime() + ": Thinking");
                synchronized (leftFork) {
                    doAction(System.nanoTime() + ": Picked up left fork");

                    synchronized (rightFork) {
                        // Eating
                        doAction(System.nanoTime() + ": Picked up right fork - eating");
                        doAction(System.nanoTime() + ": Put down right fork");
                    }
                    doAction(System.nanoTime() + ": Put down left fork. Back to thinking");
                }
            }
        } catch (InterruptedException ex) {
            System.err.println("Error occurred");
        }
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep((long) (Math.random() * 100));
    }
}

