package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.utils.ValidationHelpers;

public class ProductImpl implements Product {

    private static final String PRODUCT = "Product";
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_MIN_LENGTH = 2;
    private String name;
    private String brand;
    private double price;
    private final GenderType gender;

    public ProductImpl(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        ValidationHelpers.ValidateNameLength(name.length(), NAME_MIN_LENGTH, NAME_MAX_LENGTH, PRODUCT);
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        ValidationHelpers.ValidateBrandLength(brand.length(), BRAND_MIN_LENGTH, NAME_MAX_LENGTH, PRODUCT);
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        ValidationHelpers.ValidatePrice(price);
        this.price = price;
    }

    public GenderType getGender() {
        return gender;
    }

    @Override
    public String print() {
        return String.format(
                "#%s %s%n" +
                        " #Price: $%.2f%n" +
                        " #Gender: %s%n",
                name,
                brand,
                price,
                gender);
    }

}
