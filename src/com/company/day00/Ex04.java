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
        int[] symbStat = symbStatistic(onlyUnique,charArr);
        sortStatistics(onlyUnique, symbStat);

        /*
        test part
         */
        System.out.println(charArr);

        for (int i = 0; i < symbStat.length; i++) {
            System.out.print(onlyUnique[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < symbStat.length; i++) {
            System.out.print(symbStat[i] + " ");
        }
        System.out.println();
        sortStatistics(onlyUnique, symbStat);

        for (int i = 0; i < symbStat.length; i++) {
            System.out.print(onlyUnique[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < symbStat.length; i++) {
            System.out.print(symbStat[i] + " ");
        }

    }

    //bubble sort
    public static void sortStatistics(char[] uniqueSymb, int[] symbEntries)
    {
        for (int i = 0; i < symbEntries.length - 1 ; i++) {
            for (int j = i + 1; j < symbEntries.length; j++) {
                if (symbEntries[i] < symbEntries[j])
                {
                    char tempChar = uniqueSymb[j];
                    uniqueSymb[j] = uniqueSymb[i];
                    uniqueSymb[i] = tempChar;

                    int tmp = symbEntries[j];
                    symbEntries[j] = symbEntries[i];
                    symbEntries[i] = tmp;
                }
            }
        }
    }

    //replace to void
    public static int[] symbStatistic(char[] onlyUnique, char[] charArr)
    {
        int[] symbStat = new int[onlyUnique.length];
        for (int i = 0; i < onlyUnique.length; i++) {
            for (int j = 0; j < charArr.length; j++) {
                if (onlyUnique[i] == charArr[j])
                {
                    symbStat[i]++;
                }
            }
        }
        return symbStat;
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
