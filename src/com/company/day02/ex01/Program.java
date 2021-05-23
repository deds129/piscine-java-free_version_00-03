//remove to norm work
package com.company.day02.ex01;

import java.io.*;
import java.util.*;

public class Program {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Invalid number of arguments passed");
            return;
        }
        ArrayList<String>  firstFileWords = new ArrayList<>();
        ArrayList<String>  secondFileWords = new ArrayList<>();
        TreeSet<String> dictionary = new TreeSet<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader(args[0]));
             BufferedReader br2 = new BufferedReader(
                     new FileReader(args[1]));
             BufferedWriter bw = new BufferedWriter(
                     new FileWriter("dictionary.txt"))) {

            wordsToArray(br,firstFileWords,dictionary);
            wordsToArray(br2,secondFileWords,dictionary);

            outputDictionary(bw, dictionary);
            double res = countFrequency(firstFileWords, secondFileWords, dictionary);
            System.out.printf("Similarity = %.2f", res);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static double countFrequency(ArrayList<String> firstFileWords, ArrayList<String> secondFileWords, TreeSet<String> dictionary) {


        ArrayList<Integer> firstWordsEntries = new ArrayList<>();
        ArrayList<Integer> secondWordsEntries = new ArrayList<>();
        double result = -1;
        countEntries(firstFileWords,firstWordsEntries,dictionary);
        countEntries(secondFileWords,secondWordsEntries,dictionary);
        if (firstWordsEntries.size() == secondWordsEntries.size())
        {
            double numerator = 0;
            double denumerator = 1;
            for (int i = 0; i < firstWordsEntries.size() ; i++) {
                numerator += firstWordsEntries.get(i) * secondWordsEntries.get(i);
            }


            double tmp = 0;
            for (int i = 0; i < firstWordsEntries.size() ; i++) {
               tmp += Math.pow(firstWordsEntries.get(i), 2) ;
            }

            double temp = 0;
            for (int i = 0; i < secondWordsEntries.size(); i++) {
                temp += Math.pow(secondWordsEntries.get(i), 2);
            }
            denumerator = Math.sqrt(tmp) * Math.sqrt(temp);
            result = numerator / denumerator;
        }
        return result;
    }
    public static void countEntries(ArrayList<String> fileWords, ArrayList<Integer> wordsEntries, TreeSet<String> dictionary)
    {
        int couter;
        Iterator<String> iterator = dictionary.iterator();
        while (iterator.hasNext())
        {
            couter = 0;
            String tmp = iterator.next();
            Iterator<String> iterator1 = fileWords.iterator();
            while (iterator1.hasNext())
            {
                if (iterator1.next().equals(tmp))
                    couter++;
            }
            wordsEntries.add(couter);
        }
    }

    public static void outputDictionary( BufferedWriter bw,TreeSet<String> dictionary) throws IOException {
        ArrayList<String> dictArray = new ArrayList<>(dictionary);
        for (int i = 0; i < dictArray.size() - 1; i++) {
            bw.write(dictArray.get(i) + ", ");
        }
        bw.write(dictArray.get(dictArray.size()- 1 ));
    }

    public static void wordsToArray(BufferedReader bufferedReader,
                                    ArrayList<String> worldList,
                                    TreeSet<String> dictionary) throws IOException {
        String tmp;
        while ((tmp = bufferedReader.readLine()) != null)
        {
           //tmp = reformatPunct(tmp);
            String[] lineWords = tmp.split(" ");
            for (String lineWord : lineWords) {
                worldList.add(lineWord);
                dictionary.add(lineWord);
            }
        }
    }

    //can use to compare text w/o punctuation
    //additionaly point
    public static String reformatPunct(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c) || Character.isSpaceChar(c)) {
                result.append(c);
            }
        }
        return result.toString().toLowerCase();
    }
}
