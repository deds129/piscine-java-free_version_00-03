package com.company.day03.ex02;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlagValidator {

    private final int arraySize;
    private final int threadsCount;


    public FlagValidator() {
        this.arraySize = -1;
        this.threadsCount = -1;
    }

    public FlagValidator(String[] args) {
        //System.out.println(validateArgs(args));
        if (validateArgs(args)) {
            this.arraySize = getNumFromString(args[0]);
            this.threadsCount = getNumFromString(args[1]);
        }
        else {
            this.arraySize = -1;
            this.threadsCount = -1;
        }
    }


    public boolean validateArgs(String[] args) {
        if (args.length != 2)
            return false;
        else {
            Pattern pattern = Pattern.compile("--arraySize=(\\d*)");
            Pattern pattern1 = Pattern.compile("--threadsCount=(\\d*)");
            Matcher matcher = pattern.matcher(args[0]);
            Matcher matcher1 = pattern1.matcher(args[1]);
            return matcher.matches() & matcher1.matches();
        }
    }

    private int getNumFromString(String arg)
    {
        Pattern pattern = Pattern.compile("\\d*");
        Matcher matcher = pattern.matcher(arg);
        StringBuilder s = new StringBuilder();
        while(matcher.find()) {
           s.append(matcher.group()) ;
        }
        try {
            return Integer.parseInt(s.toString().trim());
        }catch (Exception e){
            return -1;}
    }

    public int getThreadsCount() {
        return threadsCount;
    }

    public int getArraySize() {
        return arraySize;
    }
}
