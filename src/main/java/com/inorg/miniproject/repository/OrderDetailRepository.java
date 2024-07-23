package com.inorg.miniproject.repository;

import com.inorg.miniproject.model.OrderDetails;
import com.inorg.miniproject.model.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetails, OrderId> {
}
