package com.company.day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
/*
Recommended types : Java Collections API (List<T>, Map<K, V> , etc.) InputStream,
OutputStream, FileInputStream, FileOutputStream

$java Program
-> C:/Users/Admin/images.png
PROCESSED
-> C/Users/Admin/Games/WoW.iso
PROCESSED
-> 42
 */

/*plan
1) read signatures -> put into map
2) in while read file name
3) try to open file
4) read bytes in file --- how many bytes
5) compare with map of signatures
6) OUTPUT to file / error
7) 42 - close
 */
public class Program {
    public static void main(String[] args) {

        Map<String, String> signaturesMap = new LinkedHashMap<String, String>(); // new HashMap<String, String>();
        try {
            readSignatures(signaturesMap);
            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();

            while (!(fileName.equals("42"))){
                try(FileInputStream fileInputStream = new FileInputStream(fileName)) {
                    int readByte = -1;
                    int readedSum = 0;
                    //space in file header to keep signature +- 24 bytes;
                    String data = "";
                    while ((readByte = fileInputStream.read()) != -1 && readedSum <= 24)
                    {
                        data += (char) readByte;
                        readedSum ++;
                    }
                    signatureEntry(signaturesMap, data);


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

    private static void signatureEntry(Map<String, String> signaturesMap, String data) throws FileNotFoundException {
        Iterator<Map.Entry<String, String>> iterator = signaturesMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();

            String key = pair.getKey();
            String value = pair.getValue() + "\n";
            if (data.contains(key))
            {
                outputToFile(value);
            }
        }
    }

    private static void outputToFile(String type) throws FileNotFoundException {
        //to main
        try(FileOutputStream fos = new FileOutputStream("C:\\Users\\deds\\Desktop\\piscine-java-free_version\\src\\com\\company\\day02\\results.txt",true)) {
           byte[] buffer = type.getBytes();
           fos.write(buffer,0,buffer.length);
            System.out.println("PROCESSED");
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * read signatures.txt -> put to Map
     *
     * @param signaturesMap
     */
    private static void readSignatures(Map<String, String> signaturesMap) throws IOException {

        String fileData = "";
        int readByte = -1;
        try (FileInputStream fis = new FileInputStream(
                "C:\\Users\\deds\\Desktop\\piscine-java-free_version\\src\\com\\company\\day02\\signatures.txt")) {
            while ((readByte = fis.read()) != -1)
                fileData += (char) readByte;

            String[] fileLines = fileData.split("\r\n");

            for (int i = 0; i < fileLines.length; i++) {
                String[] tmp = fileLines[i].split(",");
                //optional case
                if (tmp.length > 2) // ||
//                        !tmp[0].trim().toLowerCase().matches("[/(?:[A-Za-z]+)(?:[A-Za-z0-9 _]*)/]*") ||
//                        !tmp[0].trim().toLowerCase().matches("[/(?:[A-Za-z]+)(?:[A-Za-z0-9 _]*)/]*"))
                    throw new IOException("File not well-formated");
                //magicnum - key, word - value, 1 -> many

                signaturesMap.put(strHexToString(tmp[1].toLowerCase().trim()),tmp[0].trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String strHexToString(String str)
    {
        String ret = "";
        String[] strings = str.split(" ");
        for (int i = 0; i < strings.length ; i++) {
            ret += (char)Long.parseLong(strings[i],16);
        }
        return ret;
    }

}
