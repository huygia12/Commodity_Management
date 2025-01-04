package model.entity;

import lombok.*;
import javax.persistence.*;
import java.util.UUID;

/**
 *
 * @author huy
 */
@Entity
@Table(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Product {

    @Id
    @GeneratedValue
    private UUID productId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "storeId", referencedColumnName = "storeId")
    private Store store;

    @Column(nullable = false)
    private String productCode;

    private String thump = "/product-placeholder.jpg";

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    private Integer price;

    private String provider;
}
