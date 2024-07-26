package com.inorg.miniproject.controller;

import com.inorg.miniproject.model.Customer;
import com.inorg.miniproject.model.OrderDetails;
import com.inorg.miniproject.model.Orders;
import com.inorg.miniproject.repository.CustomerRepository;
import com.inorg.miniproject.repository.OrderDetailRepository;
import com.inorg.miniproject.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers/{customerId}/orders/{orderId}")
public class OrderDetailsController {
    OrderRepository orderRepository;
    OrderDetailRepository orderDetailRepository;
    CustomerRepository customerRepository;

    public OrderDetailsController(OrderRepository orderRepository,   OrderDetailRepository orderDetailRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.customerRepository  = customerRepository;
    }

    @GetMapping("orderdetails")
    public List<OrderDetails> getAllOrderDetails(@PathVariable Integer customerId, @PathVariable Integer orderId ){
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null) {
            List<Orders> orders = customer.getOrders();
            Orders foundOrder = null;
            for (Orders order : orders) {
                if (order.getOrderId().equals(orderId)) {
                    return order.getOrderDetails();
                }
            }
        }
        return null;
    }

    @PostMapping("orderdetails")
    public OrderDetails createOrderDetail(@PathVariable Integer customerId, @PathVariable Integer orderId, @RequestBody OrderDetails orderDetails){
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null) {
            List<Orders> orders = customer.getOrders();
            Orders foundOrder = null;
            for (Orders order : orders) {
                if (order.getOrderId().equals(orderId)) {
                    orderDetails.setOrder(order);
                    return orderDetailRepository.save(orderDetails);
                }
            }
        }
        return null;
    }

    @DeleteMapping("orderdetails/{orderDetailsId}")
    public String createOrderDetail(@PathVariable Integer customerId, @PathVariable Integer orderId, @PathVariable Integer orderDetailsId){
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null) {
            List<Orders> orders = customer.getOrders();
            Orders foundOrder = null;
            for (Orders order : orders) {
                if (order.getOrderId().equals(orderId)) {
                    //orderDetailRepository.deleteByorderDetailId(orderDetailsId);
                    return "Deleted Order details";
                }
            }
        }
        return "No resource!";
    }
}
