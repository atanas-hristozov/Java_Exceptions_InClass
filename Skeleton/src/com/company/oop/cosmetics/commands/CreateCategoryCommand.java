package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.utils.ValidationHelpersCommands;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;

import java.util.List;

public class CreateCategoryCommand implements Command {

    public static final String CATEGORY_ALREADY_EXISTS = "Category %s already exist.";
    private static final String CATEGORY_CREATED = "Category with name %s was created!";
    public static final int EXPECTED_PARAMETERS_COUNT = 1;
    public static final String CATEGORY_COMMAND = "Create Category";

    private final ProductRepository productRepository;

    public CreateCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpersCommands.ValidateParametersCount(parameters, EXPECTED_PARAMETERS_COUNT, CATEGORY_COMMAND);

        String categoryName = parameters.get(0);

        return createCategory(categoryName);
    }

    private String createCategory(String categoryName) {
        if(productRepository.categoryExist(categoryName)){
            throw new IllegalArgumentException(String.format(CATEGORY_ALREADY_EXISTS,categoryName));
        }

        productRepository.createCategory(categoryName);

        return String.format(CATEGORY_CREATED, categoryName);
    }

}
