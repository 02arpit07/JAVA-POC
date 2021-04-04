package com.example.bct.EcommerceByArpit.repository;

import com.example.bct.EcommerceByArpit.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long> {

}
