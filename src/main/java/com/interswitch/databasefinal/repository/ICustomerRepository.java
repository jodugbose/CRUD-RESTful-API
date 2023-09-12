package com.interswitch.databasefinal.repository;

import com.interswitch.databasefinal.model.Customer;
import com.interswitch.databasefinal.service.CustomerIService;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {
    Optional<Customer> getOneCustomer(Long id);

    List<Customer> getAllCustomers();
    void deleteCustomer(Long id);
    Customer updateCustomer(Long id, Customer customer);
    Customer addCustomer(Customer customer);
}
