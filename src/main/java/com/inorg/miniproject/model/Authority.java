package com.inorg.miniproject.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(
        name = "authorities"
)
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
