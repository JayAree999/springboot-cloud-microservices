package com.jayaree999.orderservice.repository;

import com.jayaree999.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

//key long
public interface OrderRepository extends JpaRepository<Order,Long> {
}
