package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.commands.utils.ParsingHelpersCommands;
import com.company.oop.cosmetics.commands.utils.ValidationHelpersCommands;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.models.GenderType;

import java.util.List;

public class CreateProductCommand implements Command {

    private static final String PRODUCT_CREATED = "Product with name %s was created!";
    public static final int EXPECTED_PARAMETERS_COUNT = 4;
    public static final String CREATE_PRODUCT = "CreateProduct";
    public static final String PRODUCT_ALREADY_EXIST = "Product %s already exist.";

    private final ProductRepository productRepository;

    public CreateProductCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpersCommands.ValidateParametersCount(parameters, EXPECTED_PARAMETERS_COUNT, CREATE_PRODUCT);

        String name = parameters.get(0);
        String brand = parameters.get(1);
        double price = ParsingHelpersCommands.parseDouble(parameters.get(2));
        GenderType gender = ParsingHelpersCommands.parseGender(parameters.get(3).toUpperCase());

        return createProduct(name, brand, price, gender);
    }

    private String createProduct(String name, String brand, double price, GenderType gender) {
        if(productRepository.productExist(name)){
            throw new IllegalArgumentException(String.format(PRODUCT_ALREADY_EXIST,name));
        }

        productRepository.createProduct(name, brand, price, gender);

        return String.format(PRODUCT_CREATED, name);
    }

}
