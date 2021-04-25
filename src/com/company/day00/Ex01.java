package com.company.day00;

import java.util.Scanner;

/*
Using these statements in Java, you need to determine if the input number is a
prime. A prime is a number which has no dividers other than the number itself and
1.
• The program accepts the number entered from the keyboard as input and displays
the result of checking whether that number is a prime. In addition, the program
shall output the number of steps (iterations) required to perform the check. In this
task, an iteration is a single comparison operation.
• For negative numbers, 0 and 1, display theIllegalArgument message and shut down
the program with the -1 code.

Example of program operation:
$ java Program
-> 169
false 12
$ java Program
-> 113
true 10
$ java Program
-> 42
false 1
 */

public class Ex01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        boolean result = true;
        int i = 0;
        if (num < 2)
            System.err.println("theIllegalArgument ");
        else
        {
           for (i = 2; i < Math.sqrt(num); i++)
           {
               if (num % i == 0)
               {
                   result = false;
                   break;
               }
           }
           System.out.println(result + " " + Integer.toString(i - 1));
        }
    }
}
