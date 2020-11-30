package org.milan.marker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Example of cloning an object with {@link Cloneable} interface
 *
 * @author Milan Rathod
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Employee implements Cloneable {

    private String name;

    private Address address;

    public Employee(Employee employee) {
        this(employee.getName(), new Address(employee.getAddress()));
    }

    /**
     * Object.clone() will return shallow copy of an object
     *
     * @return Cloned object {@link Employee}
     * @throws CloneNotSupportedException
     */
    @Override
    protected Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }

    /**
     * Create a shallow copy of an object
     * <p>
     * Shallow copy will copy existing object with bit by bit values of
     * primitive or immutable fields
     * For mutable fields it copies bit by bit references of it. So if any property of mutable
     * field changes it will reflect in cloned object's mutable field
     */
    public Employee shallowCopy() throws CloneNotSupportedException {
        return clone();
    }

    /**
     * Create a deep copy of an object
     * <p>
     * Deep copy will copy existing object with bit by bit values of primitive, immutable and mutable fields
     * So mutable fields, original and cloned objects refer to different objects instead of same in case
     * of shallow copy
     */
    public Employee deepCopy() throws CloneNotSupportedException {
        Employee employee = clone();

        employee.address = employee.address.clone();

        return employee;
    }
}

@Data
@AllArgsConstructor
@EqualsAndHashCode
class Address implements Cloneable {
    private int pinCode;

    private String cityName;

    public Address(Address address) {
        this(address.getPinCode(), address.getCityName());
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

}
