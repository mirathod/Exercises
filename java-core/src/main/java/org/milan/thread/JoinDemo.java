package org.milan.thread;

/**
 * @author Milan Rathod
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Started");

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " Started");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " Completed");
        });

        thread.start();
        thread.join();

        System.out.println(Thread.currentThread().getName() + " Completed");
    }
}
