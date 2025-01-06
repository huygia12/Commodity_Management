package util;

import java.util.List;
import java.util.UUID;
import model.entities.Product;

public class ProductUtil {

    public static int getTotalQuantity(Product product) {
        if (product.getShipments() == null || product.getShipments().isEmpty()) {
            return 0;
        }
        return product.getShipments().stream().mapToInt(shipment -> shipment.getQuantity()).sum();
    }

    public static Product getProductFrom(UUID productId, List<Product> products) {
        if (products.isEmpty()) {
            return null;
        }

        return products
                .stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }
}
