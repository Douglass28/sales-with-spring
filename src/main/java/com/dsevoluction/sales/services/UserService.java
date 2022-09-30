package com.dsevoluction.sales.services;

import com.dsevoluction.sales.entities.User;
import com.dsevoluction.sales.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User insert(User user){
        return repository.save(user);
    }
}
