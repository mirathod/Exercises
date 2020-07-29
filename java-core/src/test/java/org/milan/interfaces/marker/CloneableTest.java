package org.milan.interfaces.marker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link Employee}
 *
 * @author Milan Rathod
 */
public class CloneableTest {

    private Employee employee;

    @Before
    public void init() {
        employee = new Employee("testName", new Address(123456, "Bangalore"));
    }

    @Test
    public void testCopyConstructor() {
        Employee copyConstructor = new Employee(employee);

        Assert.assertNotSame(employee, copyConstructor);

        Assert.assertEquals(employee, copyConstructor);

        Assert.assertNotSame(employee.getAddress(), copyConstructor.getAddress());

        Assert.assertEquals(employee.getAddress(), copyConstructor.getAddress());

        employee.getAddress().setCityName("Mysore");

        Assert.assertNotSame(employee.getAddress(), copyConstructor.getAddress());

        Assert.assertNotEquals(employee.getAddress(), copyConstructor.getAddress());
    }

    @Test
    public void testShallowCopy() throws CloneNotSupportedException {
        Employee shallowCopy = this.employee.shallowCopy();

        Assert.assertNotSame(employee, shallowCopy);

        Assert.assertEquals(employee, shallowCopy);

        Assert.assertSame(shallowCopy.getAddress(), employee.getAddress());

        employee.getAddress().setCityName("Mysore");

        Assert.assertSame(shallowCopy.getAddress(), employee.getAddress());

        Assert.assertEquals(shallowCopy.getAddress(), employee.getAddress());
    }

    @Test
    public void testDeepCopy() throws CloneNotSupportedException {
        Employee deepCopy = this.employee.deepCopy();

        Assert.assertNotSame(employee, deepCopy);

        Assert.assertEquals(employee, deepCopy);

        Assert.assertNotSame(employee.getAddress(), deepCopy.getAddress());

        Assert.assertEquals(employee.getAddress(), deepCopy.getAddress());

        employee.getAddress().setCityName("Mysore");

        Assert.assertNotSame(employee.getAddress(), deepCopy.getAddress());

        Assert.assertNotEquals(employee.getAddress(), deepCopy.getAddress());
    }

}