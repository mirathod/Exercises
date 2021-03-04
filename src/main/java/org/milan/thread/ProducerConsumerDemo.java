package org.milan.thread;

/**
 * Example of Producer Consumer
 *
 * @author Milan Rathod
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Queue queue = new Queue();
        new Producer(queue);
        new Consumer(queue);
    }
}

/**
 * Queue Class which holds flag and count of items during inter thread communication
 */
class Queue {

    private boolean flag = false;

    private int total;

    private int item;

    public synchronized void put(int item) {
        if (!flag) {

            this.item = item;

            total++;

            System.out.println("put : " + total);

            flag = true;

            notify();

        } else {

            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted " + e);
            }
        }
    }

    public synchronized int get() {
        if (flag) {

            System.out.println("Get :" + total);

            total--;

            flag = false;

            notify();

        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted " + e);
            }

        }
        return item;
    }
}

/**
 * Producer Class
 */
class Producer implements Runnable {
    private Queue queue;

    Producer(Queue queue) {
        this.queue = queue;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            queue.put(i++);
        }

    }

}

/**
 * Consumer Class
 */
class Consumer implements Runnable {
    private Queue queue;

    Consumer(Queue queue) {
        this.queue = queue;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        while (true) {
            queue.get();
        }
    }

}