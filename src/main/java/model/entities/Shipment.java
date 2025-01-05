package model.entities;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author huy
 */
@Entity
@Table(name = "Shipment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {

    @Id
    @GeneratedValue
    private UUID shipmentId;

    @Column(nullable = false)
    private Integer importPrice;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private LocalDateTime manufacturingDate;

    @Column(nullable = false)
    private LocalDateTime expiryDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private Product product;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(nullable = false)
    private UUID storeId;
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}