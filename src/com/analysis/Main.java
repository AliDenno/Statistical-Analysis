package com.analysis;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    public static ArrayList<String> getFileNames(){
        ArrayList<String> s = new ArrayList<>();

        File folder = new File("data");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                // Get file name, remove the extension and then split it and return the last bit
                String[] bits=removeExtention(listOfFiles[i].getName()).split("_");
                s.add( bits[bits.length-1]);
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
        return s;
    }
    public static void main(String[] args) throws IOException {

        //String[] s = getUserInput();
        //System.out.print(s[0]+""+s[1]+""+s[2]);

        ArrayList<String> s = getFileNames();
        for (String item : s) {
            System.out.println(item);
        }
    }
}
