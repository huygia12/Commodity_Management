package model.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "InvoiceProduct")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceProductId;

    @Column(nullable = false)
    private String productName;
    
    @Column(nullable = false)
    private String productCode;
    
    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private String unit;
    
    @Column(nullable = false)
    private Integer price;
    
    @Column(nullable = false)
    private Integer importPrice;

    @Column(nullable = false)
    private String provider;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Long shipmentId;

    @ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "InvoiceId", referencedColumnName = "InvoiceId")
    private Invoice invoice;
}