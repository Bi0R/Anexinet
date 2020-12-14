package com.anexinet.abreutest.baseconversion;

import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberConverter {

    //This map contains regular expressions to validate characters for the diven base
    private static Map<Integer, String> baseValidationRegex = Stream.of(new Object[][]{
            {2, "^[0-1]+$"},
            {8, "^[0-7]+$"},
            {10, "^[0-9]+$"},
            {16, "^[A-F0-9]+$"}
    }).collect(Collectors.toMap(p -> (Integer)p[0], p -> (String)p[1]));

    /**
     * Converts String in Base X to integer, with X in {2, 8, 10, 16}
     * @param number String with the number to be converted
     * @param base
     * @return int number converted, -1 if the conversion was not possible
     */
    public static int converToDecimal(String number, int base) {
        number = number.toUpperCase(Locale.ROOT);
        int result = -1;
        if(baseValidationRegex.containsKey(base)){
            Pattern pattern = Pattern.compile(baseValidationRegex.get(base));
            Matcher matcher = pattern.matcher(number);
            if(matcher.matches()){
                result = Integer.parseInt(number,base);
            }else{
                System.out.println("The number "+number+" doesn't have the correct format for base "+base);
            }
        }else{
            System.out.println("Base not supported, try with 2,8, 10 or 16");
        }
        return  result;
    }
}
