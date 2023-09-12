package com.interswitch.databasefinal.service.impl;

import com.interswitch.databasefinal.model.Customer;
import com.interswitch.databasefinal.repository.CustomerRepository;
import com.interswitch.databasefinal.repository.ICustomerRepository;
import com.interswitch.databasefinal.service.CustomerIService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerIService {

    private CustomerRepository customerRepository;
    @Autowired
    private JpaCustomerRepository jpaCustomerRepository;
    private ICustomerRepository iCustomerRepository;

    public CustomerServiceImpl(JpaCustomerRepository jpaCustomerRepository) {
        this.jpaCustomerRepository = jpaCustomerRepository;
    }

    public CustomerServiceImpl() {
    }


//    public CustomerServiceImpl(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    @Override
    public List<Customer> getAllCustomers() {
        return jpaCustomerRepository.getAllCustomers();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return jpaCustomerRepository.addCustomer(customer);
    }


    }

