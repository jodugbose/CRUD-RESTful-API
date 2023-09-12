package com.interswitch.databasefinal;

import com.interswitch.databasefinal.model.Customer;
import com.interswitch.databasefinal.repository.CustomerRepository;
import com.interswitch.databasefinal.repository.ICustomerRepository;
import com.interswitch.databasefinal.service.CustomerIService;
import com.interswitch.databasefinal.service.impl.CustomerServiceImpl;
import com.interswitch.databasefinal.service.impl.JpaCustomerRepository;
import com.interswitch.databasefinal.service.impl.LocalMemoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.configuration.IMockitoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerTest {

    private CustomerRepository customerRepository;
    private CustomerIService customerIService;

    private ICustomerRepository iCustomerRepository;

    private JpaCustomerRepository jpaCustomerRepository;


    @BeforeEach
    public void setUp(){
        //customerRepository = mock(CustomerRepository.class);
        //iCustomerRepository = mock(LocalMemoryRepository.class);
        jpaCustomerRepository= mock(JpaCustomerRepository.class);
        //customerIService = new CustomerServiceImpl(customerRepository);
        customerIService =new CustomerServiceImpl(jpaCustomerRepository);

    }

    @Test
    void testGetAllCustomers(){
        List<Customer> customers = new ArrayList<>();
        customerIService.addCustomer(new Customer(1L,"Johnson","09039839320","12/09/9292"));
        customerIService.addCustomer(new Customer(2L,"Irene","09039839320","12/09/9292"));

        when(customerIService.getAllCustomers()).thenReturn(customers);

    }
    @Test
    void testWhenOneCustomerIsAdded(){
    when(customerIService.addCustomer(any())).then(returnsFirstArg());

    }
}
