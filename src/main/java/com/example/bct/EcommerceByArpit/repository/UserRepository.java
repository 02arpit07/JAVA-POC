package com.example.bct.EcommerceByArpit.repository;

import com.example.bct.EcommerceByArpit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User u where u.email = :email")
    public User getUsersByEmail(@Param("email") String email);
}
