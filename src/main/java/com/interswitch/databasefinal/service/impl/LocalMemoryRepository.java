package com.interswitch.databasefinal.service.impl;

import com.interswitch.databasefinal.model.Customer;
import com.interswitch.databasefinal.repository.ICustomerRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LocalMemoryRepository implements ICustomerRepository {

    private Map<Long,Customer> localMemory = new HashMap<>();

    @Override
    public Optional<Customer> getOneCustomer(Long id) {
        return Optional.ofNullable(localMemory.get(id));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) localMemory.values();
    }

    @Override
    public void deleteCustomer(Long id) {
        if (localMemory.containsKey(id)){
            localMemory.remove(id);
        }
    }
    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        if (localMemory.get(id) != null){
            return localMemory.put(customer.getId(),customer);
        }
        return null;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return localMemory.put(customer.getId(),customer);
    }
}
