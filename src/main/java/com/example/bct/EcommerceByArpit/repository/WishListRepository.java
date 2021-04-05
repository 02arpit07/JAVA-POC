package com.example.bct.EcommerceByArpit.repository;

import com.example.bct.EcommerceByArpit.entity.Product;
import com.example.bct.EcommerceByArpit.entity.User;
import com.example.bct.EcommerceByArpit.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long> {

    Object findByUsersAndProduct(User user, Product product);

    List<WishList> findByUsers(User users);

    String deleteAllByUsersAndProduct(User users, Product product);

    ArrayList<WishList> findAllByUsers(User users);

}
