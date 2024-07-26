package com.inorg.miniproject.controller;

import com.inorg.miniproject.model.Customer;
import com.inorg.miniproject.model.Orders;
import com.inorg.miniproject.repository.CustomerRepository;
import com.inorg.miniproject.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

    CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
         return customerRepository.findAll();
     }

     @GetMapping("/customers/{customerId}")
     public String getCustomerbyId(@PathVariable Integer customerId){
        Customer customer = customerRepository.findById(customerId).orElse(null);
         if (customer == null) {
             return "Customer does not exist";
         }
         return customer.toString();
     }

     @PostMapping("/customers")
    public String createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer).toString();
     }

     @PutMapping("/customers/{customerId}")
    public String updateCustomer(@PathVariable Integer customerId, @RequestBody Customer updatedCustomer){
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if(customer==null){
            return "Invalid Entry";
        }
        customer.setEmail(updatedCustomer.getEmail());
        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());
        return  customerRepository.save(customer).toString();
     }

     @DeleteMapping("/customers/{customerId}")
     public String deleteCustomer(@PathVariable Integer customerId){
         Customer customer = customerRepository.findById(customerId).orElse(null);
         if(customer==null){
             return "Invalid Entry";
         }
        customerRepository.deleteById(1000);
         return "Deleted customer";
     }
}
