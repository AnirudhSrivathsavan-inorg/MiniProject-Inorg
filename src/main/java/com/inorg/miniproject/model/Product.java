package com.inorg.miniproject.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "Product")
@Table(name = "Product")
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_id_sequence",
            sequenceName = "order_id_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id_sequence"
    )
    @Column(
            name="product_id",
            updatable = false
    )
    private Integer product_Id;

    @Column(
            name = "product_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String product_name;

    @Column(
            name = "price",
            nullable = false,
            columnDefinition = "DECIMAL"
    )
    private Double price;

    @Column(
            name="cat_id",
            updatable = false,
            nullable = false
    )
    private Integer category_id;

    @ManyToOne
    @JoinColumn(
            name="category_id",
            referencedColumnName = "category_id",
            nullable = false,
            foreignKey = @ForeignKey(name="category_id_fk")
    )
    Category category;
}
