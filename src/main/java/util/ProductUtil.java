package util;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.ImportedProduct;
import model.entities.Product;
import model.entities.Shipment;

public class ProductUtil {

    public static int getTotalQuantityInStock(Product product) {
        if (product.getShipments() == null || product.getShipments().isEmpty()) {
            return 0;
        }
        return product.getShipments().stream().mapToInt(shipment -> shipment.getQuantityInStock()).sum();
    }

    public static Product getProductFrom(Long productId, List<Product> products) {
        if (products.isEmpty()) {
            return null;
        }

        return products
                .stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    public static Map<LocalDate, List<ImportedProduct>> getImportedProduct(List<Product> products) {
        Comparator<LocalDate> descendingDateComparator = Comparator.reverseOrder();
        Map<LocalDate, List<ImportedProduct>> imporedProducts = new TreeMap<>(descendingDateComparator);

        List<ImportedProduct> holder;
        for (Product p : products) {
            for (Shipment s : p.getShipments()) {
                LocalDate date = s.getCreatedAt().toLocalDate();

                boolean exist = imporedProducts.containsKey(date);
                if (exist) {
                    holder = imporedProducts.get(date);

                } else {
                    holder = new ArrayList<>();
                    imporedProducts.put(date, holder);
                }
                holder.add(
                        ImportedProduct.builder()
                                .productId(p.getProductId())
                                .productName(p.getProductName())
                                .provider(p.getProvider())
                                .createdAt(s.getCreatedAt())
                                .unit(p.getUnit())
                                .shipmentId(s.getShipmentId())
                                .importPrice(s.getImportPrice())
                                .quantity(s.getQuantity())
                                .costValue(BigInteger.valueOf(s.getQuantity())
                                        .multiply(BigInteger.valueOf(s.getImportPrice()))
                                        .toString())
                                .build()
                );
            }
        }
        
        return imporedProducts;
    }
}
