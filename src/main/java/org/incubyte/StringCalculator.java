package org.incubyte;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    private int callCount = 0; // track number of Add calls

    public int getCalledCount() {
        return callCount;
    }

    public int add(String numbers) {
        callCount++;
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
        List<Integer> negatives = new ArrayList<>();
        int total = 0;

        for (String numStr : parts) {
            int num = Integer.parseInt(numStr);
            if (num < 0) {
                negatives.add(num);
            }
            total += num;
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }

        return total;
    }
}
