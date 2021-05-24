package com.company.day02.ex02;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

/*
$ java Program --current-folder=C:/MAIN
C:/MAIN
-> ls
folder1 60 KB
folder2 90 KB
-> cd folder1
C:/MAIN/folder1
-> ls
image.jpg 10 KB
animation.gif 50 KB
-> mv image.jpg image2.jpg
-> ls
image2.jpg 10 KB
animation.gif 50 KB
-> mv animation.gif ../ folder2
-> ls
image2.jpg 10 KB
-> cd ../ folder2
C:/MAIN/folder2
-> ls
text. txt 10 KB
Program.java 80 KB
animation.gif 50 KB
-> exit

 //Program --current-folder=C:/
 */
public class Program {
    public static void main(String[] args) {
        //check flags

//        if (!flagChecker(args))
//            return ;
        try {
//            String rootPath = args[0].substring(args[0].indexOf('=') + 1);

            //turn rootPath
            startFromRootPath("C:/");

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void startFromRootPath(String rootPath)
    {
        File rootFile = new File(rootPath);
        if (rootFile.isDirectory())
        {
            String input = "";
            System.out.println(rootPath);
            Scanner scanner = new Scanner(System.in);
            while (!input.equals("exit")) {
                input = scanner.nextLine();
                if (input.equals("ls"))
                    showDirContent(rootFile);
                if (input.startsWith("cd "))
                {
                    String fileName = rootPath +"/"+ input.substring(input.indexOf(' ') + 1);
                    //System.out.println(fileName);
                    startFromRootPath(fileName);
                    break;
                }
                if (input.startsWith("mv "))
                {
                    //check to 2 files
                    String[] inputArgs = input.split(" ");
                    if (inputArgs.length == 3)
                    {
                        String file1;
                        String file2;
                        file1 = rootPath + "/" + inputArgs[1].trim();
                        file2 = rootPath + "/" + inputArgs[2].trim();
//                        System.out.println(file1);
//                        System.out.println(file2);
                        moveFile(rootFile, file1, file2);

                    }
                    else
                        System.out.println("Invalid number of arguments passed!");
                }
            }
        }
        else
            System.out.println("File is not directory");

    }

    public static void moveFile(File dir, String fileName1, String fileName2)
    {
        //Если в качестве аргументов заданы имена двух файлов, то имя первого файла будет изменено на имя второго.
        //if ()
        //Если последний аргумент является именем существующего каталога, то mv перемещает все заданные файлы в этот каталог.
    }

    public static void showDirContent(File dir) {
        if (dir.isDirectory()) {
            for (File item : Objects.requireNonNull(dir.listFiles())) {

                if (item.isDirectory()) {
                    System.out.println("folder:   " + "\t"
                            + item.getName() + " " + item.length() / 1024 + " KB");
                } else {
                        System.out.println("file  :   " + "\t"
                                + item.getName() + " " + item.length() / 1024 + " KB");
                }
            }
        }
    }

    public static boolean flagChecker(String[] args)
    {
        //too many args
        if (args.length != 1) {
            System.err.println("Invalid number of arguments passed");
            return false;
        }
        //wrong file
        if (!(args[0].startsWith("--current-folder="))) {
            System.err.println("Invalid flag");
            return false;
        }
        return true;
    }
}
