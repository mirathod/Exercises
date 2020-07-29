package org.milan.collections;

import java.util.HashSet;
import java.util.Objects;

/**
 * Example of {@link HashSet}
 *
 * @author Milan Rathod
 */
public class HashSetDemo {

    public static void main(String[] args) {
        HashSet<Book> books = new HashSet<>();

        Book book1 = new Book();
        book1.setPrice(40);

        Book book2 = new Book();
        book2.setPrice(30);

        Book book3 = new Book();
        book3.setPrice(20);

        Book book4 = new Book();
        book4.setPrice(10);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        // Set does not allow duplicates
        books.add(book1);

        System.out.println(books.size());

        for (Book book : books) {
            System.out.println(book.getPrice());
        }

    }

}

class Book {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return price == book.price;
    }
}
