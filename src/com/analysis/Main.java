package com.analysis;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static String[] getUserInput(){
        String[] s = { "", "", "" };

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a year (2006-2014)");
        s[0] = in.nextLine();
        System.out.println("Enter a month (01-12)");
        s[1] = in.nextLine();
        System.out.println("Enter a day (01-31)");
        s[2] = in.nextLine();

        in.close();
        return s;
    }

    public static String removeExtention(String fileNameExtension){
        String fileName = fileNameExtension;
        if (fileName.indexOf(".") > 0)
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
        return fileName;
    }

    public static Map<String, String> getFileNames(){
        Map<String, String> map = new HashMap<String, String>();

        File folder = new File("data");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                // Get file name, remove the extension and then split it and return the last bit
                String[] bits=removeExtention(listOfFiles[i].getName()).split("_");
                map.put(bits[bits.length-1], listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
        return map;
    }
    public static void main(String[] args) throws IOException {

        //String[] s = getUserInput();
        //System.out.print(s[0]+""+s[1]+""+s[2]);

        Map<String, String> map= getFileNames();

        System.out.println(map.get("2015"));

        for (String key : map.keySet()) {
            // use the key here
            System.out.println(key);
        }
    }
}
