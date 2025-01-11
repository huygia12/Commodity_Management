package model.entities;

import java.time.LocalDate;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipmentId;

    @Column(nullable = false)
    private Integer importPrice;

    @Column(nullable = false)
    private Integer quantity;
    
    @Column(nullable = false)
    private Integer quantityInStock;

    private LocalDate manufacturingDate;

    private LocalDate expiryDate;

    @ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private Product product;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(nullable = false)
    private Long storeId;
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}