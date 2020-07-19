package org.milan.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link ImmutableStudent}
 *
 * @author Milan Rathod
 */
public class ImmutableStudentTest {

    @Test
    public void test() {
        Age age = new Age();
        age.setDay(19);
        age.setMonth(7);
        age.setYear(2020);

        ImmutableStudent student = new ImmutableStudent("covid", "Corona", age);

        Assert.assertEquals("covid", student.getId());
        Assert.assertEquals("Corona", student.getName());
        Assert.assertEquals(19, student.getAge().getDay());
        Assert.assertEquals(7, student.getAge().getMonth());
        Assert.assertEquals(2020, student.getAge().getYear());

        // If we modify mutable object by changing age object
        age.setYear(2019);
        Assert.assertEquals(2020, student.getAge().getYear());

        // If we modify mutable object by first getting and then setting of the property of age object
        student.getAge().setYear(2019);
        Assert.assertEquals(2020, student.getAge().getYear());
    }

}