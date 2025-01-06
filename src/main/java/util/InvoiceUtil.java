package util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.UUID;
import model.entities.Invoice;
import model.entities.InvoiceProduct;
import model.entities.Product;
import model.entities.Shipment;

public class InvoiceUtil {

    public static boolean isInsufficient(Invoice invoice) {
        BigInteger customerMoney = BigInteger.valueOf(invoice.getCustomerMoney());
        BigInteger totalBill = new BigInteger(getTotal(invoice));
        return totalBill.compareTo(customerMoney) < 0;
    }
    
    public static String getTotal(Invoice invoice) {
        BigDecimal total = (getSubTotal(invoice)
                .multiply(new BigDecimal(1.0 - invoice.getDiscount() * 1.0 / 100));
        return total;
    }

    public static String getSubTotal(Invoice invoice) {
        // tong tien khi chua qua discount va VAT
        BigDecimal result = BigDecimal.ZERO;
        for (Goods goods : order.getList()) {
            result = result.add(goods.getListPrice()
                    .multiply(goodsCtr.getTotalQuanByShipments(goods)));
        }
        return result;
    }

    public static String getDiscountAmount(Invoice invoice) {
        // tong tien giam gia 
        return (getSubTotal(order).add(getTaxAmount(order)))
                .multiply(new BigDecimal(order.getDiscount() * 1.0 / 100));
    }

    public static String getChange(Invoice invoice) {
        return order.getCusMoney().subtract(getTotal(order, store));
    }

    public static InvoiceProduct getInvoiceProductFrom(UUID shipmentId, Invoice invoice) {
        if (invoice.getInvoiceProducts().isEmpty()) {
            return null;
        }

        return invoice.getInvoiceProducts()
                .stream()
                .filter(product -> product.getShipmentId().equals(shipmentId))
                .findFirst()
                .orElse(null);
    }

    public static void addInvoiceProduct(Invoice invoice, Product product, int quantity, Shipment shipment) {
        if (invoice.getInvoiceProducts() == null) {
            invoice.setInvoiceProducts(new ArrayList<>());
        }
        InvoiceProduct invoiceProduct = getInvoiceProductFrom(shipment.getShipmentId(), invoice);
        
        if (invoiceProduct == null) {
            invoice.getInvoiceProducts().add(InvoiceProduct
                    .builder()
                    .productName(product.getProductName())
                    .productId(product.getProductId())
                    .productCode(product.getProductCode())
                    .unit(product.getUnit())
                    .price(product.getPrice())
                    .provider(product.getProvider())
                    .quantity(quantity)
                    .shipmentId(shipment.getShipmentId())
                    .build());
        } else {
            invoiceProduct.setQuantity(invoiceProduct.getQuantity() + quantity);
        }
    }
    
    public static void updateInvoiceProductQuantity(Invoice invoice, int quantity, UUID shipmentId) {
        if (invoice.getInvoiceProducts() == null || invoice.getInvoiceProducts().isEmpty()) {
            return;
        }
        InvoiceProduct invoiceProduct = getInvoiceProductFrom(shipmentId, invoice);
        
        if (invoiceProduct != null) {
            invoiceProduct.setQuantity(invoiceProduct.getQuantity() + quantity);
        }
    }

    public static void removeInvoiceProduct(Invoice invoice, UUID shipmentId) {
        if (invoice.getInvoiceProducts() == null || invoice.getInvoiceProducts().isEmpty()) {
            return;
        }

        invoice.getInvoiceProducts().removeIf(p -> p.getShipmentId().equals(shipmentId));
    }
}
