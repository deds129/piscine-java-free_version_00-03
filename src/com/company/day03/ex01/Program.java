package com.company.day03.ex01;

public class Program {
    public static void main(String[] args) {


    }

    public static int validateFlag(String[] args)
    {
        int count = -1;
        if (args == null)
            return count;
        if (!args[0].startsWith("--count=") ||
                args.length != 1)
            return count;
        try {
            count = Integer.parseInt(args[0].substring(args[0].indexOf("=") + 1));
        }catch (NumberFormatException e){
            return -1;
        }
        return count;
    }
}
