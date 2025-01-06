package model.entities;

import lombok.*;
import javax.persistence.*;
import java.util.UUID;

/**
 *
 * @author huy
 */
@Entity
@Table(name = "InvoiceProduct")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceProduct {

    @Id
    @GeneratedValue
    private UUID invoiceProductId;

    @Column(nullable = false)
    private String productName;
    
    @Column(nullable = false)
    private String productCode;
    
    @Column(nullable = false)
    private UUID productId;

    @Column(nullable = false)
    private String unit;
    
    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String provider;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private UUID shipmentId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "InvoiceId", referencedColumnName = "InvoiceId")
    private Invoice invoice;
}