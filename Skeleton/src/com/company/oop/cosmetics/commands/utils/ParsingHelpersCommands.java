package com.company.oop.cosmetics.commands.utils;
import com.company.oop.cosmetics.commands.CommandType;
import com.company.oop.cosmetics.models.GenderType;

public class ParsingHelpersCommands{
    public static final String INVALID_COMMAND = "Command %s is not supported.";
    private static final String INVALID_PRICE_INPUT = "Third parameter should be price (real number).";
    private static final String NO_SUCH_GENDERTYPE_ENUM = "Forth parameter should be one of Men, Women or Unisex.";
    public static double parseDouble(String valueToParse) {
        try {
            return Double.parseDouble(valueToParse);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PRICE_INPUT);
        }
    }
    public static GenderType parseGender(String valueToParse) {
        try {
            return GenderType.valueOf(valueToParse.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NO_SUCH_GENDERTYPE_ENUM);
        }
    }
    public static CommandType parseCommand(String valueToParse){
        try{
            return CommandType.valueOf(valueToParse.toUpperCase());
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format(INVALID_COMMAND,valueToParse));
        }
    }
}
