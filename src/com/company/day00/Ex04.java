package com.company.day00;

/*
 * Status: not finished
 */

import java.util.Scanner;

/*
    1) считаем кол-во уникальных символов
    2) массив из уникальных символов
    3) массив из повторений на каждый уникальный символ, сильная связь с 2)
    4) вывод двуменрый массив
     /*
   36
    # 35
    #  #
    #  # 27
    #  #  #
    #  #  #
    #  #  #
    #  #  # 14 12
    #  #  #  #  # 9
    #  #  #  #  # # 7 4
    #  #  #  #  # # # # 2 2
    D  A  S  W  L K O T E R
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
        sortByAlp(onlyUnique, symbStat);


        int len = symbStat.length < 10 ? symbStat.length : 10;
        for (int i = 0; i < len; i++) {
            System.out.print(onlyUnique[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < len; i++) {
            System.out.print(symbStat[i] + "\t");
        }
       // System.out.println("\noutWidth res = " + outWidth(symbStat));
       // fillDupArray(onlyUnique, symbStat);




    }



    public static int outWidth(int[] sumbEntrines)
    {
        int width = 0;
        int len = sumbEntrines.length < 10 ? sumbEntrines.length : 10;

        if (sumbEntrines == null || sumbEntrines.length == 0 )
            return 0;

        for (int i = 0; i < len; i++) {
            if (sumbEntrines[i] > 99)
                width+= 3;
            else if (sumbEntrines[i] > 9)
                width+= 2;
            else if (sumbEntrines[i] > 0)
                width++;
            //wrong case
            else
                return 0;
        }
        return width + (len - 1);
    }

    public static void fillDupArray(char[] uniqueSymb, int[] symbEntries)
    {
        final int matrixHeight = 12;
        final int matrixWidth = outWidth(symbEntries);
        //todo: check empty arrays case
        //todo:

        char[][] outMatrix = new char[matrixHeight][matrixWidth];

        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                outMatrix[i][j] = 'o';
            }
        }

        //create last line


        //# fill

        //add staticstic

        //handle exception







        for (int i = 0; i < matrixHeight; i++) {
            System.out.println();
            for (int j = 0; j < matrixWidth; j++) {
                System.out.print(outMatrix[i][j]);
            }
        }


    }

    //
    public static int[] digitsCapacity(char[] uniqueSymb, int[] symbEntries)
    {
        int[] digitCapacity = new int[symbEntries.length];
        for (int i = 0; i < digitCapacity.length; i++) {
                if (symbEntries[i] > 99)
                    digitCapacity[i]+= 3;
                else if (symbEntries[i] > 9)
                    digitCapacity[i]+= 2;
                else if (symbEntries[i] > 0)
                    digitCapacity[i]++;
            }
        return digitCapacity;
    }

    public static void sortByAlp(char[] uniqueSymb, int[] symbEntries)
    {
        for (int i = 0; i < symbEntries.length - 1 ; i++) {
            for (int j = i + 1; j < symbEntries.length; j++) {
                if (symbEntries[i] == symbEntries[j])
                {
                    if (uniqueSymb[i] > uniqueSymb[j]) {
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
