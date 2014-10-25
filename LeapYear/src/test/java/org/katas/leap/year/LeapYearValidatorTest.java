package org.katas.leap.year;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LeapYearValidatorTest {

    private LeapYearValidator leapYearValidator;

    @Before
    public void setUp() throws Exception {
        leapYearValidator = new LeapYearValidator();
    }

    @Test
    public void recognisesAsLeapYearsWhichAreDivisibleBy400() throws Exception {
        IntStream leapYearsDivisibleBy400 = IntStream.of(1600, 2000, 2400);
        IntStream leapYearsNotDivisibleBy400 = IntStream.of(1601, 2001, 2401);

        Map<Integer, Boolean> leapYearValidationResults = IntStream
                .concat(leapYearsDivisibleBy400, leapYearsNotDivisibleBy400)
                .mapToObj(year -> year)
                .collect(toMap(year -> year, leapYearValidator::isLeapYear));

        assertThat(leapYearValidationResults.get(1600), is(true));
        assertThat(leapYearValidationResults.get(2000), is(true));
        assertThat(leapYearValidationResults.get(2400), is(true));

        assertThat(leapYearValidationResults.get(1601), is(false));
        assertThat(leapYearValidationResults.get(2001), is(false));
        assertThat(leapYearValidationResults.get(2401), is(false));
    }

    @Test
    public void recognisesAsRegularYearsWhichAreDivisibleBy100ButAreNotDivisibleBy400() throws Exception {
        IntStream leapYearsDivisibleBy100ButNotDivisibleBy400 = IntStream.of(1700, 1800, 1900, 2200);
        IntStream leapYearsDivisibleBy100AndDivisibleBy400 = IntStream.of(1600, 2000, 2400);

        Map<Integer, Boolean> leapYearValidationResults = IntStream
                .concat(
                        leapYearsDivisibleBy100ButNotDivisibleBy400,
                        leapYearsDivisibleBy100AndDivisibleBy400)
                .mapToObj(year -> year)
                .collect(toMap(year -> year, leapYearValidator::isLeapYear));

        assertThat(leapYearValidationResults.get(1700), is(false));
        assertThat(leapYearValidationResults.get(1800), is(false));
        assertThat(leapYearValidationResults.get(1900), is(false));
        assertThat(leapYearValidationResults.get(2200), is(false));

        assertThat(leapYearValidationResults.get(1600), is(true));
        assertThat(leapYearValidationResults.get(2000), is(true));
        assertThat(leapYearValidationResults.get(2400), is(true));
    }

    @Test
    public void recognisesAsLeapYearsWhichAreDivisibleBy4() throws Exception {
        IntStream leapYearsDivisibleBy4 = IntStream.of(1604, 1780,  1856, 1940, 2000, 2012);
        IntStream leapYearsNotDivisibleBy4 = IntStream.of(1603, 1779,  1855,  1939, 1999, 2010);

        Map<Integer, Boolean> leapYearValidationResults = IntStream
                .concat(leapYearsDivisibleBy4,leapYearsNotDivisibleBy4)
                .mapToObj(year -> year)
                .collect(toMap(year -> year, leapYearValidator::isLeapYear));

        assertThat(leapYearValidationResults.get(1604), is(true));
        assertThat(leapYearValidationResults.get(1780), is(true));
        assertThat(leapYearValidationResults.get(1856), is(true));
        assertThat(leapYearValidationResults.get(1940), is(true));
        assertThat(leapYearValidationResults.get(2000), is(true));
        assertThat(leapYearValidationResults.get(2012), is(true));

        assertThat(leapYearValidationResults.get(1603), is(false));
        assertThat(leapYearValidationResults.get(1779), is(false));
        assertThat(leapYearValidationResults.get(1855), is(false));
        assertThat(leapYearValidationResults.get(1939), is(false));
        assertThat(leapYearValidationResults.get(1999), is(false));
        assertThat(leapYearValidationResults.get(2010), is(false));
    }

}