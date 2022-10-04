package com.dsevoluction.sales.repositories;

import com.dsevoluction.sales.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query
    Optional<User> findByUsername(String username);
}
