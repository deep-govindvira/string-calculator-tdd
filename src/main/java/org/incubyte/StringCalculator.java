package org.incubyte;

import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        String[] nums = split(numbers);
        return sum(nums);
    }

    private String[] split(String numbers) {
        return numbers.split(",|\n");
    }

    private int sum(String[] parts) {
        return Arrays.stream(parts).mapToInt(Integer::parseInt).sum();
    }
}
