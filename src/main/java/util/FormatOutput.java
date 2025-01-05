package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author huy
 */
public class FormatOutput {
    public static String convertLocalDateTimeToString (LocalDateTime dateTime) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
    }
}
