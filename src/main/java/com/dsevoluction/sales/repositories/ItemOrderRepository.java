package com.dsevoluction.sales.repositories;

import com.dsevoluction.sales.entities.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOrderRepository extends JpaRepository<ItemOrder, Integer> {
}
