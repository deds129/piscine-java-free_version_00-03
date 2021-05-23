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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

public class Program {
    public static void main(String[] args) {

//        if (args.length != 2) {
//            System.err.println("Invalid number of arguments passed");
//            return;
//        }
        ArrayList<String>  firstFileWords = new ArrayList<>();
        ArrayList<String>  secondFileWords = new ArrayList<>();
        TreeSet<String> dictionary = new TreeSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\deds\\Desktop\\piscine-java-free_version\\src\\com\\company\\day02\\ex01\\A.txt"));
             BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\deds\\Desktop\\piscine-java-free_version\\src\\com\\company\\day02\\ex01\\B.txt"))) {
            wordsToArray(br,firstFileWords,dictionary);
            wordsToArray(br2,secondFileWords,dictionary);
            System.out.println(firstFileWords);
            System.out.println(secondFileWords);
            System.out.println(dictionary);


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
