package com.inorg.miniproject.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "Category")
@Table(name = "Category")
public class Category {

    @Id
    @SequenceGenerator(
            name = "category_id_sequence",
            sequenceName = "category_id_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_id_sequence"
    )

    @Column(
            name="category_id",
            updatable = false,
            nullable = false
    )
    private Integer category_id;

    @Column(
            name = "category_name",
            nullable = false
    )
    private String category_name;

    @OneToMany(
            mappedBy = "category_id",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    List<Product> products = new ArrayList<>();
}
