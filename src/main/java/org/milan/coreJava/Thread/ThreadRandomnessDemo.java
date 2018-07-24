package org.milan.coreJava.Thread;

public class ThreadRandomnessDemo {
	public static void main(String[] a) {

		ABC a1 = new ABC();
		Thread t1 = new Thread(a1, "Thread 1");
		Thread t2 = new Thread(a1, "Thread 2");
		Thread t3 = new Thread(a1, "Thread 3");

		t1.setPriority(Thread.MAX_PRIORITY - 5);
		t2.setPriority(4);
		t3.setPriority(9);

		t1.start();
		t2.start();
		t3.start();

		System.out.println("Is Thread 1 alive :-" + t1.isAlive());
		System.out.println("Is Thread 2 alive :-" + t2.isAlive());
		System.out.println("Is Thread 3 alive :-" + t3.isAlive());

		try {
			t1.join();
			t2.join();
			t3.join();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		System.out.println("Is Thread 1 alive :-" + t1.isAlive());
		System.out.println("Is Thread 2 alive :-" + t2.isAlive());
		System.out.println("Is Thread 3 alive :-" + t3.isAlive());
		System.out.println("good Bye");

	}

}

class ABC implements Runnable {

	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("I am Thread :" + Thread.currentThread().getName() + "  My i value =" + i);
		}
	}

	public void run(String s) {

	}

}
