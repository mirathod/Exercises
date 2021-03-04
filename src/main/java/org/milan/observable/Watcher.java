package org.milan.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Milan Rathod
 */
public class Watcher implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if ((Integer) arg > 0) {
            System.out.println("Positive Number");
        }
    }
}