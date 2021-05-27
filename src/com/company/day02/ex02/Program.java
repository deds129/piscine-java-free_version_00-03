package com.company.day02.ex02;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.util.Objects;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
public class Program {
    public static void main(String[] args) {
        if (!flagChecker(args))
            return ;
        try {
            String rootPath = args[0].substring(args[0].indexOf('=') + 1);
            startFromRootPath(rootPath);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void startFromRootPath(String rootPath) throws IOException {
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
               else if (input.startsWith("cd "))
                {
                    if(rootPath.endsWith("/"))
                        rootPath = rootPath + input.substring(input.indexOf(' ') + 1);
                    else
                        rootPath = rootPath + "/" + input.substring(input.indexOf(' ') + 1);
                    startFromRootPath(rootPath);
                    break;
                }
               else if (input.startsWith("mv "))
                {
                    String[] inputArgs = input.split(" ");
                    if (inputArgs.length == 3)
                    {
                        moveFile(rootFile, inputArgs[1].trim(), inputArgs[2].trim());
                    }
                    else
                        System.out.println("Invalid number of arguments passed!");
                }
               else
                    System.out.println("Command not found!");
            }
        }
        else
            System.out.println("File is not directory");

    }

    public static void moveFile(File rootPath, String pureFileName1, String mvFolder) throws IOException {

        String fileName1 = rootPath + "/" + pureFileName1;
        System.out.println(fileName1);
        System.out.println(mvFolder);
        Path testFile1 = Paths.get(fileName1);
        Path testFile2 = Paths.get(mvFolder);


        if (Files.exists(Paths.get(fileName1))) {
            //throws DirectoryNotEmptyException
            testFile1 = Files.move(testFile1, Paths.get(mvFolder), REPLACE_EXISTING);
            System.out.println(mvFolder);
        }


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
        if (args.length != 1) {
            System.err.println("Invalid number of arguments passed");
            return false;
        }
        if (!(args[0].startsWith("--current-folder="))) {
            System.err.println("Invalid flag");
            return false;
        }
        return true;
    }
}
