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

        if (numbers.startsWith("//")) {
            int newlineIndex = numbers.indexOf('\n');
            String delimiterSection = numbers.substring(2, newlineIndex);
            numbers = numbers.substring(newlineIndex + 1); // skip the delimiter part

            // Handle multiple delimiters like //[***][%%]
            if (delimiterSection.contains("[") && delimiterSection.contains("]")) {
                List<String> delimiters = new ArrayList<>();
                int i = 0;
                while (i < delimiterSection.length()) {
                    int start = delimiterSection.indexOf('[', i);
                    int end = delimiterSection.indexOf(']', start);
                    if (start == -1 || end == -1) break;
                    String d = delimiterSection.substring(start + 1, end);
                    delimiters.add(Pattern.quote(d));
                    i = end + 1;
                }
                delimiter = String.join("|", delimiters);
            } else {
                // Single-char delimiter
                delimiter = Pattern.quote(delimiterSection);
            }
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
            } else if (num <= 1000) {
                total += num;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }

        return total;
    }
}
