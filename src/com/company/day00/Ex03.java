package com.company.day00;

import java.util.Arrays;
import java.util.Scanner;
/*
> Week 1
-> 4 5 2 4 2
-> Week 2
-> 7 7 7 7 6
-> Week 3
-> 4 3 4 9 8
-> Week 4
-> 9 9 4 6 7
-> 42
Week 1 ==>
Week 2 ======>
Week 3 ===>
Week 4 ====>

 */
public class Ex03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weekCount = -1;
        String input = scanner.nextLine();
        String nums = null;
        int[] lowestMarkArr = new int[18];
        while (!input.equals("42") && ++weekCount < 18)
        {
            if (input.equals("Week " + (weekCount + 1)))
            {
                //System.out.println(input);
                nums = scanner.nextLine();
                //System.out.println(nums);
                //can add our error handle
                int[] marks = Arrays.stream(nums.split(" ")).mapToInt(Integer::parseInt).toArray();
                if(marks.length > 5)
                    throwError();
                lowestMarkArr[weekCount] = findLowesNum(marks);
            }
            else {
                throwError();
                break;
            }
            input = scanner.nextLine();
        }
        resultOut(lowestMarkArr);

    }

    //todo: check marks 1-9
    private static boolean checkMarks(int[] marks) {
        for (int i = 0; i < marks.length; i++)
        {
            if (marks[i] > 9 && marks[i] < 1)
                return false;
        }
        return true;
    }

    public static void resultOut(int[] lowestMarks)
    {
        for(int i = 0; i < lowestMarks.length; i++)
        {
            if (lowestMarks[i] != 0) {
                System.out.printf("Week %d ", i + 1);
                //hardcode
                for (int j = 0; j < lowestMarks[i]; j++)
                {
                    System.out.print("=");
                }
                System.out.println(">");
            }
        }
    }

    public static void throwError()
    {
        System.err.println("theIllegalArgument ");
        System.exit(-1);
    }

    public static int findLowesNum(int[] num)
    {
        int min = num[0];
        for(int i = 0; i < num.length; i++)
        {
            if (num[i] < min)
                min = num[i];
        }
        return min;
    }
}
