package com.example.bct.EcommerceByArpit.services;

import com.example.bct.EcommerceByArpit.entity.Customer;
import com.example.bct.EcommerceByArpit.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomerById(Long id){
        List<Customer> customerList = customerRepository.findAll();
        Customer customer=null;
        customer = customerList.stream().filter(e->e.getId()==id).findFirst().get();
        return customer;
    }
    public Long getUserId(Principal principal) {
        String email=principal.getName();
        return customerRepository.findByUsername(email).get().getId();
    }
}
