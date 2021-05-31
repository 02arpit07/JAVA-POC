package com.example.bct.EcommerceByArpit.repository;

import com.example.bct.EcommerceByArpit.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByUsername(String username);

    Optional<Customer> findById(Long id);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    List<Customer> findAll();
}
