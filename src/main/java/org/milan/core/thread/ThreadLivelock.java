package org.milan.core.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Livelock example
 *
 * @author Milan Rathod
 */
public class ThreadLivelock {

    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        ThreadLivelock threadLivelock = new ThreadLivelock();
        new Thread(threadLivelock::operation1, "t1").start();
        new Thread(threadLivelock::operation2, "t2").start();
    }

    public void operation1() {
        while (true) {
            tryLock(lock1, 50);
            print("lock1 acquired, trying to acquire lock2");
            sleep(100);

            if (tryLock(lock2)) {
                print("lock2 acquired");
            } else {
                print("cannot acquire lock2, releasing lock1");
                lock1.unlock();
                continue;
            }

            print("executing first operation");
            break;
        }
        lock2.unlock();
        lock1.unlock();
    }

    public void operation2() {
        while (true) {
            tryLock(lock2, 50);
            print("lock2 acquired, trying to acquire lock1");
            sleep(100);

            if (tryLock(lock1)) {
                print("lock1 acquired");
            } else {
                print("cannot acquire lock1, releasing lock2");
                lock2.unlock();
                continue;
            }

            print("executing second operation");
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }

    private void print(String message) {
        System.out.println("Thread " + Thread.currentThread()
                .getName() + ": " + message);
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void tryLock(Lock lock, long millis) {
        try {
            lock.tryLock(millis, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean tryLock(Lock lock) {
        return lock.tryLock();
    }
}
