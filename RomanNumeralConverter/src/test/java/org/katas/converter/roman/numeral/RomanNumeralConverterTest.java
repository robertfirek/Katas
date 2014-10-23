package org.katas.converter.roman.numeral;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RomanNumeralConverterTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Test
    public void canConvertUnits() throws Exception {
        final RomanNumeralConverter converter = new RomanNumeralConverter();

        Map<Integer, String> unitsAsRomanNumeral = IntStream.rangeClosed(1, 9)
                .map(it -> it * 1).mapToObj(it -> it)
                .collect(
                        toMap(it -> it, unit -> converter.convert(unit))
                );

        assertThat(unitsAsRomanNumeral.get(1), is("I"));
        assertThat(unitsAsRomanNumeral.get(2), is("II"));
        assertThat(unitsAsRomanNumeral.get(3), is("III"));
        assertThat(unitsAsRomanNumeral.get(4), is("IV"));
        assertThat(unitsAsRomanNumeral.get(5), is("V"));
        assertThat(unitsAsRomanNumeral.get(6), is("VI"));
        assertThat(unitsAsRomanNumeral.get(7), is("VII"));
        assertThat(unitsAsRomanNumeral.get(8), is("VIII"));
        assertThat(unitsAsRomanNumeral.get(9), is("IX"));
    }

    @Test
    public void canConvertTens() throws Exception {
        final RomanNumeralConverter converter = new RomanNumeralConverter();

        Map<Integer, String> tensAsRomanNumeral = IntStream.rangeClosed(1, 9)
                .map(it -> it * 10).mapToObj(it -> it)
                .collect(
                        toMap(it -> it, unit -> converter.convert(unit))
                );

        assertThat(tensAsRomanNumeral.get(10), is("X"));
        assertThat(tensAsRomanNumeral.get(20), is("XX"));
        assertThat(tensAsRomanNumeral.get(30), is("XXX"));
        assertThat(tensAsRomanNumeral.get(40), is("XL"));
        assertThat(tensAsRomanNumeral.get(50), is("L"));
        assertThat(tensAsRomanNumeral.get(60), is("LX"));
        assertThat(tensAsRomanNumeral.get(70), is("LXX"));
        assertThat(tensAsRomanNumeral.get(80), is("LXXX"));
        assertThat(tensAsRomanNumeral.get(90), is("XC"));
    }

    @Test
    public void canConvertHundreds() throws Exception {
        final RomanNumeralConverter converter = new RomanNumeralConverter();

        Map<Integer, String> hundredsAsRomanNumeral = IntStream.rangeClosed(1, 9)
                .map(it -> it * 100).mapToObj(it -> it)
                .collect(
                        toMap(it -> it, unit -> converter.convert(unit))
                );

        assertThat(hundredsAsRomanNumeral.get(100), is("C"));
        assertThat(hundredsAsRomanNumeral.get(200), is("CC"));
        assertThat(hundredsAsRomanNumeral.get(300), is("CCC"));
        assertThat(hundredsAsRomanNumeral.get(400), is("CD"));
        assertThat(hundredsAsRomanNumeral.get(500), is("D"));
        assertThat(hundredsAsRomanNumeral.get(600), is("DC"));
        assertThat(hundredsAsRomanNumeral.get(700), is("DCC"));
        assertThat(hundredsAsRomanNumeral.get(800), is("DCCC"));
        assertThat(hundredsAsRomanNumeral.get(900), is("CM"));
    }

    @Test
    public void canConvertThousands() throws Exception {
        final RomanNumeralConverter converter = new RomanNumeralConverter();

        Map<Integer, String> thousandsAsRomanNumeral = IntStream.rangeClosed(1, 3)
                .map(it -> it * 1000).mapToObj(it -> it)
                .collect(
                        toMap(it -> it, unit -> converter.convert(unit))
                );

        assertThat(thousandsAsRomanNumeral.get(1000), is("M"));
        assertThat(thousandsAsRomanNumeral.get(2000), is("MM"));
        assertThat(thousandsAsRomanNumeral.get(3000), is("MMM"));
    }

    @Test
    public void canConvertCombinationOfUnitsTensHundredsAndThousands() throws Exception {
        final RomanNumeralConverter converter = new RomanNumeralConverter();
        int firstNumber = 2499;
        int seconNumber = 3949;
        int numberWithoutUnits = 3940;
        int numberWithoutTens = 3906;
        int numberWithoutHundreds = 3043;
        int numberWithoutThousands = 721;

        assertThat(converter.convert(firstNumber), is("MMCDXCIX"));
        assertThat(converter.convert(seconNumber), is("MMMCMXLIX"));
        assertThat(converter.convert(numberWithoutUnits), is("MMMCMXL"));
        assertThat(converter.convert(numberWithoutTens), is("MMMCMVI"));
        assertThat(converter.convert(numberWithoutHundreds), is("MMMXLIII"));
        assertThat(converter.convert(numberWithoutThousands), is("DCCXXI"));
    }

    @Test
    public void canOnlyConvertPositiveNumberGreaterThenZero() throws Exception {
        final RomanNumeralConverter converter = new RomanNumeralConverter();
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(is("Number must be in range [1,3999]."));

        converter.convert(-1);
    }

    @Test
    public void canOnlyConvertNumberLowerThen3999() throws Exception {
        final RomanNumeralConverter converter = new RomanNumeralConverter();
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(is("Number must be in range [1,3999]."));

        converter.convert(4000);
    }
}