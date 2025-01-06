package util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInput {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String INPUT_DATE_PATTERN = "d/M/y";

    public static boolean checkEmailFormat(String text) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean checkIfNoInput(String str) {
        if ("".equalsIgnoreCase(str)) {
            System.out.println("Input is required!");
            return true;
        }
        return false;
    }

    public static <E> boolean checkIfListEmpty(List<E> goodsList) {
        if (goodsList.isEmpty()) {
            System.out.println("Cannot process in an empty List!");
            return true;
        }
        return false;
    }

    public static <T extends Number> boolean checkIfNumberNegative(T number) {
        BigDecimal numToBigDecimal = new BigDecimal(number + "");
        if (numToBigDecimal.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("This number cannot take a negative value!");
            return true;
        }
        return false;
    }

    public static <T extends Number> boolean checkIfNumberEqualZero(T number) {
        BigDecimal numToBigDecimal = new BigDecimal(number + "");
        if (numToBigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("This number cannot equal zero!");
            return true;
        }
        return false;
    }

    public static <T extends Number> boolean checkIfNumberNegativeForGUI(T number) {
        return new BigDecimal(number + "").compareTo(BigDecimal.ZERO) < 0;
    }

    public static boolean checkIfDateIsBeforeAnotherDate(String dateString, String anotherDateString) {
        if (!checkIfValidDate(dateString)) {
            return false;
        }
        if (!checkIfValidDate(anotherDateString)) {
            return false;
        }
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter
                .ofPattern(INPUT_DATE_PATTERN));
        LocalDate anotherDate = LocalDate.parse(anotherDateString, DateTimeFormatter
                .ofPattern(INPUT_DATE_PATTERN));
        return date.isBefore(anotherDate) || date.isEqual(date);
    }

    public static boolean checkIfValidDate(String dateString) {
        try {
            LocalDate.parse(dateString, DateTimeFormatter
                    .ofPattern(INPUT_DATE_PATTERN));
            return true;
        } catch (DateTimeException dte) {
        }
        return false;
    }

    public static boolean checkIfValidHours(String str) {
        if (!checkIfANumberSequenceForGUI(str)) {
            return false;
        }
        return Integer.parseInt(str) <= 23;
    }

    public static boolean checkIfValidMinute(String str) {
        if (!checkIfANumberSequenceForGUI(str)) {
            return false;
        }
        return Integer.parseInt(str) <= 59;
    }

    public static boolean checkIfValidSecond(String str) {
        if (!checkIfANumberSequenceForGUI(str)) {
            return false;
        }
        return Integer.parseInt(str) <= 59;
    }

    public static boolean checkIfANumberSequenceForGUI(String str) {
        try {
            BigInteger number = new BigInteger(str.trim());
            if (!checkIfNumberNegativeForGUI(number)) {
                return true;
            }
        } catch (NumberFormatException nfe) {
        }
        return false;
    }

    public static boolean checkIfAValidNumberForGUI(String str) {
        try {
            BigDecimal number = new BigDecimal(str.trim());
            if (!checkIfNumberNegativeForGUI(number)) {
                return true;
            }
        } catch (NumberFormatException nfe) {
        }
        return false;
    }
}
