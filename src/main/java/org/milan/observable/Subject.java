package org.milan.observable;

import java.util.Observable;

/**
 * @author Milan Rathod
 */
public class Subject extends Observable {

    public void count() {
        int i = 10;
        setChanged();
        notifyObservers(i);
    }
}
