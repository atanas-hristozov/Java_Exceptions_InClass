package com.company.oop.cosmetics.commands.utils;

import java.util.List;

public class ValidationHelpersCommands {
    public static final String INVALID_PARAMETERS_COUNT = "%s command expects %d parameters.";
    public static void ValidateParametersCount(List<String> parameters, int validNumberOfParameters, String type) {
        if (parameters.size() < validNumberOfParameters || parameters.size() > validNumberOfParameters) {
            throw new IllegalArgumentException(String.format(INVALID_PARAMETERS_COUNT, type, validNumberOfParameters));
        }
    }
}
