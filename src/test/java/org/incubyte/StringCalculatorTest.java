package org.incubyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private static StringCalculator stringCalculator;

    @BeforeAll
    public static void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void add_givenEmptyString_returnsZero() {
        Assertions.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void add_givenSingleNumber_returnsItSelf() {
        Assertions.assertEquals(5, stringCalculator.add("5"));
    }

    @Test
    public void add_givenTwoCommaSeparatedNumbers_returnsAdditionOfBoth() {
        Assertions.assertEquals(3, stringCalculator.add("1,2"));
    }
}
