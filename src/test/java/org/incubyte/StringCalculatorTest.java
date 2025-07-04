package org.incubyte;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void add_givenEmptyString_returnsZero() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void add_givenSingleNumber_returnsItSelf() {
        assertEquals(5, stringCalculator.add("5"));
    }

    @Test
    public void add_givenTwoCommaSeparatedNumbers_returnsAdditionOfBoth() {
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    void add_givenMultipleCommaSeparatedNumbers_returnsAdditionOfAll() {
        assertEquals(28, stringCalculator.add("6,3,7,8,4"));
    }

    @Test
    void add_givenCommaAndNewlineSeparatedNumbers_returnsAdditionOfAll() {
        assertEquals(65, stringCalculator.add("4\n8,5\n3,45"));
    }

    // format: "//[delimiter]\n[numbers]".
    @Test
    void add_givenCustomDelimiter_returnsAdditionOfAll() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    void add_givenMultipleNegatives_throwsWithAllInMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.add("1,-2,3,-4");
        });

        assertEquals("negatives not allowed: [-2, -4]", exception.getMessage());
    }

    @Test
    void getCalledCount_returnNumberOfAddCalls() {
        assertEquals(0, stringCalculator.getCalledCount()); // before any calls

        stringCalculator.add("1,2");
        assertEquals(1, stringCalculator.getCalledCount());

        stringCalculator.add("3");
        stringCalculator.add("4,5,6");
        assertEquals(3, stringCalculator.getCalledCount());
    }

    @Test
    void add_givenNumbersIncludeOver1000_returnsSumIgnoringOver1000() {
        assertEquals(2, stringCalculator.add("2,1001"));
        assertEquals(1002, stringCalculator.add("2,1000")); // 1000 is included
        assertEquals(0, stringCalculator.add("1001,2000"));
    }

    @Test
    void add_givenLongDelimiterWithBrackets_returnsSum() {
        assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    void add_givenMultipleDelimiters_returnsSum() {
        assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    void add_givenMultipleLongDelimiters_returnsSum() {
        assertEquals(6, stringCalculator.add("//[***][%%]\n1***2%%3"));
    }

    @Test
    void add_givenSpecialCharacterDelimiters_returnsSum() {
        assertEquals(10, stringCalculator.add("//[.] [!]\n2.3!5".replace(" ", "")));  // escape test
    }

    @Test
    void add_givenMultipleLongDelimitersWithSpecialCharacters_returnsSum() {
        assertEquals(6, stringCalculator.add("//[**][%%]\n1**2%%3"));
    }
}