package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author huy
 */
public class FormatOutput {

    public static String convertLocalDateToString(LocalDate date) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
    }

    public static String convertLocalDateTimeToString(LocalDateTime date) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm dd/MM/yyyy");
        String formattedDateTime = now.format(formatter);
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

    public static LocalDateTime convertStringToLocalDateTime(String dateString, String timeString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy H:m");
            LocalDate date = LocalDate.parse(dateString + " " + timeString, formatter);
            LocalDateTime dateTime = date.atStartOfDay();
            return dateTime;
        } catch (DateTimeParseException ex) {
            return null;
        }
    }
}
