package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String path= scanner.nextLine();
        String name="",extension="";
        int startIndex = path.lastIndexOf('\\');
        int middleIndex = path.lastIndexOf('.');
        name=path.substring(startIndex+1,middleIndex);
        extension=path.substring(middleIndex+1);
        System.out.println("File name: "+name);
        System.out.println("File extension: "+extension);
    }
}
