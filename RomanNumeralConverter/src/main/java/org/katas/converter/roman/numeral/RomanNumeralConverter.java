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

    private final Map<Integer,String> tens = new HashMap<Integer,String>() {{
        put(10,"X");
        put(20,"XX");
        put(30,"XXX");
        put(40,"XL");
        put(50,"L");
        put(60,"LX");
        put(70,"LXX");
        put(80,"LXXX");
        put(90,"XC");
    }};

    public String convert(int number) {
        return number < 10 ? units.get(number) : tens.get(number);
    }
}
