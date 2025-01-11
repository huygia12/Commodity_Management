package util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import model.entities.Employee;
import model.entities.Invoice;
import model.entities.Shift;
import model.enums.PaymentOption;


public class ShiftUtil {
    public static List<Employee> getEmployees (Shift shift){
        return shift.getEmployees().stream().map(e -> e.getEmployee()).collect(Collectors.toList());
    }
   
    public static String getGrossRevenue(Shift shift) {
        if (shift.getInvoices().isEmpty()) {
            return "0";
        }
        BigDecimal result = BigDecimal.ZERO;
        for (Invoice invoice : shift.getInvoices()) {
            result = result.add(new BigDecimal(InvoiceUtil.getSubTotal(invoice)));
        }
        return result.toString();
    }

    public static String getNetRevenue(Shift shift) {
        if (shift.getInvoices().isEmpty()) {
            return "0";
        }
        BigDecimal result = BigDecimal.ZERO;
        for (Invoice invoice : shift.getInvoices()) {
            result = result.add(new BigDecimal(InvoiceUtil.getTotal(invoice)));
        }
        return result.toString();
    }
    
    public static String getTotalDiscountMoney(Shift shift) {
        if (shift.getInvoices().isEmpty()) {
            return "0";
        }
        BigDecimal result = BigDecimal.ZERO;
        for (Invoice invoice : shift.getInvoices()) {
            result = result.add(new BigDecimal(InvoiceUtil.getDiscountAmount(invoice)));
        }
        return result.toString();
    }
   
    public static String getAveragePerOrder(Shift shift) {
        int len = shift.getInvoices().size();
        if (len == 0) {
            return "0";
        }
        BigDecimal netRevenue = new BigDecimal(getNetRevenue(shift));
        return netRevenue.divide(BigDecimal.valueOf(len), 2 , RoundingMode.HALF_UP).toString();
    }
    
     public static String getTotalPaymentByCash(Shift shift) {
        BigDecimal result = BigDecimal.ZERO;
        for (Invoice invoice : shift.getInvoices()) {
            if (invoice.getPaymentMethod().equals(PaymentOption.CASH)) {
                result = result.add(new BigDecimal(InvoiceUtil.getTotal(invoice)));
            }
        }
        return result.toString();
    }

    public static String getTotalPaymentByWireTransfer(Shift shift) {
        BigDecimal result = BigDecimal.ZERO;
        for (Invoice invoice : shift.getInvoices()) {
            if (invoice.getPaymentMethod().equals(PaymentOption.OTHER)) {
                result = result.add(new BigDecimal(InvoiceUtil.getTotal(invoice)));
            }
        }
        return result.toString();
    }
}
