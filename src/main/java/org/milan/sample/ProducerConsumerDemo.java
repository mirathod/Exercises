package org.milan.sample;

public class ProducerConsumerDemo {
	public static void main(String[] args) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
	}
}

class Q {
	boolean flag = false;
	int i, n;

	public synchronized void put(int n) {
		if (!flag) {
			this.n = n;
			i++;
			System.out.println("put : " + i);
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

			System.out.println("Get :" + i);
			i--;
			flag = false;
			notify();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Interrupted " + e);
			}

		}
		return n;
	}
}

class Producer implements Runnable {
	Q q;

	public Producer(Q q) {
		// TODO Auto-generated method stub
		this.q = q;
		new Thread(this, "Consumer").start();
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			q.put(i++);
		}

	}

}

class Consumer implements Runnable {
	Q q;

	public Consumer(Q q) {
		// TODO Auto-generated method stub
		this.q = q;
		new Thread(this, "Producer").start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			q.get();
		}
	}

}