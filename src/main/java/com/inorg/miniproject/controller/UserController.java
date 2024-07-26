package com.inorg.miniproject.controller;

import com.inorg.miniproject.model.Customer;
import com.inorg.miniproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    CustomerRepository customerRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    UserController(CustomerRepository customerRepository,PasswordEncoder passwordEncoder){
        this.customerRepository=customerRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @GetMapping("/user")
    public Customer getCustomerDetailsAfterLogin(Authentication authentication){
        Optional<Customer> optionalCustomer=customerRepository.findCustomerByEmail(authentication.getName());
        return  optionalCustomer.orElse(null);
    }
}
