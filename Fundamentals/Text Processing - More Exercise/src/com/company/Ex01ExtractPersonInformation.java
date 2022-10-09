package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Map<String,Integer>nameAge=new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            String input= scanner.nextLine();
            int startIndex=input.indexOf("@");
            int endIndex=input.indexOf("|");
            String name=input.substring(startIndex+1,endIndex);
            startIndex=input.indexOf("#");
            endIndex=input.indexOf("*");
            int age=Integer.parseInt(input.substring(startIndex+1,endIndex));
            nameAge.put(name,age);
        }
        nameAge.forEach((k,v)-> System.out.printf("%s is %d years old.%n",k,v));
    }
}
