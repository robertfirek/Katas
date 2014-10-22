package org.katas.converter.roman.numeral;

import java.util.Optional;
import java.util.stream.Stream;

public class RomanNumeralConverter {

    public String convert(int number) {
        RomanNumeralBuilder romanNumeralBuilder = new RomanNumeralBuilder(number);

        Optional<RomanNumeralBuilder> optionaRomanNumeralBuilder = Stream.<RomanNumeralBuilder>builder().add(romanNumeralBuilder).build()
                .map(builder -> builder.appendRomanNumeral(getRomanNumeral(builder.getReminder() / 1000, "M", "M", "M"), builder.getReminder() % 1000))
                .map(builder -> builder.appendRomanNumeral(getRomanNumeral(builder.getReminder() / 100, "C", "D", "M"), builder.getReminder() % 100))
                .map(builder -> builder.appendRomanNumeral(getRomanNumeral(builder.getReminder() / 10, "X", "L", "C"), builder.getReminder() % 10))
                .map(builder -> builder.appendRomanNumeral(getRomanNumeral(builder.getReminder(), "I", "V", "X"), builder.getReminder() % 1))
                .findFirst();

        return optionaRomanNumeralBuilder.get().getRomanNumeralString();
    }

    private String getRomanNumeral(int number, String prefix, String middle, String suffix) {
        switch (number) {
            case 1:
            case 2:
            case 3:
                return repeatString(prefix, number);
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return repeatString(prefix, number == 4 ? 1 : 0) + middle + repeatString(prefix, number > 5 ? number % 5 : 0);
            case 9:
                return prefix + suffix;
            default:
                return "";
        }
    }

    private static String repeatString(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    private static class RomanNumeralBuilder {
        private final String romanNumeralString;
        private final int reminder;

        public RomanNumeralBuilder(int reminder) {
            this.romanNumeralString = "";
            this.reminder = reminder;
        }

        private RomanNumeralBuilder(String romanNumeralString, int reminder) {
            this.romanNumeralString = romanNumeralString;
            this.reminder = reminder;
        }

        public String getRomanNumeralString() {
            return romanNumeralString;
        }

        public int getReminder() {
            return reminder;
        }

        public RomanNumeralBuilder appendRomanNumeral(String romanNumeralString, int reminder) {
            return new RomanNumeralBuilder(this.romanNumeralString + romanNumeralString, reminder);
        }
    }
}
