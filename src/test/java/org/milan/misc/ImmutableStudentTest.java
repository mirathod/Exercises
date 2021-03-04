package org.milan.misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link ImmutableStudent}
 *
 * @author Milan Rathod
 */
class ImmutableStudentTest {

    @Test
    void test() {
        Age age = new Age();
        age.setDay(19);
        age.setMonth(7);
        age.setYear(2020);

        ImmutableStudent student = new ImmutableStudent("covid", "Corona", age);

        assertEquals("covid", student.getId());
        assertEquals("Corona", student.getName());
        assertEquals(19, student.getAge().getDay());
        assertEquals(7, student.getAge().getMonth());
        assertEquals(2020, student.getAge().getYear());

        // If we modify mutable object by changing age object
        age.setYear(2019);
        assertEquals(2020, student.getAge().getYear());

        // If we modify mutable object by first getting and then setting of the property of age object
        student.getAge().setYear(2019);
        assertEquals(2020, student.getAge().getYear());
    }

}