package com.inorg.miniproject.controller;


import com.inorg.miniproject.model.Customer;
import com.inorg.miniproject.model.Orders;
import com.inorg.miniproject.repository.CustomerRepository;
import com.inorg.miniproject.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers/{customerId}")
public class OrderController {

    OrderRepository orderRepository;
    CustomerRepository customerRepository;

    public OrderController(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository=customerRepository;
    }

    @GetMapping("/orders")
    public List<Orders> getCustomers(@PathVariable Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null)
            return null;
        return customer.getOrders();
    }

    @PostMapping("/orders")
    public Orders addOrder(@PathVariable Integer customerId,@RequestBody Orders orders){
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null) {
            return null;
        }
        orders.setCustomer(customer);
        return orderRepository.save(orders);
    }

//    @DeleteMapping("/orders/{order_id}")
}
