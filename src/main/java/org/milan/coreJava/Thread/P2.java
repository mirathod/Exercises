package org.milan.coreJava.Thread;

public class P2 extends Thread {
	@Override
	public void start() {
		System.out.println("Start method has been changed ");
	}

	@Override
	public void interrupt() {
		System.out.println("Interrupt method has been changed ");
	}
}
