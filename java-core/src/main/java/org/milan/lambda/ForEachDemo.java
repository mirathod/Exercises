package org.milan.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

/**
 * for each example
 *
 * @author Milan Rathod
 */
public class ForEachDemo {

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            myList.add(i);
        MyConsumer myConsumer = new MyConsumer();
        myList.forEach(myConsumer::accept);
    }
}

class MyConsumer implements IntConsumer {

    @Override
    public void accept(int value) {
        System.out.println("For each via class implementation" + value);
    }
}
