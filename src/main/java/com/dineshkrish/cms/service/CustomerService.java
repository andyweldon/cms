package com.dineshkrish.cms.service;

import com.dineshkrish.cms.dao.CustomerDAO;
import com.dineshkrish.cms.exception.CustomerNotFoundException;
import com.dineshkrish.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer) {

        return customerDAO.save(customer);

    }

    public List<Customer> getCustomers() {

        return customerDAO.findAll();

    }

    public Customer getCustomer(int customerId){

        return customerDAO.findById(customerId).orElseThrow( () -> new CustomerNotFoundException("Customer Record is not available..."));
    }

    public Customer updateCustomer(final int customerId, final Customer customer) {

        customer.setCustomerId(customerId);

        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId){

        customerDAO.deleteById(customerId);
    }
}
