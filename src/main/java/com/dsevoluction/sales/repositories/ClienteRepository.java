package com.dsevoluction.sales.repositories;

import com.dsevoluction.sales.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
