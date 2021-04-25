package com.company.day00;
/*
So, we need to implement a program that will count the number of elements for a specified
set of numbers whose sum of digits is a prime number.
To keep it simple, let’s assume that this potentially infinite sequence of queries is still
limited, and the last sequence element is number 42.
 */

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        int coffeCounter = 0;


        while (num != 42)
        {
            num = scanner.nextInt();
            if (num < 2) {
                System.err.println("theIllegalArgument ");
                System.exit(-1);
            }
            if (isPrimeDigitSum(num))
                coffeCounter++;
        }
        System.out.println("Count of coffee-request - " + coffeCounter);
    }

    public static boolean isPrimeDigitSum(int num)
    {
        boolean result = true;
        int i = 0;
        int sum = 0;

        while (num > 0)
        {
            sum += num % 10;
            num /= 10;
        }

        for (i = 2; i < Math.sqrt(sum); i++)
        {
            if (sum % i == 0)
            {
                result = false;
                break;
            }
        }
        return result;
    }
}
