package com.company.day02.ex00;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Map<String, String> signaturesMap = new LinkedHashMap<>();
        try {
            readSignatures(signaturesMap);
            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();

            while (!(fileName.equals("42"))){
                try(FileInputStream fileInputStream = new FileInputStream(fileName)) {
                    int readByte;
                    int readedSum = 0;
                    StringBuilder data = new StringBuilder();
                    while ((readByte = fileInputStream.read()) != -1 && readedSum <= 24) {
                        data.append((char) readByte);
                        readedSum ++;
                    }
                    signatureEntry(signaturesMap, data.toString());
                }catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                fileName = scanner.nextLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void signatureEntry(Map<String, String> signaturesMap, String data) throws IOException {
        Iterator<Map.Entry<String, String>> iterator = signaturesMap.entrySet().iterator();
        boolean foundFlag = false;
        try(FileOutputStream fos = new FileOutputStream("C:\\Users\\deds\\Desktop\\piscine-java-free_version\\src\\com\\company\\day02\\results.txt")) {
            while (iterator.hasNext()) {
                Map.Entry<String, String> pair = iterator.next();

                String key = pair.getKey();
                String value = pair.getValue() + "\n";
                if (data.contains(key)) {
                    outputToFile(value,fos);
                    foundFlag = true;
                }
            }
            if (!foundFlag)
                System.out.println("UNDEFINED");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void outputToFile(String type, FileOutputStream fos) throws IOException {
           byte[] buffer = type.getBytes();
           fos.write(buffer,0,buffer.length);
            System.out.println("PROCESSED");
    }

    private static void readSignatures(Map<String, String> signaturesMap) throws IOException {

        StringBuilder fileData = new StringBuilder();
        int readByte;
        try (FileInputStream fis = new FileInputStream(
                "C:\\Users\\deds\\Desktop\\piscine-java-free_version\\src\\com\\company\\day02\\signatures.txt")) {
            while ((readByte = fis.read()) != -1)
                fileData.append((char) readByte);

            String[] fileLines = fileData.toString().split("\r\n");

            for (String fileLine : fileLines) {
                String[] tmp = fileLine.split(",");
                //optional case
                if (tmp.length > 2) // ||
//                        !tmp[0].trim().toLowerCase().matches("[/(?:[A-Za-z]+)(?:[A-Za-z0-9 _]*)/]*") ||
//                        !tmp[0].trim().toLowerCase().matches("[/(?:[A-Za-z]+)(?:[A-Za-z0-9 _]*)/]*"))
                    throw new IOException("File not well-formated");
                signaturesMap.put(strHexToString(tmp[1].toLowerCase().trim()), tmp[0].trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String strHexToString(String str)
    {
        StringBuilder ret = new StringBuilder();
        String[] strings = str.split(" ");
        for (String string : strings) {
            ret.append((char) Long.parseLong(string, 16));
        }
        return ret.toString();
    }
}
