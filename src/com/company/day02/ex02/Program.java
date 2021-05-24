package com.company.day02.ex02;

public class Program {
    public static void main(String[] args) {
        //check flags
        //Program --current-folder=C:/MAIN
        if (!flagChecker(args))
            return ;
        System.out.println("Hello");
    }
    public static boolean flagChecker(String[] args)
    {
        //too many args
        if (args.length != 1) {
            System.err.println("Invalid number of arguments passed");
            return false;
        }
        //wrong file
        if (!(args[0].startsWith("--current-folder=")))
            return false;
        return true;
    }
}
