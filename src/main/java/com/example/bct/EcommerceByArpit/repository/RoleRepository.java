package com.example.bct.EcommerceByArpit.repository;

import com.example.bct.EcommerceByArpit.entity.ERole;
import com.example.bct.EcommerceByArpit.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByName(ERole name);
}
