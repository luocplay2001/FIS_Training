package vn.fis.training.ordermanagement.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_order_item")
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    private Order order;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="amount")
    private Double amount;


}
