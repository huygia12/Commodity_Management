package model.entities;

import java.util.List;
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
public class Product {

    @Id
    @GeneratedValue
    private UUID productId;

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
        
    @ManyToOne(optional = false)
    @JoinColumn(name = "storeId", referencedColumnName = "storeId")
    private Store store;
    
    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private List<Shipment> shipments;
}
