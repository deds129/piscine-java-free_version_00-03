package com.company.day00;

import java.util.Scanner;

/*
    1) считаем кол-во уникальных символов
    2) массив из уникальных символов
    3) массив из повторений на каждый уникальный символ, сильная связь с 2)
    4)
    5)
 */


public class Ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int uniqueCharNum = uniqueCharCounter(input);
        char[] inputCharArr = input.toCharArray();
        char[] statsticArr = new char[uniqueCharNum];


    }

    public static int uniqueCharCounter(String str)
    {
        int counter = str.length();
        char[] charArr= str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (i != str.indexOf(charArr[i])) //indexOf - ищет первое вхождение
                counter--;
        }
        return counter;
    }

    public static int[] statisticToSymbols(String str)
    {
        return new int[0];
    }

    public static char[] onlyUniqueSymbols(String str)
    {
        return null;
    }
}
