package com.interswitch.databasefinal.repository;

import com.interswitch.databasefinal.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
