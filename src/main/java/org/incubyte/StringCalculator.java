package org.incubyte;

import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        String[] nums = numbers.split(",");
        return Arrays.stream(nums).mapToInt(Integer::parseInt).sum();
    }
}