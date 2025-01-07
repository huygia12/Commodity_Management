package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StaticalProduct {
    private Long productId;
    
    private String productName;
    
    private String provider;
    
    private int quantity;
    
    private String revenue;
    
    private String ratio;
}
