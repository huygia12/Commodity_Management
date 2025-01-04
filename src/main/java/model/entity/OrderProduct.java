package model.entity;

import lombok.*;
import javax.persistence.*;
import java.util.UUID;

/**
 *
 * @author huy
 */
@Entity
@Table(name = "OrderProduct")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class OrderProduct {

    @Id
    @GeneratedValue
    private UUID orderProductId;

    @Column(nullable = false)
    private String productName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private Product product;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    private Integer price;

    private String provider;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shipmentId", referencedColumnName = "shipmentId")
    private Shipment shipment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order order;
}