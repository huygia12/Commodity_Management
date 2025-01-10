package model.entities;

import java.util.List;
import lombok.*;
import javax.persistence.*;

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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String productCode;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String provider;
    
    @ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "storeId", referencedColumnName = "storeId")
    private Store store;
    
    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private List<Shipment> shipments;
}
