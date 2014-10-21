package org.katas.converter.roman.numeral;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {

    private final Map<Integer,String> units = new HashMap<Integer,String>() {{
        put(1,"I");
        put(2,"II");
        put(3,"III");
        put(4,"IV");
        put(5,"V");
        put(6,"VI");
        put(7,"VII");
        put(8,"VIII");
        put(9,"IX");
    }};

    public String convert(int number) {
        return units.get(number);
    }
}
