package org.milan.misc;

/**
 * Immutable class example
 *
 * @author Milan Rathod
 */
public final class ImmutableStudent {

    private final String id;

    private final String name;

    private final Age age;

    public ImmutableStudent(String id, String name, Age age) {
        this.id = id;
        this.name = name;
        Age newAge = new Age();
        newAge.setDay(age.getDay());
        newAge.setMonth(age.getMonth());
        newAge.setYear(age.getYear());
        this.age = newAge;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {
        Age newAge = new Age();
        newAge.setDay(age.getDay());
        newAge.setMonth(age.getMonth());
        newAge.setYear(age.getYear());
        return newAge;
    }
}

class Age {
    private int day;

    private int month;

    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
