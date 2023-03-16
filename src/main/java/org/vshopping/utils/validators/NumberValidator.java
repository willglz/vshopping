package org.vshopping.utils.validators;

public class NumberValidator {
    public static boolean greaterThanZero(double number){
        return number > 0.0;
    }

    public static boolean priceChecker(double number){
        return number > 10.0;
    }
}
