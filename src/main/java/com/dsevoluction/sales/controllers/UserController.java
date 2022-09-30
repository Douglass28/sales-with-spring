package com.dsevoluction.sales.controllers;

import com.dsevoluction.sales.entities.User;
import com.dsevoluction.sales.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody @Valid User user){
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userService.insert(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
