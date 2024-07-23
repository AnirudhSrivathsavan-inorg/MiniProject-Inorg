package com.inorg.miniproject.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class OrderId implements Serializable {
    @Serial
    private static final long serialVersionUID = 2702030623316532366L;

    private Integer order_id;
    private Integer product_id;
}
