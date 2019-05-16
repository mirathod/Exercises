package org.milan.core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Serializable Demo
 *
 * @author Milan Rathod
 */
public class SerializationDemo {

    public static void main(String[] a) throws Exception {
        Square square = new Square();
        square.size = 15;
        square.diagonal = 20;
        System.out.println("Before Serialization" + square.size + " " + square.diagonal);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc"));
        oos.writeObject(square);
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abc"));
        Square serializedSquare = (Square) ois.readObject();
        System.out.println("After Serialization" + serializedSquare.size + " " + serializedSquare.diagonal);

    }
}

class Shape {
    int size = 5;

    Shape() {
        System.out.println("General Shape");
    }
}

class Square extends Shape implements Serializable {
    int diagonal = 10;

    Square() {
        System.out.println("Square Shape");
    }
}
