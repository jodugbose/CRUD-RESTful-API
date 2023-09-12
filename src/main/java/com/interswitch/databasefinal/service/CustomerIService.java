package com.interswitch.databasefinal.service;

import com.interswitch.databasefinal.model.Customer;

import java.util.List;

public interface CustomerIService {

    public List<Customer> getAllCustomers();
    public Customer addCustomer(Customer customer);


}
