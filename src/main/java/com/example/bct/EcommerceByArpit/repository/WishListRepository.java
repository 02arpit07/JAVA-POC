package com.example.bct.EcommerceByArpit.repository;

import com.example.bct.EcommerceByArpit.entity.Customer;
import com.example.bct.EcommerceByArpit.entity.Product;
import com.example.bct.EcommerceByArpit.entity.User;
import com.example.bct.EcommerceByArpit.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long> {

    Object findByCustomerAndProduct(Customer customer, Product product);

    List<WishList> findByCustomer(Customer customer);

    String deleteAllByCustomerAndProduct(Customer customer, Product product);

    ArrayList<WishList> findAllByCustomer(Customer customer);

}
