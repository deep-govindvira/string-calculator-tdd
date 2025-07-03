package org.incubyte;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        String[] nums = split(numbers);
        return sum(nums);
    }

    private String[] split(String numbers) {
        String delimiter = ",|\n"; // default delimiters

        // Check for custom delimiter pattern
        if (numbers.startsWith("//")) {
            int newlineIndex = numbers.indexOf('\n');
            String customDelimiter = numbers.substring(2, newlineIndex);
            delimiter = Pattern.quote(customDelimiter); // quote to escape regex meta characters
            numbers = numbers.substring(newlineIndex + 1);
        }

        return numbers.split(delimiter);
    }

    private int sum(String[] parts) {
        return Arrays.stream(parts).mapToInt(Integer::parseInt).sum();
    }
}
