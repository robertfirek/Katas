package org.katas.converter.roman.numeral;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {

    private final Map<Integer, String> units = new HashMap<Integer, String>() {{
        put(1, "I");
        put(2, "II");
        put(3, "III");
        put(4, "IV");
        put(5, "V");
        put(6, "VI");
        put(7, "VII");
        put(8, "VIII");
        put(9, "IX");
    }};

    private final Map<Integer, String> tens = new HashMap<Integer, String>() {{
        put(10, "X");
        put(20, "XX");
        put(30, "XXX");
        put(40, "XL");
        put(50, "L");
        put(60, "LX");
        put(70, "LXX");
        put(80, "LXXX");
        put(90, "XC");
    }};

    private final Map<Integer, String> hundreds = new HashMap<Integer, String>() {{
        put(100, "C");
        put(200, "CC");
        put(300, "CCC");
        put(400, "CD");
        put(500, "D");
        put(600, "DC");
        put(700, "DCC");
        put(800, "DCCC");
        put(900, "CM");
    }};

    private final Map<Integer, String> thousands = new HashMap<Integer, String>() {{
        put(1000, "M");
        put(2000, "MM");
        put(3000, "MMM");
    }};

    public String convert(int number) {
        int remainder = number;
        int numberOfThousands = remainder / 1000;

        remainder = number % 1000;
        int numberOfHundreds = remainder / 100;

        remainder = remainder % 100;
        int numberOfTens = remainder / 10;

        remainder = number % 10;
        int numberOfUnits = remainder / 1;

        StringBuilder romanNumeral = new StringBuilder();
        if (numberOfThousands > 0) {
            romanNumeral.append(this.thousands.get(numberOfThousands * 1000));
        }
        if (numberOfHundreds > 0) {
            romanNumeral.append(this.hundreds.get(numberOfHundreds * 100));
        }
        if (numberOfTens > 0) {
            romanNumeral.append(this.tens.get(numberOfTens * 10));
        }
        if (numberOfUnits > 0) {
            romanNumeral.append(this.units.get(numberOfUnits));
        }

        return romanNumeral.toString();
    }
}
