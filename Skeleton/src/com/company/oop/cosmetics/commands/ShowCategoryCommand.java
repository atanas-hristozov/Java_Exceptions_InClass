package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.utils.ValidationHelpersCommands;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.models.contracts.Category;

import java.util.List;

public class ShowCategoryCommand implements Command {

    public static final String SHOW_CATEGORY = "ShowCategory";
    public static final int EXPECTED_PARAMETERS = 1;
    private final ProductRepository productRepository;

    public ShowCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpersCommands.ValidateParametersCount(parameters, EXPECTED_PARAMETERS, SHOW_CATEGORY);

        String categoryName = parameters.get(0);

        return showCategory(categoryName);
    }

    private String showCategory(String categoryName) {
        Category category = productRepository.findCategoryByName(categoryName);

        return category.print();
    }

}
