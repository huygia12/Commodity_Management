package util;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class FormatOutput {

    public static String convertLocalDateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDateTime = date.format(formatter);
        return formattedDateTime;
    }

    public static String convertLocalDateTimeToString(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        String formattedDateTime = date.format(formatter);
        return formattedDateTime;
    }

    public static LocalDateTime convertStringToLocalDateTime(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate date = LocalDate.parse(dateString, formatter);
            LocalDateTime dateTime = date.atStartOfDay();
            return dateTime;
        } catch (DateTimeParseException ex) {
            return null;
        }
    }
    
    public static LocalDate convertStringToLocalDate(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate date = LocalDate.parse(dateString, formatter);
            return date;
        } catch (DateTimeParseException ex) {
            return null;
        }
    }

    public static LocalDateTime convertStringToLocalDateTime(String dateString, String timeString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(dateString + " " + timeString, formatter);
            return dateTime;
        } catch (DateTimeParseException ex) {
            return null;
        }
    }
    
    public static String formatToMoneyAmountForm (String numberString){
        BigInteger number = new BigInteger(numberString); 
        
        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
        String formattedNumber = numberFormat.format(number);
        
        return formattedNumber;
    }
}
