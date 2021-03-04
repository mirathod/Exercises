package org.milan.nested;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Milan Rathod
 */
public class CommaSeparatedCustomers implements Customer.List {

    private List<Customer> customerList = new ArrayList<>();

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public String getCustomerNames() {
        return customerList.stream()
                .map(Customer::getName)
                .collect(Collectors.joining(","));
    }

}

class Customer {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public interface List {
        void add(Customer customer);

        String getCustomerNames();
    }

}
