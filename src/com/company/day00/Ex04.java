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

        char[] onlyUnique = onlyUniqueSymbols(input);
        char[] charArr = input.toCharArray();
        int[] sumbStat = sumbStatistic(onlyUnique,charArr);


        System.out.println(charArr);

        for (int i = 0; i < sumbStat.length; i++) {
            System.out.print(onlyUnique[i] + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < sumbStat.length; i++) {
            System.out.print(sumbStat[i] + " ");
        }
    }

    public static int[] sumbStatistic(char[] onlyUnique, char[] charArr)
    {
        int[] sumbStat = new int[onlyUnique.length];
        for (int i = 0; i < onlyUnique.length; i++) {
            for (int j = 0; j < charArr.length; j++) {
                if (onlyUnique[i] == charArr[j])
                {
                    sumbStat[i]++;
                }
            }
        }
        return sumbStat;
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

    public static char[] onlyUniqueSymbols(String str)
    {
        char[] charArr= str.toCharArray();
        int charCounter = uniqueCharCounter(str);
        char[] onlyUniqueSymb = new char[charCounter];

        int j = 0;

        for (int i = 0; i < str.length(); i++) {

            if (i == str.indexOf(charArr[i])) {//indexOf - ищет первое вхождение
                onlyUniqueSymb[j] = charArr[i];
                j++;
            }
        }
        return onlyUniqueSymb;
    }
}
