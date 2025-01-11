package util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInput {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String INPUT_DATE_PATTERN = "d/M/y";

    public static boolean isValidEmail(String text) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static <T extends Number> boolean isEqualZero(T number) {
        return new BigDecimal(number + "").compareTo(BigDecimal.ZERO) == 0;
    }

    public static boolean isBeforeSecondDate(String dateString, String anotherDateString) {
        if (!isValidDate(dateString)) {
            return false;
        }
        if (!isValidDate(anotherDateString)) {
            return false;
        }
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter
                .ofPattern(INPUT_DATE_PATTERN));
        LocalDate anotherDate = LocalDate.parse(anotherDateString, DateTimeFormatter
                .ofPattern(INPUT_DATE_PATTERN));
        return date.isBefore(anotherDate);

    }

    public static boolean isValidDate(String dateString) {
        try {
            LocalDate.parse(dateString, DateTimeFormatter
                    .ofPattern(INPUT_DATE_PATTERN));
            return true;
        } catch (DateTimeException dte) {
        }
        return false;
    }

    public static boolean isValidHour(String str) {
        if (!isAPositiveInteger(str)) {
            return false;
        }
        return Integer.parseInt(str) <= 23;
    }

    public static boolean isValidMinute(String str) {
        if (!isAPositiveInteger(str)) {
            return false;
        }
        return Integer.parseInt(str) <= 59;
    }

    public static boolean isValidSecond(String str) {
        if (!isAPositiveInteger(str)) {
            return false;
        }
        return Integer.parseInt(str) <= 59;
    }

    public static boolean isAPositiveInteger(String str) {
        try {
            BigInteger number = new BigInteger(str.trim());
            return number.compareTo(BigInteger.ZERO) >= 0;
        } catch (NumberFormatException nfe) {
        }
        return false;
    }

    public static boolean isAPositiveNumber(String str) {
        try {
            BigDecimal number = new BigDecimal(str.trim());
            return number.compareTo(BigDecimal.ZERO) >= 0;
        } catch (NumberFormatException nfe) {
        }
        return false;
    }
}
