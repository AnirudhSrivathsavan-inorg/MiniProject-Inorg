package com.inorg.miniproject.repository;

import com.inorg.miniproject.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    @Query(value = "select o from orders o where o.customer_id = ?1", nativeQuery = true)
    public List<Orders> findOrdersbyCustomerId(Integer customerId);
}
