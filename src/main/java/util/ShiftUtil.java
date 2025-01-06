package util;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import model.entities.Employee;
import model.entities.Shift;
import model.entities.Store;


public class ShiftUtil {
    public static List<Employee> getEmployees (Shift shift, Store store){
        Set<UUID> idsToCheck = shift.getEmployees().stream().map(e -> e.getId()).collect(Collectors.toSet());
        return store.getEmployees().stream()
                        .filter(employee -> idsToCheck.contains(employee.getEmployeeId()))
                        .collect(Collectors.toList());
    }
   
    public static String getGrossRevenue(Shift shift) {
        BigDecimal result = ;
        for (Order order : shift.getOrderHisPerShift()) {
            result = result.add(orderCtr.getSubTotal(order));
        }
        return result;
    }

    public static String getNetRevenue(Shift shift) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            result = result.add(orderCtr.getTotal(order, store));
        }
        return result;
    }
   
}
