package com.dsevoluction.sales.repositories;

import com.dsevoluction.sales.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
