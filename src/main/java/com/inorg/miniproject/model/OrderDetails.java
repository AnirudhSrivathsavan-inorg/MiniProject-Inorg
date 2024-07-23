package com.inorg.miniproject.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "order_details")
@IdClass(OrderId.class)
public class OrderDetails implements Serializable {

    @Serial
    private static final long serialVersionUID = -909206262878526790L;

    @Id
    @Column(name = "order_id", nullable = false)
    private Integer order_id;

    @Id
    @Column(name = "product_id", nullable = false)
    private Integer product_id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(
            name = "order_id",
            referencedColumnName = "order_id",
            insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "order_id_fk")
    )
    private Orders order;

    @ManyToOne
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "product_id",
            insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "product_order_fk")
    )
    private Product product;

}

