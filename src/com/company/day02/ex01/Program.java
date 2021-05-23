//remove to norm work
package com.company.day02.ex01;

/*
Now you need to implement an application that will determine the level of similarity
between texts. The simplest and most obvious method to do this is to analyze the
frequency of occurrence of the same words.
Your goal is to implement an application that accepts two files as an input (both files are
passed as command-line arguments) and displays their similarity comparison outcome
(cosine measure).
The program shall also create dictionary.txt file containing a dictionary based on these
files.
 */

/* todo:
    1)read files + read words (from terminal)
    2)create dictionary to save all word from files
    2.1) save dictionary to file(dictionary.txt)
    3)create vectors to save word frequency
    4)count similarity using formula
    5)output result
 */

import java.io.*;
import java.util.*;

public class Program {
    public static void main(String[] args) {

//        if (args.length != 2) {
//            System.err.println("Invalid number of arguments passed");
//            return;
//        }
        ArrayList<String>  firstFileWords = new ArrayList<>();
        ArrayList<String>  secondFileWords = new ArrayList<>();
        TreeSet<String> dictionary = new TreeSet<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\deds\\Desktop\\piscine-java-free_version\\src\\com\\company\\day02\\ex01\\A.txt"));
             BufferedReader br2 = new BufferedReader(
                     new FileReader("C:\\Users\\deds\\Desktop\\piscine-java-free_version\\src\\com\\company\\day02\\ex01\\B.txt"));
             BufferedWriter bw = new BufferedWriter(
                     new FileWriter("C:\\Users\\deds\\Desktop\\piscine-java-free_version\\src\\com\\company\\day02\\ex01\\dictionary.txt"))) {

            wordsToArray(br,firstFileWords,dictionary);
            wordsToArray(br2,secondFileWords,dictionary);

            outputDictionary(bw, dictionary);

            countFrequency(firstFileWords, secondFileWords, dictionary);
//            System.out.println(firstFileWords);
//            System.out.println(secondFileWords);
//            System.out.println(dictionary);


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void countFrequency(ArrayList<String> firstFileWords, ArrayList<String> secondFileWords, TreeSet<String> dictionary) {
        ArrayList<Integer> firstWordsEntries = new ArrayList<>(dictionary.size());
        ArrayList<Integer> secondWordsEntries = new ArrayList<>(dictionary.size());
        countEntries(firstFileWords,firstWordsEntries,dictionary);
        countEntries(secondFileWords,secondWordsEntries,dictionary);

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
        System.out.println(wordsEntries);
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

    //have to replace using regex
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
