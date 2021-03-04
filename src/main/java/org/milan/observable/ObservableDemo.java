package org.milan.observable;

/**
 * Observable Example
 *
 * @author Milan Rathod
 */
public class ObservableDemo {

    public static void main(String[] a) {
        Watcher watcher = new Watcher();
        Subject subject = new Subject();
        subject.addObserver(watcher);
        subject.count();
    }

}