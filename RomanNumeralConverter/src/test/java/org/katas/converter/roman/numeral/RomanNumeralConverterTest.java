package org.katas.converter.roman.numeral;

import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.mapping;
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
}