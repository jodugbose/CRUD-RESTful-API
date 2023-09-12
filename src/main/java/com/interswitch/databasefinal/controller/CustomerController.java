package com.interswitch.databasefinal.controller;

import com.interswitch.databasefinal.model.Customer;
import com.interswitch.databasefinal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
       Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setFullName(customer.getFullName());
            existingCustomer.setPhoneNumber(customer.getPhoneNumber());
            existingCustomer.setDateJoined(customer.getDateJoined());
            Customer updatedCustomer = customerRepository.save(existingCustomer);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if (existingCustomer != null) {
            customerRepository.delete(existingCustomer);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}