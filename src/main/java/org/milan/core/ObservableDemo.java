package org.milan.core;

import java.util.Observable;
import java.util.Observer;

public class ObservableDemo {

	public static void main(String[] a) {
		Watcher w = new Watcher();
		BeingWatched b = new BeingWatched();
		b.addObserver(w);
		b.count();
	}

}

class Watcher implements Observer {

	public void update(Observable o, Object arg) {
		if (((Integer) arg).intValue() > 0) {
			System.out.println("Positive Number");
		}
	}

}

class BeingWatched extends Observable {
	public void count() {
		int i = 10;
		setChanged();
		notifyObservers(new Integer(i));
	}
}
