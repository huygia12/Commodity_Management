package util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.StaticalProduct;
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
        BigDecimal total = new BigDecimal(getSubTotal(invoice))
                .multiply(new BigDecimal(1.0 - invoice.getDiscount() * 1.0 / 100));
        return total.toString();
    }

    public static String getNetProfit(Invoice invoice) {
        BigInteger result = BigInteger.ZERO;
        for (InvoiceProduct p : invoice.getInvoiceProducts()) {
            BigInteger gap = BigInteger.valueOf(p.getPrice())
                    .subtract(BigInteger.valueOf(p.getImportPrice()));
            result = result.add(gap.multiply(BigInteger.valueOf(p.getQuantity())));
        }
        return (new BigDecimal(result).subtract(new BigDecimal(getDiscountAmount(invoice)))).toString();
    }

    public static String getSubTotal(Invoice invoice) {
        // tong tien khi chua qua discount
        BigInteger result = BigInteger.ZERO;
        for (InvoiceProduct p : invoice.getInvoiceProducts()) {
            result = result.add(BigInteger.valueOf(p.getQuantity()).multiply(BigInteger.valueOf(p.getPrice())));
        }
        return result.toString();
    }

    public static String getTotalAmountPerProduct(InvoiceProduct p) {
        return BigInteger.valueOf(p.getQuantity()).multiply(BigInteger.valueOf(p.getPrice())).toString();
    }

    public static Map<Long, StaticalProduct> getStaticalProducts(List<Invoice> invoices) {
        Map<Long, StaticalProduct> staticalProducts = new HashMap<>();
        BigDecimal sum = BigDecimal.ZERO;
        for (Invoice i : invoices) {
            for (InvoiceProduct p : i.getInvoiceProducts()) {
                boolean exists = staticalProducts.containsKey(p.getProductId());
                if (!exists) {
                    staticalProducts.put(p.getProductId(),
                            StaticalProduct.builder()
                                    .productId(p.getProductId())
                                    .productName(p.getProductName())
                                    .provider(p.getProvider())
                                    .quantity(p.getQuantity())
                                    .revenue(String.valueOf(p.getQuantity() * p.getPrice()))
                                    .build());
                } else {
                    StaticalProduct staticalProduct = staticalProducts.get(p.getProductId());
                    staticalProduct.setQuantity(staticalProduct.getQuantity() + p.getQuantity());
                    BigInteger newRevenue = new BigInteger(staticalProduct.getRevenue())
                            .add(new BigInteger(String.valueOf(p.getQuantity() * p.getPrice())));
                    staticalProduct.setRevenue(newRevenue.toString());
                }

                sum = sum.add(BigDecimal.valueOf(p.getQuantity() * p.getPrice()));
            }
        }

        for (Map.Entry<Long, StaticalProduct> entry : staticalProducts.entrySet()) {
            StaticalProduct staticalProduct = entry.getValue();
            staticalProduct.setRatio(String.format("%.1f", new BigDecimal(staticalProduct.getRevenue()).divide(sum)));
        }

        return staticalProducts;
    }

    public static String getDiscountAmount(Invoice invoice) {
        return (new BigDecimal(getSubTotal(invoice))
                .multiply(new BigDecimal(invoice.getDiscount() * 1.0 / 100))).toString();
    }

    public static String getChange(Invoice invoice) {
        return String.valueOf(invoice.getCustomerMoney() - Integer.valueOf(getTotal(invoice)));
    }

    public static InvoiceProduct getInvoiceProductFrom(Long shipmentId, Invoice invoice) {
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
                    .importPrice(shipment.getImportPrice())
                    .price(product.getPrice())
                    .provider(product.getProvider())
                    .quantity(quantity)
                    .shipmentId(shipment.getShipmentId())
                    .build());
        } else {
            invoiceProduct.setQuantity(invoiceProduct.getQuantity() + quantity);
        }
    }

    public static void updateInvoiceProductQuantity(Invoice invoice, int quantity, Long shipmentId) {
        if (invoice.getInvoiceProducts() == null || invoice.getInvoiceProducts().isEmpty()) {
            return;
        }
        InvoiceProduct invoiceProduct = getInvoiceProductFrom(shipmentId, invoice);

        if (invoiceProduct != null) {
            invoiceProduct.setQuantity(invoiceProduct.getQuantity() + quantity);
        }
    }

    public static void removeInvoiceProduct(Invoice invoice, Long shipmentId) {
        if (invoice.getInvoiceProducts() == null || invoice.getInvoiceProducts().isEmpty()) {
            return;
        }

        invoice.getInvoiceProducts().removeIf(p -> p.getShipmentId().equals(shipmentId));
    }

    public static Invoice getInvoiceFrom(Long invoiceId, List<Invoice> invoices) {
        if (invoices.isEmpty()) {
            return null;
        }

        return invoices
                .stream()
                .filter(i -> i.getInvoiceId().equals(invoiceId))
                .findFirst()
                .orElse(null);
    }
}
