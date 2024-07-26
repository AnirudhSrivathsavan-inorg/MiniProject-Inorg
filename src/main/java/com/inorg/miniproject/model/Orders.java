package com.inorg.miniproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @SequenceGenerator(
            name = "order_id_sequence",
            sequenceName = "order_id_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_id_sequence"
    )
    @Column(name = "order_id", updatable = false)
    private Integer orderId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "customer_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "customer_order_fk")
    )
    private Customer customer;

    @OneToMany(
            mappedBy = "order_id",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    private List<OrderDetails> orderDetails= new ArrayList<>();

    @Column(name = "order_date", columnDefinition = "DATE", nullable = false)
    private Date orderDate;

    public Orders(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Orders(Customer customer, Date orderDate) {
        this.customer = customer;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                '}';
    }
}
