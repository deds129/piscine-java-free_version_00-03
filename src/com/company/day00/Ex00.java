package com.company.day00;

/*
Calculate the sum of digits of a six-digit int number (the number value is set directly
in the code by explicitly initializating the number variable).
 */

public class Ex00 {
    public static void main(String[] args) {
        int num = -479598;
        int sum = 0;
//        if (num < 0)
//            num *= -1;
        while (num > 0)
        {
            sum += num % 10;
            num /= 10;
        }
        System.out.println(sum);
    }
}
