/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author huy
 */
public class ValidateInput {
    private static final String EMAIL_REGEX =  "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    
    public static boolean checkEmailFormat(String text) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}
