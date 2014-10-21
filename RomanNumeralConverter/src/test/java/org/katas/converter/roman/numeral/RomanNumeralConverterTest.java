package org.katas.converter.roman.numeral;

import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RomanNumeralConverterTest {

    @Test
    public void canConvertUnits() throws Exception {
        final RomanNumeralConverter converter = new RomanNumeralConverter();

        List<String> unitAsRomanNumeral = IntStream.rangeClosed(1, 9)
                .mapToObj(unit -> converter.convert(unit)).collect(toList());

        assertThat(unitAsRomanNumeral.get(0), is("I"));
        assertThat(unitAsRomanNumeral.get(1), is("II"));
        assertThat(unitAsRomanNumeral.get(2), is("III"));
        assertThat(unitAsRomanNumeral.get(3), is("IV"));
        assertThat(unitAsRomanNumeral.get(4), is("V"));
        assertThat(unitAsRomanNumeral.get(5), is("VI"));
        assertThat(unitAsRomanNumeral.get(6), is("VII"));
        assertThat(unitAsRomanNumeral.get(7), is("VIII"));
        assertThat(unitAsRomanNumeral.get(8), is("IX"));
    }

    @Test
    public void canConvertTens() throws Exception {
        final RomanNumeralConverter converter = new RomanNumeralConverter();

        List<String> tensAsRomanNumeral = IntStream.rangeClosed(1, 9).map(it -> it * 10)
                .mapToObj(unit -> converter.convert(unit)).collect(toList());

        assertThat(tensAsRomanNumeral.get(0), is("X"));
        assertThat(tensAsRomanNumeral.get(1), is("XX"));
        assertThat(tensAsRomanNumeral.get(2), is("XXX"));
        assertThat(tensAsRomanNumeral.get(3), is("XL"));
        assertThat(tensAsRomanNumeral.get(4), is("L"));
        assertThat(tensAsRomanNumeral.get(5), is("LX"));
        assertThat(tensAsRomanNumeral.get(6), is("LXX"));
        assertThat(tensAsRomanNumeral.get(7), is("LXXX"));
        assertThat(tensAsRomanNumeral.get(8), is("XC"));
    }

    @Test
    public void canConvertHundreds() throws Exception {
        final RomanNumeralConverter converter = new RomanNumeralConverter();

        List<String> hundredsAsRomanNumeral = IntStream.rangeClosed(1, 9).map(it -> it * 100)
                .mapToObj(unit -> converter.convert(unit)).collect(toList());

        assertThat(hundredsAsRomanNumeral.get(0), is("C"));
        assertThat(hundredsAsRomanNumeral.get(1), is("CC"));
        assertThat(hundredsAsRomanNumeral.get(2), is("CCC"));
        assertThat(hundredsAsRomanNumeral.get(3), is("CD"));
        assertThat(hundredsAsRomanNumeral.get(4), is("D"));
        assertThat(hundredsAsRomanNumeral.get(5), is("DC"));
        assertThat(hundredsAsRomanNumeral.get(6), is("DCC"));
        assertThat(hundredsAsRomanNumeral.get(7), is("DCCC"));
        assertThat(hundredsAsRomanNumeral.get(8), is("CM"));
    }


}