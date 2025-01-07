package model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ImportedProduct {
    private Long productId;
    
    private String productName;
    
    private String provider;
    
    private LocalDateTime createdAt;
    
    private String unit;
    
    private Long shipmentId;
    
    private Integer importPrice;
    
    private Integer quantity;
    
    private String costValue;
}
