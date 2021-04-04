package com.example.bct.EcommerceByArpit.repository;

import com.example.bct.EcommerceByArpit.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long > {
    List<OrderHistory> findAllByUserId(Long id);
}
