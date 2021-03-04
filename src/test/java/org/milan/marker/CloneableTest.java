package org.milan.marker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link Employee}
 *
 * @author Milan Rathod
 */
class CloneableTest {

    private Employee employee;

    @BeforeEach
    void init() {
        employee = new Employee("testName", new Address(123456, "Bangalore"));
    }

    @Test
    void testCopyConstructor() {
        Employee copyConstructor = new Employee(employee);

        assertNotSame(employee, copyConstructor);

        assertEquals(employee, copyConstructor);

        assertNotSame(employee.getAddress(), copyConstructor.getAddress());

        assertEquals(employee.getAddress(), copyConstructor.getAddress());

        employee.getAddress().setCityName("Mysore");

        assertNotSame(employee.getAddress(), copyConstructor.getAddress());

        assertNotEquals(employee.getAddress(), copyConstructor.getAddress());
    }

    @Test
    void testShallowCopy() throws CloneNotSupportedException {
        Employee shallowCopy = this.employee.shallowCopy();

        assertNotSame(employee, shallowCopy);

        assertEquals(employee, shallowCopy);

        assertSame(shallowCopy.getAddress(), employee.getAddress());

        employee.getAddress().setCityName("Mysore");

        assertSame(shallowCopy.getAddress(), employee.getAddress());

        assertEquals(shallowCopy.getAddress(), employee.getAddress());
    }

    @Test
    void testDeepCopy() throws CloneNotSupportedException {
        Employee deepCopy = this.employee.deepCopy();

        assertNotSame(employee, deepCopy);

        assertEquals(employee, deepCopy);

        assertNotSame(employee.getAddress(), deepCopy.getAddress());

        assertEquals(employee.getAddress(), deepCopy.getAddress());

        employee.getAddress().setCityName("Mysore");

        assertNotSame(employee.getAddress(), deepCopy.getAddress());

        assertNotEquals(employee.getAddress(), deepCopy.getAddress());
    }

}