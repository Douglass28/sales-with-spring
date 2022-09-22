package com.dsevoluction.sales.repositories;

import com.dsevoluction.sales.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
