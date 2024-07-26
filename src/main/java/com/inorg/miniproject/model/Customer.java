package com.inorg.miniproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity(name = "customer")
@Table(name = "customer", uniqueConstraints = {
        @UniqueConstraint(name = "unique_customer_email",columnNames = {"email"})
})
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    @Column(
            name="customer_id",
            updatable = false
    )
    private Integer customer_id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @JsonIgnore
    @Column(name = "password",nullable = false)
    private String password;

    @Column(
            name = "role",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String role;

    @OneToMany(
            mappedBy = "customer",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    List<Orders> orders = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private Set<Authority> authorities;

    public void addOrder(Orders order){
        if(!this.orders.contains(order)) {
            this.orders.add(order);
            order.setCustomer(this);
        }
    }

    public void removeOrder(Orders orders){
        if(this.orders.contains(orders)){
            this.orders.remove(orders);
            orders.setCustomer(null);
        }
    }

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + orders +
                '}';
    }
}
