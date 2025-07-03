package org.incubyte;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        String[] tokens = numbers.split(",");
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}