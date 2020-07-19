package org.milan.core.collections;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Custom object used as {@code Key} for {@link java.util.HashMap}
 *
 * @author Milan Rathod
 */
@Data
@AllArgsConstructor
public class MyKey {

    private int id;

    private String name;

    @Override
    public int hashCode() {
        System.out.println("Calling hashCode()");
        return id;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Calling equals for key: " + o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyKey myKey = (MyKey) o;
        return id == myKey.id;
    }
}
