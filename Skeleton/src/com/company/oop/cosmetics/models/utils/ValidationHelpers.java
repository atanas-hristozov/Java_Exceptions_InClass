package com.company.oop.cosmetics.models.utils;


public class ValidationHelpers {

    public static final String INVALID_NAME_LENGTH = "%s name should be between %d and %d symbols.";
    public static final String INVALID_BRAND_LENGTH = "%s brand should be between %d and %d symbols.";
    public static final String NEGATIVE_PRICE = "Price can't be negative.";

    public static void ValidateNameLength(int actualLength, int minLength, int maxLength, String type) {
        if (actualLength < minLength || actualLength > maxLength) {
            throw new IllegalArgumentException(String.format(INVALID_NAME_LENGTH, type, minLength, maxLength));
        }
    }


    public static void ValidateBrandLength(int actualLength, int minLength, int maxLength, String typeBrand) {
        if(actualLength < minLength || actualLength > maxLength){
            throw new IllegalArgumentException(String.format(INVALID_BRAND_LENGTH,typeBrand,minLength,maxLength));
        }
    }

    public static void ValidatePrice(double price){
        if (price<0){
            throw new IllegalArgumentException(NEGATIVE_PRICE);
        }
    }

}
