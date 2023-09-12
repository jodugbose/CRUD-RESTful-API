package com.interswitch.databasefinal.service.impl;

import com.interswitch.databasefinal.model.Customer;
import com.interswitch.databasefinal.repository.ICustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaCustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public Optional<Customer> getOneCustomer(Long id) {
        TypedQuery<Customer> query = em.createQuery("SELECT c from Customer c WHERE c.id =:id", Customer.class);
        return Optional.of(query.setParameter("id",id).getSingleResult());
    }
    @Override
    public List<Customer> getAllCustomers() {
        TypedQuery<Customer> query = em.createQuery("SELECT c from Customer c", Customer.class);
        return query.getResultList();
    }
    @Override
    public void deleteCustomer(Long id) {
        Customer customer = getOneCustomer(id).get();
        if(customer != null){
            em.remove(customer);
        }
    }
    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        if (getOneCustomer(id).get() != null){
            em.merge(customer);
        }
        return null;
    }
    @Override
    public Customer addCustomer(Customer customer) {
        em.persist(customer);return customer;
    }
}