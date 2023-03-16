package org.vshopping.utils.validators;

public class StringValidator {
    public static boolean isBlankValidator(String value){
        return value.isBlank();
    }

    public static boolean isEmptyValidator(String value){
        return value.equals("");
    }

    public static boolean longValidator(String value){
        return value.length() < 4;
    }
}
